package com.unicorn.leetcode.bit;

public class HammingWeight {

    public int hammingWeight(int n) {
        int count = 0;
        for(int i=0;i<32;i++){
            if( (n & 1) == 1){
                count++;
            }
            n>>=1;
        }
        return count;
    }

    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 00000000000000000000000000001010;

        System.out.println(n);
        System.out.println(n & 1);
        System.out.println(n | 1);
        System.out.println(n^(n-1));
    }
}
