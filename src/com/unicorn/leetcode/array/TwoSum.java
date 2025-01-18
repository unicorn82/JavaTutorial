package com.unicorn.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map m = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(m.containsKey(nums[i])){
                return new int[]{i, (int) m.get(nums[i])};
            }
            int s = target - nums[i];
            m.put(s, i);
        }
        return null;


    }
}
