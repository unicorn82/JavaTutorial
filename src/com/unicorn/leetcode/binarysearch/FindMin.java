package com.unicorn.leetcode.binarysearch;

public class FindMin {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            if(nums[left] <= nums[right]){
                return nums[left];
            }else{
                int mid = (left + right)/2;
                if(nums[mid]>=nums[left]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
        }
        return left;

    }
}
