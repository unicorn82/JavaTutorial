package com.unicorn.leetcode.heap;

import java.util.*;

public class KClosest {
    class Points {
        int[] point;
        int distance;
        public Points(int[] p){
            this.point = new int[2];
            this.point[0] = p[0];
            this.point[1] = p[1];
            this.distance = p[0]*p[0]+p[1]*p[1];

        }

        public int getDistance(){
            return this.distance;
        }

        public int[] getPoint(){
            return point;
        }
    }

    public int[][] kClosest(int[][] points, int k) {


        Queue<Points> heap = new PriorityQueue(new Comparator<Points>() {
            @Override
            public int compare(Points o1, Points o2) {
                return o1.getDistance() - o2.getDistance();
            }
        });

        for(int[] point: points){
            Points p = new Points(point);
            heap.add(p);

        }
        int index = 0;
        int[][] results = new int[k][2];
        while(index < k){
            results[index] = heap.poll().getPoint();
            index++;

        }
        return results;

    }

    public static void main(String[] args) {
        KClosest k = new KClosest();
        int[] n1 = new int[]{1,3};
        int[] n2 = new int[]{-2,2};
        int[][] nums = new int[][]{n1,n2};
        k.kClosest(nums, 1);
    }



}
