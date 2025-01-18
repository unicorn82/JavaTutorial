package com.unicorn.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        //  3* 81 integer = 3*81*16 bytes
        // 9*9 *3 + 9*9*3
        int[][] hors = new int[9][9];
        int[][] vers = new int[9][9];
        int[][] squs = new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] != '.'){
                    int value = board[i][j] - '0';
                    hors[i][value-1]++;
                    vers[j][value-1]++;
                    squs[i/3*3+j/3][value-1]++;
                }
            }
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(hors[i][j] >1){
                    return false;
                }
                if(vers[i][j] >1){
                    return false;
                }
                if(squs[i][j] >1){
                    return false;
                }
            }
        }
        return true;

    }

    public boolean isValidSudoku2(char[][] board) {
        // 81* 3 * 56 bytes
        //9*9*3*O(n)
        HashSet seen = new HashSet();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] != '.'){
                    if(!seen.add("H"+i+board[i][j]) || !seen.add("V"+j+board[i][j]) || !seen.add("S"+i/3+j/3+board[i][j])){
                        return false;
                    }
                }
            }
        }

        return true;

    }

    public boolean isValidSudoku1(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";

                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char c = '1';
        int i = c - '0';
        System.out.println((int)c);
    }
}
