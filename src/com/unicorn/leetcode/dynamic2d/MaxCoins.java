package com.unicorn.leetcode.dynamic2d;

public class MaxCoins {

    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        return burstLast(nums, 0, nums.length-1, dp);
    }


    private int burstLast(int[] nums, int left, int right, int[][] dp){


        if (left > right) {
            return 0;
        }
        if (dp[left][right] != 0) {
            return dp[left][right];
        }
        for (int i = left; i <= right; i++) {

            int coin = nums[i];

            //coin * (left -1) * (right+1)
            if(left -1 >= 0 ) coin = coin* nums[left-1];
            if( right +1 < nums.length) coin = coin*nums[right+1];

            coin += burstLast(nums, left, i -1, dp) + burstLast(nums, i+1, right, dp );

            dp[left][right] = Math.max(dp[left][right], coin);
        }
        return dp[left][right];
    }
}
