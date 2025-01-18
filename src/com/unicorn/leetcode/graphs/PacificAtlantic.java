package com.unicorn.leetcode.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PacificAtlantic {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> results = new ArrayList();
        int[][] pacificVisit;
        int[][] atlanticVisit;
        //Pacific
        int row = heights.length;
        int col = heights[0].length;
        pacificVisit = new int[row][col];
        atlanticVisit = new int[row][col];


        for(int i=0; i<row; i++){
            visit(heights, pacificVisit,i, 0);
            visit(heights,atlanticVisit, i, col-1);
        }
        for(int i=0;i<col;i++){
            visit(heights, pacificVisit, 0, i);
            visit(heights, atlanticVisit, row-1, i);
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(pacificVisit[i][j] == 1 && atlanticVisit[i][j] == 1){
                    List<Integer> list = new ArrayList();
                    list.add(i);
                    list.add(j);
                    results.add(list);
                }
            }
        }


        //Altantic

        return results;

    }

    private void visit(int[][] heights, int[][] visited, int i, int j){

        if(visited[i][j] ==1) return;
        visited[i][j] = 1;
        if(i < (heights.length -1) && heights[i+1][j] >= heights[i][j]){
            visit(heights, visited, i+1, j);
        }
        if(j < (heights[0].length -1) && heights[i][j+1] >= heights[i][j]){
            visit(heights, visited, i, j+1);
        }
        if(i > 0 && heights[i-1][j] >= heights[i][j]){
            visit(heights, visited, i-1, j);
        }
        if(j > 0 && heights[i][j-1] >= heights[i][j]){
            visit(heights, visited, i, j-1);
        }

    }

//    public List<List<Integer>> pacificAtlantic(int[][] heights) {
//        List<List<Integer>> results = new ArrayList();
//
//        for(int i=0;i<heights.length;i++){
//            for(int j=0;j<heights[0].length;j++){
//                System.out.println("visit "+i+";"+j);
//                HashSet<String> hash = new HashSet<>();
//                int[] result = waterFlow(hash, heights, i, j);
//
//                if(result[0] == 1 && result[1] == 1){
//                    List<Integer> list = new ArrayList();
//                    list.add(i);
//                    list.add(j);
//                    results.add(list);
//                }
//
//            }
//        }
//        return results;
//
//    }
//
//    private int[] waterFlow(HashSet<String> hashSet, int[][] heights, int row, int col){
//        int[] result = new int[2]; //[pacific, atlantic]
//        if(hashSet.contains(row+"|"+col)){
//            return result;
//        }
//
//        hashSet.add(row+"|"+col);
//        boolean isOcean = false;
//        if(row == 0 || col == 0){
//            result[0] = 1;
//
//        }
//        if(row == (heights.length-1) || col == (heights[0].length-1)){
//            result[1] = 1;
//
//        }
//
//
//
//        if(row< (heights.length-1) && heights[row+1][col] <= heights[row][col]){
//            setResult(result, waterFlow(hashSet, heights, row+1, col));
//        }
//        if(col < (heights[0].length-1) && heights[row][col+1] <= heights[row][col]){
//            setResult(result, waterFlow(hashSet, heights, row, col+1));
//        }
//        if(row > 0 && heights[row-1][col] <= heights[row][col]){
//            setResult(result, waterFlow(hashSet, heights, row-1, col));
//        }
//        if(col > 0 && heights[row][col-1] <= heights[row][col]){
//            setResult(result, waterFlow(hashSet, heights, row, col-1));
//        }
//
//        return result;
//
//    }
//
//    private void setResult(int[] result, int[] temp){
//
//        if(temp[0] == 1){
//            result[0] =  1;
//        }
//        if(temp[1] == 1){
//            result[1] =  1;
//        }
//    }

    public static void main(String[] args) {
        int[][] heights = new int[5][5];
        int[] row1 = new int[]{1,2,2,3,5};
        int[] row2 = new int[]{3,2,3,4,4};
        int[] row3 = new int[]{2,4,5,3,1};
        int[] row4 = new int[]{6,7,1,4,5};
        int[] row5 = new int[]{5,1,1,2,4};
        heights[0] = row1;
        heights[1] = row2;
        heights[2] = row3;
        heights[3] = row4;
        heights[4] = row5;
        PacificAtlantic p = new PacificAtlantic();
        p.pacificAtlantic(heights);



    }
}
