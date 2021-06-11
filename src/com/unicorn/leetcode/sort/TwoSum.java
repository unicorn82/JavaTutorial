package com.unicorn.leetcode.sort;

import com.unicorn.utils.CollectionsUtils;

import java.util.*;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indiceMap = new HashMap();
        int[] rs = new int[2];
        for(int i=0;i<nums.length;i++){
            int rest = target - nums[i];
            if(indiceMap.get(rest) != null){
                rs[0] = indiceMap.get(rest);
                rs[1] = i;
                return rs;
            }
            indiceMap.put(nums[i], i);
        }
        return rs;



    }

    public static void main(String[] args) {

        int[] nums = new int[]{2,7,11,15};
        TwoSum t = new TwoSum();
        CollectionsUtils.printArray(t.twoSum(nums, 9));

    }
}
