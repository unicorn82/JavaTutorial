package com.unicorn.leetcode.graphs;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] ==1){
                    maxArea = Math.max(dfs(grid, i, j), maxArea);
                }
            }
        }
        return maxArea;


    }

    private int dfs(int[][] grid, int row, int col){
        int area = 0;
        if(row >= grid.length || row < 0 || col >= grid[0].length || col <0 ||  grid[row][col] == 0)
        {
            return area;
        }
        grid[row][col] = 0;
        area++;
        area += dfs(grid, row+1, col);
        area += dfs(grid, row-1, col);
        area += dfs(grid, row, col+1);
        area += dfs(grid, row, col-1);

        return area;
    }
}
