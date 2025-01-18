package com.unicorn.leetcode.binarysearch;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merges = new int[nums1.length+nums2.length];
        int s1 = 0;
        int s2 = 0;
        int s = 0;
        while(s1< nums1.length || s2< nums2.length){
            if(s1 == nums1.length){
                merges[s] = nums2[s2];
                s2++;
            }else if(s2 == nums2.length){
                merges[s] = nums1[s1];
                s1++;
            }else{
                if(nums1[s1] < nums2[s2]){
                    merges[s] = nums1[s1];
                    s1++;
                }else{
                    merges[s] = nums2[s2];
                    s2++;

                }
            }
            s++;
        }

        if(merges.length %2 == 0){
            return (double)(merges[merges.length/2]+merges[merges.length/2-1])/2;

        }else{
            return (double)merges[merges.length/2];
        }


    }
}
