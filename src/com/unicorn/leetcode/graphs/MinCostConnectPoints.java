package com.unicorn.leetcode.graphs;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MinCostConnectPoints {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a,b)->a[0]-b[0]);
        int result = 0;
        HashSet visited = new HashSet<Integer>();
        int[] point = points[0];
        visited.add(0);

        while(visited.size() < points.length){
            for(int i=0;i<points.length;i++){
                if(visited.contains(i)) continue;
                int distance = Math.abs(points[i][0]-point[0])+Math.abs(points[i][1]-point[1]);
                minHeap.add(new int[]{distance, i});
            }
            while(!minHeap.isEmpty()){
                int[] pointObj = minHeap.poll();
                if(visited.contains(pointObj[1])) continue;
                result += pointObj[0];
                visited.add(pointObj[1]);
                point = points[pointObj[1]];
                break;
            }

        }


        return result;

    }

    public static void main(String[] args) {

        int[] p1 = new int[]{0,0};
        int[] p2 = new int[]{2,2};
        int[] p3 = new int[]{3,10};
        int[] p4 = new int[]{5,2};
        int[] p5 = new int[]{7,0};
        int[][] points = new int[][]{p1,p2,p3,p4,p5};
        MinCostConnectPoints m = new MinCostConnectPoints();
        System.out.println(m.minCostConnectPoints(points));
    }

}
