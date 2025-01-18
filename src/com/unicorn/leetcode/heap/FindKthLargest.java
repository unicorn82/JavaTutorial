package com.unicorn.leetcode.heap;

import java.util.*;
import java.util.stream.Collectors;

public class FindKthLargest {


        public int findKthLargest(int[] nums, int k) {
            if(nums.length == 1) return nums[0];
            return findKthRecursively(nums, 0, nums.length-1, k);

        }

        private int findKthRecursively(int[] nums, int left, int right, int k){
            int size = right - left+1;
            if(size == 0) return nums[right];
            int p=left;
            int pivot = right;
            for(int i = left; i< pivot; i++){
                if(nums[i] < nums[pivot]){
                    swap(nums, i, p);
                    p++;
                }

            }
            swap(nums, p, pivot);
            int target = right - p+1;
            if (k == target){
                return nums[p];
            }else if(k > target){
                k = k - target;
                return findKthRecursively(nums, left, p-1, k );
            }else{
                return findKthRecursively(nums, p+1, right, k);
            }
        }

        private void swap(int[] nums, int t, int s){
            if(t == s) return;
            int temp = nums[t];
            nums[t] = nums[s];
            nums[s] = temp;
        }





    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,0,4};
        int k=2;
        FindKthLargest f = new FindKthLargest();
        System.out.println(f.findKthLargest(nums,k));

    }
}
