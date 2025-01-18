package com.unicorn.leetcode.greedy;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {

        int result = nums[0];
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(sum < 0) sum = 0;
            sum += nums[i];
            result = Math.max(sum, result);
        }
        return result;

    }


}
