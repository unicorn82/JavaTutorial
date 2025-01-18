package com.unicorn.leetcode.intervals;

import com.unicorn.utils.CollectionsUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinInterval {

    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b)->a[0] - b[0]);
        int[] temp = Arrays.copyOf(queries, queries.length);
        Arrays.sort(temp);
        int[] results = new int[queries.length];
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<int[]> pg = new PriorityQueue<int[]>((a,b) ->(a[0] - b[0])); //size, start, end
        int step = 0;
        for(int i=0;i<temp.length;i++){
            int q = temp[i];

            while(step < intervals.length){

                if(intervals[step][0] <= q ){

                    pg.add(new int[]{intervals[step][1] - intervals[step][0]+1, intervals[step][0], intervals[step][1]});
                    step++;


                }else{
                    break;
                }

            }
            while(!pg.isEmpty()) {

                int[] top = pg.peek();

                if (top[1] <= q && top[2] >= q) {
                    map.put(q, top[0]);
                    break;
                } else {
                    pg.poll();
                }
            }

        }

        for(int i=0;i<results.length;i++){
            results[i] = map.containsKey(queries[i])?map.get(queries[i]): -1;
        }



        return results;




    }
    public int[] minInterval1(int[][] intervals, int[] queries) {
        int[] results = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int size = Integer.MAX_VALUE;
            for(int j=0;j<intervals.length;j++){
                if(intervals[j][0] <= queries[i] && intervals[j][1] >= queries[i]){
                    size = Math.min(size, intervals[j][1] - intervals[j][0]+1);
                }


            }
            results[i] = size ==Integer.MAX_VALUE? -1: size;
        }

        return results;

    }

    public static void main(String[] args) {

        int[] in1 = new int[]{1,4};
        int[] in2 = new int[]{2,4};
        int[] in3 = new int[]{3,6};
        int[] in4 = new int[]{4,4};
        int[][] intervals = new int[][]{in1,in2,in3,in4};
        int[] queries = new int[]{2,3,4,5};
        MinInterval m = new MinInterval();
        int[] results = m.minInterval(intervals, queries);
        CollectionsUtils.printArray(results);

    }
}
