package com.unicorn.leetcode.dynamic2d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestIncreasingPath {

    public int longestIncreasingPath(int[][] matrix) {
        int result = 0;
        Integer[][] dp = new Integer[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                result = Math.max(validate(matrix, i, j, dp), result);
            }
        }
        return result;
    }

    private int validate(int[][] matrix, int row, int col, Integer[][] dp)
    {
        if(dp[row][col] != null) return dp[row][col];
        int val = matrix[row][col];
        dp[row][col] = 1;
        if(row > 0 && matrix[row-1][col] > val){ //up
            dp[row][col] = Math.max(dp[row][col], 1+validate(matrix, row-1,col,dp));
        }
        if(col > 0 && matrix[row][col-1] > val){ //left
            dp[row][col] = Math.max(dp[row][col], 1+validate(matrix, row,col-1,dp));
        }
        if(row < matrix.length-1 && matrix[row+1][col] > val){ //down
            dp[row][col] = Math.max(dp[row][col], 1+validate(matrix, row+1,col,dp));
        }
        if(col < matrix[0].length-1 && matrix[row][col+1] > val){ //left
            dp[row][col] = Math.max(dp[row][col], 1+validate(matrix, row,col+1,dp));
        }
        return dp[row][col];

    }

    public int longestIncreasingPath1(int[][] matrix) {
        int result = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        List<int[]> sortedItems = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                sortedItems.add(new int[] {matrix[i][j],i,j});
                dp[i][j] = 1;
            }
        }
        Collections.sort(sortedItems, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for(int[] ele: sortedItems){
            int val = ele[0];
            int row = ele[1];
            int col = ele[2];
            if(row > 0 && matrix[row-1][col] > val){ //up
                dp[row][col] = Math.max(dp[row][col], 1+dp[row-1][col]);
            }
            if(col > 0 && matrix[row][col-1] > val){ //left
                dp[row][col] = Math.max(dp[row][col], 1+dp[row][col-1]);
            }
            if(row < matrix.length-1 && matrix[row+1][col] > val){ //down
                dp[row][col] = Math.max(dp[row][col], 1+dp[row+1][col]);
            }
            if(col < matrix[0].length-1 && matrix[row][col+1] > val){ //left
                dp[row][col] = Math.max(dp[row][col], 1+dp[row][col+1]);
            }
            result = Math.max(dp[row][col], result);

        }
        return result;
    }

}
