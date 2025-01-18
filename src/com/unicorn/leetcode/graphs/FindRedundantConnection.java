package com.unicorn.leetcode.graphs;

import java.util.ArrayList;
import java.util.List;

public class FindRedundantConnection {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        for (int i = 0; i < edges.length; i++) parent[i] = i;

        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1])) return edge;
            else union(
                    edge[0],
                    edge[1]
            );
        }

        return new int[2];
    }

    public int find(int x) {
        if (x == parent[x]) return x;
        return find(parent[x]);
    }

    public void union(int x, int y) {
        parent[find(y)] = find(x);
    }

    public static void main(String[] args) {
        int[][] edges = new int[10][2];
        //[1,4],[2,8],[1,6],[7,9],[6,10],[1,7],[2,3],[8,9],[5,9]
        edges[0] = new int[]{3,7};
        edges[1] = new int[]{1,4};
        edges[2] = new int[]{2,8};
        edges[3] = new int[]{1,6};
        edges[4] = new int[]{7,9};
        edges[5] = new int[]{6,10};
        edges[6] = new int[]{1,7};
        edges[7] = new int[]{2,3};
        edges[8] = new int[]{8,9};
        edges[9] = new int[]{5,9};

        FindRedundantConnection f = new FindRedundantConnection();
        f.findRedundantConnection(edges);




    }
}
