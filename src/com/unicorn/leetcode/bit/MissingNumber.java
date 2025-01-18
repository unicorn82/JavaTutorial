package com.unicorn.leetcode.bit;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int l = nums.length;
        int sum = l*(l+1)/2;
        for(int n: nums ){
            sum -= n;
        }
        return sum;

    }
}
