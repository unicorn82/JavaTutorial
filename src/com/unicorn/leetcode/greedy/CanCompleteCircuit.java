package com.unicorn.leetcode.greedy;

public class CanCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        int total_diff = 0;
        for(int i=0;i<gas.length;i++){
            diff[i] = gas[i] - cost[i];
            total_diff += diff[i];

        }
        if(total_diff < 0) return -1;
        int total = 0;
        int result = 0;
        for(int i=0;i<gas.length;i++){
            total += diff[i];
            if(total < 0) {
                total = 0;
                result = i+1;
            }

        }

        return result;

    }

}
