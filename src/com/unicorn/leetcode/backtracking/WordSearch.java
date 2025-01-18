package com.unicorn.leetcode.backtracking;

import java.util.HashSet;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        HashSet path = new HashSet();

        for(int i=0; i<board.length; i++){
            for(int j=0;j<board[0].length; j++){

                if(helper(i, j, 0, board, word, path)){
                    return true;
                }


            }
        }
        return false;

    }

    private boolean helper(int x, int y,  int index, char[][] board, String words, HashSet path){
        if(index >= words.length()) return true;
        if(x >= board.length || x <0 || y >= board[0].length || y <0) return false;
        // if(path.contains(x+"|"+y)) return false;
        if(board[x][y] == words.charAt(index)){
            board[x][y] += 100;
            //path.add(x+"|"+y);
            boolean isWord = helper(x+1, y, index+1, board, words, path) || helper(x, y+1, index+1, board, words, path) || helper(x-1, y, index+1, board, words, path) ||helper(x, y-1, index+1, board, words, path);
            //path.remove(x+"|"+y);
            board[x][y] -= 100;

            return isWord;
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println('A'+100);
    }
}
