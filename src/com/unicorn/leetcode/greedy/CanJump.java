package com.unicorn.leetcode.greedy;

public class CanJump {

    public boolean canJump(int[] nums) {
        int pos = nums.length -1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i] >= pos - i){
                pos = i;
            }
        }
        return pos == 0;
    }

    public boolean canJump1(int[] nums) {
        Boolean[] cache = new Boolean[nums.length];
        // cache[nums.length-1] = true;
        return jump(nums, 0, cache);

    }

    private boolean jump(int[] nums, int position, Boolean[] cache){

        if(position >= nums.length-1) return true;
        if(cache[position] != null) return cache[position];
        for(int i=nums[position];i>0;i--){
            if(jump(nums, position+i, cache)){
                cache[position] = true;
                return cache[position];

            }
        }

        cache[position] = false;


        return cache[position];
    }
}
