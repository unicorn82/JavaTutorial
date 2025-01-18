package com.unicorn.leetcode.bit;

public class GetSum {
    public int getSum(int a, int b) {
        int result = a;
        while(b != 0){
            result = a ^ b;
            b = (a & b) << 1;
            a = result;
        }
        return result;


    }
}
