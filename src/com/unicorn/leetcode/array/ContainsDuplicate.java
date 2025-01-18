package com.unicorn.leetcode.array;

import java.lang.reflect.Array;
import java.util.*;

public class ContainsDuplicate {
    public boolean ContainsDuplicate(int[] nums){
        Set<Integer> set = new HashSet<Integer>();
        for(int v: nums){
            if(!set.add(v))
                return true;
        }
        return false;
    }

    public boolean ContainsDuplicate1(int[] nums){
        Arrays.sort(nums); //O(nlogn)
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {

    }
}
