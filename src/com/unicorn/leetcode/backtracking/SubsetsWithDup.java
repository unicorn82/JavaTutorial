package com.unicorn.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SubsetsWithDup {

    List<List<Integer>> results = new ArrayList();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList();
        dfs(list, 0, nums);
        return results;



    }

    private void dfs(List<Integer> list, int index, int[] nums){
        if(index >= nums.length){
            results.add(new ArrayList(list));
            return;
        }
        list.add(nums[index]);
        dfs(list, index+1, nums);
        list.remove(list.size()-1);
        int target = index +1;
        while(target < nums.length && nums[target] == nums[index]){
            target++;
        }

        dfs(list, target, nums);



    }

    public void subSet(
            int[] nums,
            int idx,
            List<List<Integer>> ans,
            List<Integer> list
    ) {
        ans.add(new ArrayList<>(list));

        for (int i = idx; i < nums.length; i++) {
            //skip the duplicate elements
            if (i > idx && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            subSet(nums, i + 1, ans, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        subsetsWithDup.subsetsWithDup(new int[]{1,2,2});
    }
}
