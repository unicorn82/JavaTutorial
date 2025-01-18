package com.unicorn.leetcode.math;

import java.util.HashSet;

public class IsHappy {
    public boolean isHappy(int n) {
        HashSet<Integer> cache = new HashSet();

        while(n != 1 && !cache.contains(n)){
            cache.add(n);
            n = getHappySum(n);

        }
        return n == 1;


    }

    private int getHappySum(int source){
        int sum = 0;
        while(source > 0) {
            int lastDigit = source % 10;
            sum += lastDigit * lastDigit;
            source = source /10;
        }
        return sum;
    }
}
