package com.unicorn.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> results = new ArrayList();
    public List<List<Integer>> subsets1(int[] nums) {
        results.add(new ArrayList());
        for(int i=0;i<nums.length;i++){
            int size = results.size();
            for(int j=0;j<size;j++){
                dfs(j, nums[i]);
            }
        }
        return results;

    }

    private void dfs(int j, int num){
        ArrayList<Integer> list = (ArrayList<Integer>) results.get(j);
        results.add((ArrayList)list.clone());
        list.add(num);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(ans, 0, nums, list);
        return ans;
    }

    public void helper(
            List<List<Integer>> ans,
            int start,
            int[] nums,
            List<Integer> list
    ) {
        if (start >= nums.length) {
            ans.add(new ArrayList<>(list));
        } else {
            // add the element and start the  recursive call
            list.add(nums[start]);
            helper(ans, start + 1, nums, list);
            // remove the element and do the backtracking call.
            list.remove(list.size() - 1);
            helper(ans, start + 1, nums, list);
        }
    }
}
