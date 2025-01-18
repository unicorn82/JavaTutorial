package com.unicorn.leetcode.graphs;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int[][] visited = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){

            visit(board, visited, i, 0);


            visit(board, visited, i, board[0].length-1);

        }

        for(int j=0;j<board[0].length;j++){

            visit(board, visited, 0, j);


            visit(board, visited, board.length-1, j);


        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 'O' && visited[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void visit(char[][] board, int[][] visited, int row, int col){
        if(row < 0 || row >= board.length || col <0 || col >= board[0].length || visited[row][col] == 1 || board[row][col] == 'X'){
            return ;
        }


        visited[row][col] = 1;
        visit(board, visited, row+1, col);
        visit(board, visited, row, col+1);
        visit(board, visited, row-1, col);
        visit(board, visited, row, col-1);


        return ;

    }
}
