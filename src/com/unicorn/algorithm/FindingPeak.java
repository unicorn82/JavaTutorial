package com.unicorn.algorithm;

import com.unicorn.utils.CollectionsUtils;

public class FindingPeak {



    public int find1DPeak(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int start= 0;
        int end = nums.length-1;


        return findPeakRecursively(nums, start, end);
    }

    private int findPeakRecursively(int[] nums, int start, int end){
        int mid = (start+end)/2;
        if(mid == start && mid ==end){ return mid; }
        else if(mid > start && nums[mid] < nums[mid-1]){
            return findPeakRecursively(nums, start, mid-1);
        }else if (mid < end && nums[mid] < nums[mid +1]){
            return findPeakRecursively(nums, mid+1, end);
        }
        return mid;
    }

    public int[] find2DPeak(int[][] nums){
        int[] result = new int[]{0,0};
        if(nums == null || (nums.length == 1 && nums[0].length ==1)){
            return result;
        }
        int mid_col = nums.length/2;
        return find2DPeakRecursively(nums, mid_col);


    }

    private int[] find2DPeakRecursively(int[][] nums, int col){
        int row = findHighestInColumn(nums[col]);
        System.out.println(col + "====="+nums[col][row]+"=====");
        if(col > 0 && nums[col][row] < nums[col-1][row]){
            return find2DPeakRecursively(nums, col-1);
        }else if (col< nums.length-1 && nums[col][row] < nums[col+1][row]){
            return find2DPeakRecursively(nums, col+1);
        }else{
            return new int[]{col, row};
        }

    }



    private int findHighestInColumn(int[] cols){
        int max = 0;
        for(int i=1;i<cols.length;i++){
            if(cols[i] > cols[max]){
                max = i;
            }
        }
        return max;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{5,4};
        FindingPeak f = new FindingPeak();
        System.out.println(nums[f.find1DPeak(nums)]);

        /**
         * 3 5 8 9
         * 6 4 5 7
         * 2 3 1 6
         * 4 7 2 4
         *
         */

        int[][] nums_2d = new int[][]{{3,5,8,9,4},{6,4,5,7},{2,3,1,6},{4,7,2,4}};
        CollectionsUtils.printArray(f.find2DPeak(nums_2d));
    }


}
