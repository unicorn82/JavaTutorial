package com.unicorn.leetcode.dynamic2d;

public class MaxProfit {

    public int maxProfit1(int[] prices) {
        int[][] maxProfitPerDay = new int[prices.length+2][2];
        for(int i= prices.length -1; i>=0; i--){
            maxProfitPerDay[i][0] = Math.max( maxProfitPerDay[i+1][1] - prices[i], maxProfitPerDay[i+1][0]); //buy
            maxProfitPerDay[i][1] = Math.max( maxProfitPerDay[i+2][0] + prices[i], maxProfitPerDay[i+1][1]); //sell
        }

        return maxProfitPerDay[0][0];

    }


    public int maxProfit(int[] prices) {
        Integer[][] maxProfitPerDay = new Integer[prices.length][2];

        return trade(prices, 0, 0, maxProfitPerDay);

    }

    public int trade(int[] prices, int day, int type, Integer[][] maxProfitPerDay){
        if(day >= prices.length) return 0;
        if(maxProfitPerDay[day][type] != null) return maxProfitPerDay[day][type];
        int profit;
        if(type == 0){ //buy
            profit = maxProfitPerDay[day][type] = Math.max(trade(prices, day+1, 1, maxProfitPerDay) - prices[day], trade(prices, day+1, 0, maxProfitPerDay));


        }else{ //sell
            profit = maxProfitPerDay[day][type] = Math.max(trade(prices, day+2, 0, maxProfitPerDay) + prices[day], trade(prices, day+1, 1, maxProfitPerDay));
        }
        return profit;
    }
}
