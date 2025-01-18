package com.unicorn.algorithm;

import com.unicorn.utils.CollectionsUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertSort {

    public int[] insertSort(int[] arrs){
        if(arrs == null){
            return new int[]{};

        }
        for (int i = 1; i < arrs.length; i++) {
            sort(arrs, i);

        }

        return arrs;
    }

    private void sort(int[] arrs, int index){
        int  target = index;
        for(int i=index-1; i>=0;i--){
            if(arrs[target] >= arrs[i]){
                break;
            }else{
                int temp = arrs[i];
                arrs[i] = arrs[target];
                arrs[target] = temp;
                target = i;
            }

        }

    }







    public static void main(String[] args) {
        int arr[] = { 38,27,43,3,9,82,10, 8 };
        InsertSort insertSort = new InsertSort();

        CollectionsUtils.printArray(insertSort.insertSort(arr));




    }
}
