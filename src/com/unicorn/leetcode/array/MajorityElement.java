package com.unicorn.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer count = 0;
        for (int i = 0; i < nums.length ; i++) {
            if(map.containsKey(nums[i])){
                count = map.get(nums[i]);
                count = count+1;


            }else{
                count = 1;

            }
            map.put(nums[i], count);
            if(count>nums.length/2){
                return nums[i];
            }

        }

        return -1;


    }

    public static void main(String[] args) {
        MajorityElement m =  new MajorityElement();
        int[] nums = new int[]{2,2,1,1,1,2,2};

        System.out.println(m.majorityElement(nums));


    }
}
