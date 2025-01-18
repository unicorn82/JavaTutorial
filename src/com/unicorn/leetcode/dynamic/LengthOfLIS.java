package com.unicorn.leetcode.dynamic;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] cache = new int[nums.length];
        int result = 1;
        for(int i=nums.length-1;i>=0;i--){
            int num = nums[i];
            cache[i] = 1;
            for(int j = i+1;j < nums.length;j++){
                if(nums[j] <= nums[i]) continue;
                else{
                    cache[i] = Math.max(cache[i], cache[j]+1);
                    result = Math.max(cache[i], result);
                }

            }

        }
        return result;

    }
}
