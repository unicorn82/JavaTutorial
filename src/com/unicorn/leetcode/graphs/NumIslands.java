package com.unicorn.leetcode.graphs;

public class NumIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        if(grid.length == 0 || grid[0].length == 0){
            return count;
        }
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){

                if(grid[i][j] == '1'){

                    count++;
                    visit(grid, i, j);
                }
            }
        }
        return count;

    }

    private void visit(char[][] grid,  int row, int col){
        if(row >= grid.length || col >= grid[0].length || row < 0 || col < 0 || grid[row][col] == '0'){
            return ;
        }
        grid[row][col] = '0';
        visit(grid, row+1, col);
        visit(grid, row, col+1);
        visit(grid, row-1, col);
        visit(grid, row, col-1);
        return ;
    }
}
