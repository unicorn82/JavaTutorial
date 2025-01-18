package com.unicorn.leetcode.array;

public class GetConcatenation {

    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length*2];
        System.arraycopy(nums,0,ans,0,nums.length);
        System.arraycopy(nums,0,ans,nums.length,nums.length);
        // for(int i=0;i<nums.length;i++){
        //     ans[i] = nums[i];
        //     ans[i+nums.length] = nums[i];
        // }
        return ans;

    }

}
