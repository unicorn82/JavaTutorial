package com.unicorn.leetcode.dynamic2d;

import java.util.HashMap;
import java.util.Map;

public class IsInterLeave {

    public boolean isInterleave1(String s1, String s2, String s3) {
        if((s1.length() + s2.length()) != s3.length()) return false;
        boolean[][] grid = new boolean[s1.length()+1][s2.length()+1];
        grid[s1.length()][s2.length()] = true;
        for(int i=s1.length();i>=0;i--){
            for(int j=s2.length();j>=0;j--){
                if( i < s1.length() && s3.charAt(i+j) == s1.charAt(i) && grid[i+1][j] ){
                    grid[i][j] = true;
                    continue;

                }
                if(j < s2.length() && s3.charAt(i+j) == s2.charAt(j) && grid[i][j+1] ){
                    grid[i][j] = true;
                    continue;
                }

            }
        }
        return grid[0][0];

    }



    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][] cache = new Boolean[s1.length()+1][s2.length()+1];
        return validate(s1, 0, s2, 0, s3, 0, cache);

    }

    private boolean validate(String s1, int p1, String s2, int p2, String s3, int p3, Boolean[][] cache){
        if(p1 >= s1.length() && p2 >= s2.length() && p3 >= s3.length()){
            return true;
        }
        if(p3 >= s3.length()) return false;
        if(cache[p1][p2] != null) return cache[p1][p2];
        boolean b1 = false;
        boolean b2 = false;
        if(p1 < s1.length() && s1.charAt(p1) == s3.charAt(p3)){
            b1 = validate(s1, p1+1, s2, p2, s3, p3+1, cache);
        }
        if(p2 < s2.length() && s2.charAt(p2) == s3.charAt(p3) && !b1){
            b2 = validate(s1, p1, s2, p2+1, s3, p3+1, cache);
        }
        cache[p1][p2] = b1||b2;

        return b1 || b2;
    }
}
