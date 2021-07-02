package com.unicorn.leetcode.greedy;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int profit =0;

        int buyIdx = findBuyDate(prices, 0);
        int sellIdx = findSellDate(prices, buyIdx);

        while (buyIdx!=-1 ){
            profit += prices[sellIdx]-prices[buyIdx];

            buyIdx = findBuyDate(prices, sellIdx+1);
            sellIdx = findSellDate(prices, buyIdx);
        }

        return profit;



    }

    private int findBuyDate(int[] prices, int start){
        int buyIdx = start;
        if(start<prices.length-1) {
            for (int i = start + 1; i < prices.length; i++) {

                if (prices[i] < prices[buyIdx]) {
                    buyIdx = i;
                } else {
                    return buyIdx;

                }


            }
        }
        return -1;

    }

    private int findSellDate(int[] prices, int buyIdx){
        int sellIdx = buyIdx;
        if(sellIdx < prices.length-1 && buyIdx!= -1) {
            for (int i = sellIdx + 1; i < prices.length; i++) {
                if (prices[i] > prices[sellIdx]) {
                    sellIdx = i;
                } else {
                    return sellIdx;

                }


            }
        }
        return sellIdx;


    }

    public static void main(String[] args) {
//        int[] nums = new int[]{7,1,5,3,6,4};
        int[] nums = new int[]{1,2,3,4,5};
        MaxProfit m = new MaxProfit();
        System.out.println(m.maxProfit(nums));
    }


}
