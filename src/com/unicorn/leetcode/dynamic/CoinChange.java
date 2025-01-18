package com.unicorn.leetcode.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CoinChange {
    int result = Integer.MAX_VALUE;

    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i=1; i<=amount;i++){
            for(int coin: coins){
                if((i-coin)>=0){
                    dp[i] = Math.min(dp[i], 1+dp[i-coin]);
                }
            }
        }
        return dp[amount] == amount+1? -1:dp[amount];


    }


    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> cache = new HashMap();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        int round = 0;
        int num = 1;
        boolean isOverAmount = false;
        while(!isOverAmount){
            round++;
            num = queue.size();
            isOverAmount = true;
            while(num > 0) {
                num --;
                int base = queue.poll();
                if(base < amount) isOverAmount = false;
                for (int i = 0; i < coins.length; i++) {
                    int target = base + coins[i];
                    if (!cache.containsKey(target)) {
                        cache.put(target, round);
                        queue.add(target);
                        if(target == amount){
                            return round;
                        }

                    }
                }
            }

        }

        return  -1;


    }



    public static void main(String[] args) {
        int amount = 11;
        int[] coins = new int[]{1,2,5};
        CoinChange c = new CoinChange();
        System.out.println(c.coinChange(coins, amount));
    }
}
