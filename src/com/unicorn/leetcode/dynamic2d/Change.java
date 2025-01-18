package com.unicorn.leetcode.dynamic2d;

public class Change {

    public int change(int amount, int[] coins) {

        int[] cur = new int[amount+1];
        cur[0] =1;
        for(int i = 0; i<coins.length; i++){
            for(int j = 0;j<=amount;j++){
                int temp = j - coins[i];
                if(temp >= 0) cur[j] += cur[temp];

            }

        }
        return cur[amount];

    }


    public int change1(int amount, int[] coins) {
        return ans(amount, coins, 0);

    }

    private int ans(int amount, int[] coins, int index){
        if (amount == 0) return 1; //success
        if( amount < 0) return 0; //failre
        int result = 0;
        for(int i=index; i<coins.length;i++){
            result += ans(amount-coins[i], coins, i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] coins = new int[] {1,2,5};
        Change c = new Change();
        System.out.println(c.change(5, coins));
    }
}
