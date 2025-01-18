package com.unicorn.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SolveNQueens {
    List<List<String>> results = new ArrayList();
    HashSet<Integer> columnHash = new HashSet();
    HashSet<Integer> leftHash = new HashSet(); //row+column
    HashSet<Integer> rightHash = new HashSet(); //row-column
    int[] columns;
    int[] lefts;
    int[] rights;

    char[][] boards;
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        boards = new char[n][n];
        columns = new int[n];
        lefts = new int[2*n];
        rights = new int[2*n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                boards[i][j] = '.';  //0 -> . 1 -> Q
            }
        }
        List<String> list = new ArrayList();
        putOneQueen(0);
        return results;

    }

    private void putOneQueen( int row){
        if(row >= n) {
            results.add(constructList());
            return;
        }
        for(int col =0; col<n;col++){
            if(checkPos(row, col)){
                boards[row][col] = 'Q';
                addPosInHash(row, col);
                putOneQueen(row+1);
                removePosInHash(row, col);
                boards[row][col] = '.';
            }
        }
    }

    private List<String> constructList(){
        List<String> list = new ArrayList();
        for(int i=0;i<n;i++){

            list.add(new String(boards[i]));
        }
        return list;
    }

    private boolean checkPos(int row, int col){
        //if(columnHash.contains(col) || leftHash.contains(row+col) || rightHash.contains(row-col)){
        if(columns[col] == 1 || lefts[row+col] ==1 || rights[row-col+n] ==1){
            return false;
        }
        return true;
    }

    private void addPosInHash(int row, int col){
        columns[col] = 1;
        lefts[row+col] = 1;
        rights[row-col+n] = 1;
        // columnHash.add(col);
        // leftHash.add(row+col);
        // rightHash.add(row-col);
    }

    private void removePosInHash(int row, int col){
        columns[col] = 0;
        lefts[row+col] = 0;
        rights[row-col+n] = 0;
        // columnHash.remove(col);
        // leftHash.remove(row+col);
        // rightHash.remove(row-col);
    }
}
