package com.unicorn.leetcode.geometry;

import java.util.HashSet;

public class Rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length-1;
        HashSet<String> visited = new HashSet();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                if(visited.contains(i+","+j)){
                    continue;
                }
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j][i];
                matrix[n-j][i] = matrix[n-i][n-j];
                matrix[n-i][n-j] = matrix[j][n-i];
                matrix[j][n-i] = temp;
                visited.add(i+","+j);
                visited.add((n-j)+","+i);
                visited.add((n-i)+","+(n-j));
                visited.add(j+","+(n-i));



            }
        }

    }
}
