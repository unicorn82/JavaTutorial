package com.unicorn.leetcode.geometry;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList();
        int top = 0;
        int left = 0;
        int bottom = matrix.length-1;
        int right = matrix[0].length-1;
        while(top <= bottom && left <= right){
            if(top <= bottom){
                for(int i=left;i<=right;i++){ //top line
                    result.add(matrix[top][i]);
                }
                top++;
            }
            if(left <= right){
                for(int i=top;i<=bottom;i++){ //right line
                    result.add(matrix[i][right]);
                }
                right--;
            }
            if(top <= bottom){
                for(int i=right;i>=left;i--){ // bottom line
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left <= right){
                for(int i=bottom;i>=top;i--){ //left line
                    result.add(matrix[i][left]);
                }
                left++;
            }

        }

        return result;

    }
}
