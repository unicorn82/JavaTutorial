package com.unicorn.leetcode.greedy;

public class Jump {

    public int jump(int[] nums) {
        return step(nums ,0, 0);

    }

    private int step(int[] nums, int start, int count){
        int result = Integer.MAX_VALUE;
        if(start >= nums.length-1) return count;
        for(int i=1;i<=nums[start];i++){
            result = Math.min(result, step(nums, start+i, count+1));

        }
        return result;
    }
}
