package com.unicorn.leetcode.dynamic;

public class Rob {
    public int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;

        for(int i=0;i<nums.length;i++){
            int temp = rob1;
            rob1 = rob2 + nums[i];
            rob2 = Math.max(temp, rob2);

        }
        return Math.max(rob1, rob2);
    }
}
