package com.unicorn.leetcode.math;

public class PlusOne {

    public int[] plusOne(int[] digits) {

        int addition = 1;
        for(int i=digits.length -1;i>=0;i--){
            int temp = digits[i] +addition;
            digits[i] = temp %10;
            addition = temp /10;
        }

        if(addition == 0){
            return digits;
        }else{
            digits = new int[digits.length+1];
            digits[0] = addition;
            return digits;

        }





    }
}
