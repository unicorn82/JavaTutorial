package com.unicorn.algorithm;

import com.unicorn.utils.CollectionsUtils;

public class RadixSort extends CountingSort{

    private int pow(int d){
        int pow = 1;
        for (int i = 0; i < d; i++) {
            pow = pow * 10;
        }
        return pow;
    }

    @Override
    protected int key(int num, int... b) {
        return num/pow(b[0])%10;

    }

    public int[] radixSort(int[] nums, int b){
        int[] ret = nums;
        for(int i=0;i<b;i++){
            ret = this.countingSort(ret,i);
            CollectionsUtils.printArray(ret);
        }
        CollectionsUtils.printArray(nums);
        return ret;


    }


    public static void main(String[] args) {
        int b = 6;
        RadixSort radixSort = new RadixSort();

        int[] nums = new int[]{345432,9043,359291,942,682940,45};
        int[] result = radixSort.radixSort(nums, b);
        CollectionsUtils.printArray(result);

    }




}
