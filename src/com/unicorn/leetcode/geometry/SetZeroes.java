package com.unicorn.leetcode.geometry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rows = new HashSet();
        HashSet<Integer> cols = new HashSet();
        List<int[]> targets = new ArrayList();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0) targets.add(new int[]{i,j});
            }
        }
        for(int[] target: targets){
            //set row
            if(!rows.contains(target[0])){
                for(int i=0;i<matrix[0].length;i++){
                    matrix[target[0]][i] = 0;
                }
            }
            //set col
            if(!cols.contains(target[1])){
                for(int i=0;i<matrix.length;i++){
                    matrix[i][target[1]] = 0;
                }
            }
        }

    }
}
