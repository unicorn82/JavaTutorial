package com.unicorn.leetcode.stack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueTester {

    class PointWithDistance {
        int[] point;
        int distance;

        PointWithDistance(int[] point){
            this.point = point;
            this.distance = getDistance(point);
        }

        private int getDistance(int[] p){
            return (point[0]*point[0]+point[1]*point[1]);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<PointWithDistance> pg = new PriorityQueue<PointWithDistance>( (o1, o2) -> (o2.distance - o1.distance));
        for(int i=0;i<points.length;i++){
            pg.add(new PointWithDistance(points[i]));
        }
        List<int[]> results = new ArrayList();
        while(k>0){
            if(k == 1){
                results.add(pg.poll().point);

            }else{
                PointWithDistance p = pg.poll();
                if(p.distance == pg.peek().distance){
                    results.add(p.point);
                }else{
                    results.clear();
                }

            }
            k--;
        }
        int[][] array = new int[results.size()][2];
        return results.toArray(array);


    }


    public static void main(String[] args) {

    }
}
