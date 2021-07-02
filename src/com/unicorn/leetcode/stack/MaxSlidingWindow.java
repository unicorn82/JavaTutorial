package com.unicorn.leetcode.stack;

import java.util.PriorityQueue;

class maxHeap {

    public maxHeap(){

    }

    public int[] getMaxSlidingWindow(int[] nums, int k) {
        int[] max_nums = new int[nums.length-k+1];
        PriorityQueue queue = new PriorityQueue(k);
        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);
            if(queue.size() == k){
                max_nums[i+1-k] = (int)queue.peek();
            }
            else if(queue.size()>k){
                int p = (int)queue.poll();
            }

        }

        return max_nums;


    }




}

public class  MaxSlidingWindow{

    public static void main(String[] args) {
        System.out.println("start");
//        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
//        maxHeap m = new maxHeap();
//        m.getMaxSlidingWindow(nums, 3);

    }

}
