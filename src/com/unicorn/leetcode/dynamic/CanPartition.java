package com.unicorn.leetcode.dynamic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CanPartition {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n:nums){
            sum += n;
        }
        if(sum %2 == 1) return false;
        HashSet<Integer> cache = new HashSet();
        cache.add(0);
        List<Integer> toAdd = new ArrayList<>();
        for(int n: nums){
            Iterator<Integer> it = cache.iterator();

            while(it.hasNext()){
                int temp = it.next()+n;
                if(temp == sum/2) return true;
                if(!cache.contains(temp)){
                    toAdd.add(temp);
                }
            }
            cache.addAll(toAdd);
            toAdd.clear();

        }

        return false;
    }

    HashSet<Integer> cache = new HashSet();
    public boolean canPartitionBF(int[] nums) {
        int sum = 0;
        for(int n:nums){
            sum += n;
        }
        if(sum %2 == 1) return false;

        return sumSubList(nums, 0, 0, sum/2);
    }

    private boolean sumSubList(int[] nums, int index, int sum, int target){

        if(index >= nums.length || cache.contains(sum)) return false;
        if(sum == target) return true;
        if(sum > target) {
            cache.add(sum);
            return false;
        }
        if(sumSubList(nums, index+1, sum+nums[index], target)){
            return true;
        }else{
            return sumSubList(nums, index+1, sum, target);
        }


    }
}
