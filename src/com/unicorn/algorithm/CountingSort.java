package com.unicorn.algorithm;

import com.unicorn.utils.CollectionsUtils;

public class CountingSort {

    protected int key(int num, int... b){
        return num;
    }

    public int[] countingSort(int[] nums, int... b){

        //loop array to get k
        if(nums == null || nums.length == 0){
            return null;
        }
        int[] out = new int[nums.length];

        int min = key(nums[0],b[0]);
        int max = key(nums[0],b[0]);
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, key(nums[i], b[0]));
            max = Math.max(max, key(nums[i], b[0]));
        }
        int k = max-min+1;
        int[] l = new int[k];
        for (int i = 0; i < nums.length; i++) {
            int n = key(nums[i], b[0]);
            l[n-min]++;

        }
        for(int i=1; i<l.length;i++){
            l[i] = l[i] + l[i-1];
        }

        for(int i=nums.length-1; i >= 0 ;i--){
            int count = l[key(nums[i], b[0])-min];
//            out[i] = count-1;
            out[count-1] = nums[i];

            l[key(nums[i], b[0])-min]--;
        }


        return out;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,4,5,2,2,6,4,7,8,2,9,5,5,2};
        CountingSort c = new CountingSort();
        int[] sort = c.countingSort(nums,0);
        CollectionsUtils.printArray(sort);

    }

}
