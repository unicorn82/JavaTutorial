package com.unicorn.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> results = new ArrayList();
    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList();

        dfs(s, list,0);
        return results;
    }

    private void dfs(String s, List<String> list, int index){
        if(index>=s.length()){
            results.add(new ArrayList(list));
            return;
        }
        for(int i=index; i<s.length();i++){
            if(validate(s, index, i)){
                list.add(s.substring(index, i+1));
                dfs(s, list, i+1);
                list.remove(list.size()-1);
            }
        }
    }


    private boolean validate(String s, int start, int end){

        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;


    }
}
