package com.unicorn.leetcode.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindCheapestPrice {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] finalPrices = new int[n];
        for(int i=0;i < n;i++){
            finalPrices[i] = Integer.MAX_VALUE;
        }
        finalPrices[src] = 0;
        int[] tempPrices = Arrays.copyOf(finalPrices, n);
        int stop = 0;
        while(stop <= k){
            for(int i=0;i<flights.length;i++){
                if(finalPrices[flights[i][0]] != Integer.MAX_VALUE){
                    tempPrices[flights[i][1]] = Math.min(finalPrices[flights[i][0]]+flights[i][2] , tempPrices[flights[i][1]]);
                }

            }
            finalPrices = Arrays.copyOf(tempPrices, n);
            stop++;
        }
        return finalPrices[dst] != Integer.MAX_VALUE?finalPrices[dst]:-1;

    }

    public static void main(String[] args) {
        int[][] flights = {{ 0,3,3},{3,4,3},{4,1,3},{0,5,1},{5,1,100},{0,6,2},{6,1,100},{0,7,1},{7,8,1},{8,9,1},{9,1,1},{1,10,1},{10,2,1},{1,2,100}};
        int n =11;
        int src = 0;
        int k = 4;
        int dst = 2;
        FindCheapestPrice f = new FindCheapestPrice();
        System.out.println(f.findCheapestPrice(n, flights, src, dst, k));



    }
}
