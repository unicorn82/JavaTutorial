package com.unicorn.leetcode.dynamic2d;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniquePaths {

    public int uniquePaths_best(int m, int n) {

        int[][] grid = new int[m][n];
        for(int i= m-1; i>=0;i--){
            for(int j = n-1; j>=0; j--){
                if(i == (m-1) || j == (n-1)){
                    grid[i][j] = 1;
                }else{
                    grid[i][j] = grid[i+1][j]+grid[i][j+1];
                }

            }
        }

        return grid[0][0];

    }



    public int uniquePaths(int m, int n) {

        int[][] grid = new int[m][n];
        grid[m-1][n-1] = 1;

        return moveForward(new int[]{0,0}, grid, m,n);

    }

    private int moveForward(int[] pos,  int[][]grid, int m, int n ){

        if(pos[0] >=m || pos[1] >= n) return  0;
        if(grid[pos[0]][pos[1]]> 0) return grid[pos[0]][pos[1]];


        int paths = moveForward(new int[]{pos[0]+1, pos[1]},grid, m, n) + moveForward(new int[]{pos[0], pos[1]+1},grid, m, n);
        grid[pos[0]][pos[1]] = paths;

        return paths;

    }
public static void main(String[] args) {
    UniquePaths u  = new UniquePaths();
    System.out.println(u.uniquePaths(3,7));

}


}


