package com.unicorn.leetcode.dynamic2d;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] grid = new Integer[text1.length()][text2.length()];

        return checkSub(text1, text2, text1.length()-1, text2.length()-1, grid);


    }

    private int checkSub(String text1, String text2, int t1, int t2, Integer[][] grid){
        if(t1 < 0 || t2 < 0) return 0;
        if(grid[t1][t2] != null) return grid[t1][t2];
        int paths = 0;
        if(text1.charAt(t1) == text2.charAt(t2)){
            paths = 1+checkSub(text1, text2, t1-1, t2-1, grid);
        }else{
            paths = Math.max(checkSub(text1, text2, t1-1, t2, grid), checkSub(text1, text2, t1, t2-1, grid));
        }
        grid[t1][t2] = paths;
        return paths;
    }
}
