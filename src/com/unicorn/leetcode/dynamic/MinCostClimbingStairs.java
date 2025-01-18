package com.unicorn.leetcode.dynamic;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {

        int size = cost.length;

        int[] temp = new int[size+2];
        for(int i=0;i<size; i++){
            int target = temp.length-i-3;
            temp[target] = Math.min((cost[size-i-1] + temp[target+1]), cost[size-i-1] + temp[target+2]);

        }


        return Math.min(temp[0], temp[1]);
    }

}
