package com.unicorn.leetcode.graphs;

import java.util.PriorityQueue;
import java.util.Queue;

public class SwimInWater {
    public int swimInWater(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> minHeap = new PriorityQueue<int[]>((a, b)->a[0] - b[0]);

        int[][] path = new int[row][col];
        int[][] visited = new int[row][col];
        minHeap.add(new int[]{0, 0, 0}); //distance, row, col
        while(!minHeap.isEmpty()){
            int[] node = minHeap.poll();
            path[node[1]][node[2]] = node[0];
            visited[node[1]][node[2]] = 1;
            if(node[1] == (row -1) && node[2] == (col -1)){
                return node[0];
            }
            if((node[2]+1) < col && visited[node[1]][node[2]+1] == 0){ //right
                minHeap.add(new int[]{Math.max(grid[node[1]][node[2]+1],node[0]),node[1], node[2]+1 });
            }

            if(node[2] > 0 && visited[node[1]][node[2]-1] == 0){ //left
                minHeap.add(new int[]{Math.max(grid[node[1]][node[2]-1],node[0]),node[1], node[2]-1 });
            }
            if(node[1] > 0 && visited[node[1]-1][node[2]] == 0){ //up
                minHeap.add(new int[]{Math.max(grid[node[1]-1][node[2]],node[0]),node[1]-1, node[2] });
            }
            if((node[1]+1) < row && visited[node[1]+1][node[2]] == 0){ //down
                minHeap.add(new int[]{Math.max(grid[node[1]+1][node[2]],node[0]),node[1]+1, node[2] });
            }


        }
        return -1;

    }
}
