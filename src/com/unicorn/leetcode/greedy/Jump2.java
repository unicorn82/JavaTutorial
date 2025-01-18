package com.unicorn.leetcode.greedy;

public class Jump2 {

    public int jump(int[] nums) {
        int left = 0;
        int right = 0;
        int temp = right;
        int step = 0;
        while(right < nums.length-1){
            for(int i=left;i<=right;i++){
                temp = Math.max(i+nums[i], temp);
            }
            left = right +1;
            right = temp;
            step ++;
        }

        return step;

    }


    public int jump2(int[] nums) {
        int pos = nums.length -1;
        int step = 0;
        int[] steps = new int[nums.length];
        for(int i=nums.length -2;i>=0;i--){
            steps[i] = getMin(steps, i+1, i+nums[i])+1;
        }

        return steps[0];

    }

    private int getMin(int[] nums, int start, int end){
        int result = nums[start];
        end = end < nums.length ? end: nums.length-1;
        for(int i= start;i<=end;i++){
            result = Math.min(result, nums[i]);
        }
        return result;
    }
}
