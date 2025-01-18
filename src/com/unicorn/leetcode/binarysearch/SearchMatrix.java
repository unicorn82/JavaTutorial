package com.unicorn.leetcode.binarysearch;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m-1;
        if(matrix[0][0] > target || matrix[m-1][n-1] < target){
            return false;
        }
        while(start <= end){
            int middle = start + (end - start)/2;
            if(matrix[middle][0] == target){
                return true;
            }else if (matrix[middle][0] < target){
                start = middle + 1;
            }else{
                end = middle -1;
            }
        }
        int row = start - 1;
        start = 0;
        end = n-1;
        while(start <= end){
            int middle = start + (end-start)/2;
            if(matrix[row][middle] == target){
                return true;
            }else if (matrix[row][middle] < target){
                start = middle +1;

            }else{
                end = middle - 1;
            }
        }

        return false;



    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0;
        int bottom = m-1;
        int row = 0;

        if(matrix[0][0] > target || matrix[m-1][n-1] < target){
            return false;
        }
        while(top <= bottom){
            row = (top + bottom)/2;
            if (matrix[row][n-1] < target){
                top = row + 1;
            }else if(matrix[row][0] > target){
                bottom = row -1;
            }else{
                break;
            }
        }
        int start = 0;
        int end = n-1;
        while(start <= end){
            int middle = start + (end-start)/2;
            if(matrix[row][middle] == target){
                return true;
            }else if (matrix[row][middle] < target){
                start = middle +1;

            }else{
                end = middle - 1;
            }
        }

        return false;



    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1},{3}};
        int target = 3;
        int[] n1 = nums[0];
        SearchMatrix s = new SearchMatrix();
        System.out.println(s.searchMatrix(nums,target));


    }
}
