package com.unicorn.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class LongestConsecutive {

    public int longestConsecutive_On(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return nums.length;
        int result = 0;
        Map<Integer,Integer> cache = new HashMap();
        for(int n:nums){
            cache.put(n, 0);

        }
        for(int n: nums){
            result = Math.max(result, count(n, cache));
        }
        return result;
    }

    private int count(int n, Map<Integer,Integer> cache){
        if(!cache.containsKey(n)) return 0;
        int sequence = cache.get(n);
        if(sequence > 0) return sequence;
        sequence = count(n-1, cache)+1;
        cache.put(n, sequence);
        return sequence;


    }

    public int longestConsecutive_sort(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 1;
        int result = 1;
        for(int i=1;i<nums.length;i++){
            if( nums[i] - nums[i-1] == 1) {
                count++;
                result = Math.max(count, result);
            }else if(nums[i] - nums[i-1] > 1){
                count = 1;
            }

        }
        return result;


    }

    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        int seq_length = 1;
        int max_seq_length = 1;

        Set<Integer> set = new HashSet<Integer>();
        for(int n: nums){
            set.add(n);

        }

        for(int n: set){
            if(!set.contains(n-1)){
                seq_length = 1;
                int temp = n;
                while(set.contains(++temp)){
                    seq_length ++;
                    set.remove(temp);


                }
                max_seq_length = seq_length>max_seq_length? seq_length:max_seq_length;
            }
            //set.remove(n);

        }

        return max_seq_length;

    }
    public int longestConsecutive1(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        int seq_length = 1;
        int max_seq_length = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int n: nums){
            pq.add(n);
        }
        int previous = pq.poll();
        System.out.println(previous);
        while(pq.peek()!= null){
//        for(int i=1;i<nums.length;i++){
            int current = pq.poll();
            System.out.println(current);
            if(current - previous == 1){
                seq_length ++;
                max_seq_length = seq_length>max_seq_length? seq_length:max_seq_length;
            }else if (current > previous){
                seq_length = 1;
            }

            previous = current;

        }
        return max_seq_length;

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0,3,7,2,5,8,4,6,0,1};
        LongestConsecutive l = new LongestConsecutive();
        System.out.println(l.longestConsecutive(nums1));
    }
}
