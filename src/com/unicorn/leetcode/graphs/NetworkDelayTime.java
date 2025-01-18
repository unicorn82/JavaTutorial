package com.unicorn.leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->a[0]-b[0]);
        HashSet<Integer> visited = new HashSet<>();
        int[] path = new int[n+1];
        List<List<int[]>> nodeMap = new ArrayList<>();

        //O(n)
        for(int i=0;i<path.length;i++){
            nodeMap.add(new ArrayList<>());
            path[i] = Integer.MAX_VALUE;
        }
        for(int i=0;i<times.length;i++){
            nodeMap.get(times[i][0]).add(times[i]);
        }
        int result = 0;
        //O(e)

        pq.add(new int[]{0, k});

        while(!pq.isEmpty()){
            int[] edge = pq.poll(); //0: distance to k, 1: target
            if(visited.contains(edge[1])) continue;

            result = Math.max(edge[0], result); //max distance
            if(path[edge[1]] > edge[0]) {
                path[edge[1]] = edge[0];
            }
            for (int[] e : nodeMap.get(edge[1])) {
                pq.add(new int[]{edge[0] + e[2], e[1]});
            }
            visited.add(edge[1]);

        }
        return visited.size() == n? result: -1;

    }

    public static void main(String[] args) {
        int[][] times = new int[3][];
        int[] t1 = new int[]{2,1,1};
        int[] t2 = new int[]{2,3,1};
        int[] t3 = new int[]{3,4,1};
        times[0] = t1;
        times[1] = t2;
        times[2] = t3;
        int n = 4, k = 2;

//        int[][] times2 = new int[1][];
//        times2[0] = new int[]{1,2,1};
//        n = 2;
//        k = 2;

        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        System.out.println(networkDelayTime.networkDelayTime(times,n,k ));
    }
}
