package com.unicorn.leetcode.bit;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result=nums[0];
        for(int i=1;i<nums.length;i++){
            result = result ^ nums[i];
        }
        return result;
    }
}
