package com.unicorn.leetcode.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList();
        int[][] visited = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                    visited[i][j] = 1;
                }
            }
        }
        int count = BFS(grid, visited, queue);


        for(int i=0;i<grid.length;i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }


        return count;

    }

    private int BFS(int[][] grid, int[][] visited, Queue<int[]> queue){
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            count++;

            while(size > 0){
                int[] orange = queue.poll();

                grid[orange[0]][orange[1]] = 2;
                if(orange[0] >0 && grid[orange[0]-1][orange[1]] == 1 && visited[orange[0]-1][orange[1]] != 1){
                    queue.add(new int[]{orange[0]-1, orange[1]});
                    visited[orange[0]-1][orange[1]] = 1;
                }
                if(orange[1] >0 && grid[orange[0]][orange[1]-1] == 1 && visited[orange[0]][orange[1]-1] != 1){
                    queue.add(new int[]{orange[0], orange[1]-1});
                    visited[orange[0]][orange[1]-1] = 1;
                }
                if(orange[0] < (grid.length-1) && grid[orange[0]+1][orange[1]] == 1 && visited[orange[0]+1][orange[1]] != 1){
                    queue.add(new int[]{orange[0]+1, orange[1]});
                    visited[orange[0]+1][orange[1]] = 1;
                }
                if(orange[1] < (grid[0].length-1) && grid[orange[0]][orange[1]+1] == 1 && visited[orange[0]][orange[1]+1] != 1){
                    queue.add(new int[]{orange[0], orange[1]+1});
                    visited[orange[0]][orange[1]+1] = 1;
                }
                size--;
            }



        }


        return count > 0 ? (count-1): 0;

    }

    public int orangesRotting2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int result = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    rotting(grid, visited, i, j, 0);

                }

            }

        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    if(visited[i][j] == 0){
                        return -1;
                    }
                    result = Math.max(visited[i][j], result);
                }

            }

        }
        return result;

    }

    public void rotting(int[][] grid,int[][] visited, int row, int col, int minute){
        if(row < 0 || col <0 || row >= grid.length || col >= grid[0].length) return;
        if(grid[row][col] == 0) return;

        if(grid[row][col] == 2 && minute > 0) return;
        if(grid[row][col] == 1){
            if(visited[row][col] > 0 && minute > visited[row][col]){
                return;

            }
            visited[row][col] = minute;

        }
        rotting(grid, visited, row+1, col, minute+1);
        rotting(grid, visited, row, col+1, minute+1);
        rotting(grid, visited, row-1, col, minute+1);
        rotting(grid, visited, row, col-1, minute+1);




    }

    public static void main(String[] args) {
//        int[][] grid = new int[4][2];
//
//        int[] g1 = new int[]{2,2};
//        int[] g2 = new int[]{1,1};
//        int[] g3 = new int[]{0,0};
//        int[] g4 = new int[]{2,0};
//        grid[0] = g1;
//        grid[1] = g2;
//        grid[2] = g3;
//        grid[3] = g4;

        int[][] grid = new int[3][3];
        int[] g1 = new int[]{2,1,1};
        int[] g2 = new int[]{1,1,0};
        int[] g3 = new int[]{0,1,1};

        grid[0] = g1;
        grid[1] = g2;
        grid[2] = g3;



        OrangesRotting or = new OrangesRotting();
        System.out.println(or.orangesRotting2(grid));
    }
}
