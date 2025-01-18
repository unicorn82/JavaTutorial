package com.unicorn.leetcode.dynamic2d;

public class NumDistinct {

    public int numDistinct(String s, String t) {
        Integer[][] dp = new Integer[t.length()+1][s.length()+1];

        calculate(s, t, 0 ,0 ,dp );
        return dp[0][0];


    }

    private int calculate(String s, String t, int row, int col, Integer[][] dp ){
        if(dp[row][col] != null) return dp[row][col];

        if(row == t.length()) {
            dp[row][col] = 1;
            return 1;
        }else if(col == s.length()) {
            dp[row][col] = 0;
            return 0;
        }


        if(s.charAt(col) == t.charAt(row)){

            dp[row][col] = calculate(s, t, row+1, col+1, dp)+calculate(s, t, row, col+1, dp);
        }else{
            dp[row][col] = calculate(s, t, row, col+1, dp);
        }
        return dp[row][col];

    }
}
