package recursion;

import java.util.Arrays;

public class Sudoku {
    public static void main(String[] args) {
        /*
        https://leetcode.com/problems/sudoku-solver/description/
         */
        char[][] board = {{'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };
        System.out.println("\n\n Before : "+ Arrays.deepToString(board));
        sudoku(board);
        System.out.println("After : "+ Arrays.deepToString(board));
    }
   static boolean sudoku(char[][] board) {
        for(int i=0 ; i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char k='1';k<='9';k++){
                        if(valid(board,k,i,j)){
                            board[i][j] =k;
                            if(sudoku(board))
                                return true;
                            else
                                board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    static boolean valid(char[][] board, char k, int row, int col){
        for(int i=0 ; i<9;i++){
            if(board[i][col]==k) return false;
            if(board[row][i]==k)return false;
            if(board[3*(row/3)+i/3][3*(col/3)+i%3] ==k) return false;
        }
        return true;
    }
}
