package com.unicorn.leetcode.bit;

public class ReverseBits {

    public int reverseBits(int n) {
        int result = 0;
        for(int i=0;i<32;i++){
            result = result<<1;
            result = result | (n & 1);
            n = n>>1;

        }
        return result;

    }

    public static void main(String[] args) {
        int n = 0b00000010100101000001111010011100;
        ReverseBits r = new ReverseBits();
        r.reverseBits(n);
        System.out.println(n<<1);
    }


}
