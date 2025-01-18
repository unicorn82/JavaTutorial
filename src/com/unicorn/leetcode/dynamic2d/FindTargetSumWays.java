package com.unicorn.leetcode.dynamic2d;

import java.util.HashMap;
import java.util.Map;

public class FindTargetSumWays {

    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> cache = new HashMap();

        return find(nums, 0, target, cache);

    }

    private int find(int[] nums, int index, int target, Map<String, Integer> cache){
        if(index == nums.length){
            return target == 0? 1: 0;
        }
        if(cache.containsKey(index+"|"+target)){
            return cache.get(index+"|"+target);
        }
        int result = find(nums, index+1, target-nums[index], cache)+find(nums, index+1, target+nums[index], cache);
        cache.put(index+"|"+target, result);
        return result;
    }
}
