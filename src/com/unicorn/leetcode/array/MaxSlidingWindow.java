package com.unicorn.leetcode.array;

import java.util.*;

public class MaxSlidingWindow {

    public Integer[] maxSlidingWindow1(int[] nums, int k) {
        if(nums.length < k){
            return null;
        }
        Integer[] max_nums = new Integer[nums.length-k+1];
        for(int i=0;i<max_nums.length;i++){
            int start = i;
            int end = i+k-1;
            int exclude = start -1;
            if(exclude < 0 ){
                max_nums[i] = returnMaxNum(nums, start, end);
            }else if(nums[end] > max_nums[i-1]){
                max_nums[i] = nums[end];

            }else if (nums[exclude] < max_nums[i-1]){
                max_nums[i] = max_nums[i-1];
            }else{
                max_nums[i] = returnMaxNum(nums, start, end);
            }

        }
        return max_nums;
    }

    public Integer[] maxSlidingWindow2(int[] nums, int k) {
        PriorityQueue queue = new PriorityQueue(Collections.reverseOrder());
        if (nums.length < k) {
            return null;
        }
        Integer[] max_nums = new Integer[nums.length-k+1];
        for (int i = 0; i < nums.length ; i++) {
            queue.offer(nums[i]);
            if(queue.size()>k){
                queue.remove(nums[i-k]);
            }
            if(queue.size() == k){
                max_nums[i+1-k] = (int)queue.peek();
            }

        }
        return max_nums;

    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque();
        if (nums.length < k) {
            return null;
        }
        int[] max_nums = new int[nums.length - k + 1];
        for(int i=0;i<nums.length;i++){

            if(deque.size()>0 && (i-deque.getFirst())==k) {
                deque.removeFirst();

            }
            while (deque.size()>0 && nums[deque.getLast()]<nums[i]){
                deque.removeLast();
            }
            deque.add(i);

            if(i >= k-1) {
                max_nums[i + 1 - k] = nums[(int) deque.getFirst()];
            }

        }
        return max_nums;



    }

    private int returnMaxNum(int[] nums, int start, int end){
        int max = nums[start];
        for(int i=start+1;i<=end;i++){
            if(nums[i] > max){
                max = nums[i];
            }

        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,1,2,0,5};
        int k = 3;
        MaxSlidingWindow max = new MaxSlidingWindow();
        max.maxSlidingWindow3(nums, k);


        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());

        // Adding items to the pQueue using add()
        pQueue.add(20);
        pQueue.add(10);
        pQueue.add(15);

        // Printing the top element of PriorityQueue
        System.out.println(pQueue.remove(10));

        // Printing the top element and removing it
        // from the PriorityQueue container
        System.out.println(pQueue.poll());

        System.out.println(pQueue.peek());

    }
}
