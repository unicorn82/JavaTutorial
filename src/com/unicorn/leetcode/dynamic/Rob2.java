package com.unicorn.leetcode.dynamic;

public class Rob2 {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(subRob(nums, 0, nums.length-1), subRob(nums, 1, nums.length));
    }

    private int subRob(int[] nums, int start, int end){
        int rob1 = 0;
        int rob2 = 0;
        for(int i=start;i<end;i++){
            int temp = rob1;
            rob1 = nums[i]+rob2;
            rob2 = Math.max(temp, rob2);
        }
        return Math.max(rob1, rob2);
    }
}
