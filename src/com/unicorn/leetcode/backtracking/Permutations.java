package com.unicorn.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    List<List<Integer>> results = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        helper(0, nums);
        return results;

    }

    private void helper(int start, int[] nums){
        if (start == nums.length -1){
            List<Integer> r = new ArrayList();
            for(int n: nums){
                r.add(n);
            }
            results.add(r);
            return;
        }
        for(int i=start;i<nums.length;i++){
            swap(nums, i, start);
            helper(start+1, nums);
            swap(nums, i, start);
        }

    }

    private void swap(int[] nums, int start, int end){
        if(start != end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }
}
