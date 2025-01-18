package com.unicorn.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {
    List<String> results = new ArrayList();

    private static final String[] digitToLetters = {"",    "",    "abc",  "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return results;

        dfs(digits, 0, new StringBuilder());
        return results;


    }

    private void dfs(String digits, int index, StringBuilder combin){
        if(index>= digits.length()){
            results.add(combin.toString());
            return;
        }
        String letters = digitToLetters[digits.charAt(index)-'0'];
        for(int i=0;i<letters.length();i++){

            combin.append(letters.charAt(i));
            dfs(digits, index+1, combin);
            combin.deleteCharAt(combin.length()-1);
            //combin = combin.substring(0, combin.length()-1);
        }


    }
}
