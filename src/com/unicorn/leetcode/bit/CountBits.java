package com.unicorn.leetcode.bit;

public class CountBits {

    public int[] countBits(int n) {
        int[] result = new int[n+1];
        int offset = 0;
        for(int i=1;i<n+1;i++){
            if( (i & (i-1)) == 0){
                offset = i;
            }
            result[i] = 1+result[i-offset];
        }
        return result;
    }

    public static void main(String[] args) {
        int n =11;
        System.out.println(n & n-1);
    }

}
