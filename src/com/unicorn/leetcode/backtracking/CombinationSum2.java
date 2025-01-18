package com.unicorn.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> list = new ArrayList();
        Arrays.sort(candidates);
        helper(ans, list, 0, candidates, target);
        return ans;

    }

    private void helper(List<List<Integer>> ans, List<Integer> list, int index, int[] candidates, int target ){
        if(target ==0){
            ans.add(new ArrayList(list));
            return;
        }else if(index >= candidates.length || target < 0){
            return;
        }
        list.add(candidates[index]);
        helper(ans, list, index+1, candidates, target-candidates[index]);
        list.remove(list.size()-1);

        while((index+1) < candidates.length && candidates[index+1] == candidates[index]){
            index++;
        }
        helper(ans, list, index+1, candidates, target);
    }

    public void comb(
            int[] candidates,
            int target,
            List<List<Integer>> ans,
            List<Integer> ls,
            int index
    ) {
        if (target == 0) {
            ans.add(new ArrayList(ls));
        }
        else if (target < 0) return;
        else {
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) continue;
                ls.add(candidates[i]);
                comb(candidates, target - candidates[i], ans, ls, i + 1);
                ls.remove(ls.get(ls.size() - 1));
            }
        }
    }
}
