package com.unicorn.leetcode.slidewindow;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MaxProfit {
    public int maxProfit_brute(int[] prices) {
        int max = 0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1; j<prices.length;j++){
                int profit = prices[j] - prices[i];
                max = Math.max(max, profit);
            }
        }
        return max;


    }

    public int maxProfit(int[] prices) {


            int max = 0;
            int buy = prices[0];
            for(int i=1;i<prices.length;i++){
                if(prices[i] < buy){
                    buy = prices[i];

                }


                max = Math.max(max, prices[i] - buy);

            }


            return max;


        }



}
