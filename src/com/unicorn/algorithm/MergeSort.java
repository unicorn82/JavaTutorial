package com.unicorn.algorithm;

import com.unicorn.utils.CollectionsUtils;

public class MergeSort {

    public int[] mergeSortList(int[] unsortedList, int l, int r){
        if(unsortedList == null || unsortedList.length == 1){
            return unsortedList;
        }
        if(l == r){
            return new int[]{unsortedList[l]};
        }
        int m = (l+r)/2;


        int[] part1 = mergeSortList(unsortedList,l,m);
        int[] part2 = mergeSortList(unsortedList,m+1, r);
        int[] results = new int[part1.length+part2.length];
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < results.length; i++) {
            if(c1<part1.length && c2<part2.length) {
                if (part1[c1] < part2[c2]) {
                    results[i] = part1[c1];
                    c1++;

                }else{
                    results[i] = part2[c2];
                    c2++;
                }
            }else if(c1<part1.length){
                results[i] = part1[c1];
                c1++;
            }else {
                results[i] = part2[c2];
                c2++;
            }
            
        }
        return results;

    }

    private void refactNum(int[] a, int[] a1, int[] a2){
        //if(a.length>1) {

        for (int i = 0; i <a.length ; i++) {
            if(i<a1.length){
                a1[i] = a[i];
            }else {
                a2[i-a1.length] = a[i];
            }
        }
        //}
    }

    public static void main(String[] args) {
        int arr[] = { 38,27,43,3,9,82,10, 8 };
        MergeSort m = new MergeSort();
        CollectionsUtils.printArray(m.mergeSortList(arr, 0, arr.length-1));
    }
}
