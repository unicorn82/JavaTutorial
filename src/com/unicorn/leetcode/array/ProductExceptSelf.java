package com.unicorn.leetcode.array;

public class ProductExceptSelf {


    public int[] productExceptSelf1(int[] nums) {
        int[] results = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            prefix[i] = i>0? nums[i]*prefix[i-1]: nums[i];
            postfix[nums.length-1-i] = (i>0)? nums[nums.length-1-i] * postfix[nums.length-i]: nums[nums.length-1-i];

        }

        for(int i=0;i<nums.length;i++){
            results[i] = ((i>0)? prefix[i-1]:1)  * ((i<nums.length-1)? postfix[i+1]: 1);
        }



        return results;


    }

    public int[] productExceptSelf(int[] nums) {
        int[] results = new int[nums.length];
        int length = nums.length;
        int first = 1;
        int last = 1;
        for(int i=0;i<length;i++){
            results[i] = first;
            first *= nums[i];
        }

        for(int i=0;i<length;i++){

            results[length-1-i] = results[length-1-i]* last;
            last *= nums[length-1-i];


        }


        return results;


    }
}
