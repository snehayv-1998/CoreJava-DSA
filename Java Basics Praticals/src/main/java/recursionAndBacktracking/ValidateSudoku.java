package recursionAndBacktracking;

public class ValidateSudoku {
    public static void main(String[] args) {
        /*
        https://leetcode.com/problems/valid-sudoku/submissions/
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
        System.out.println("is valid sudoku : "+ isValidSudoku(board));
    }
    static  boolean isValidSudoku(char[][] board) {
        for(int i=0 ; i<9;i++){
            for(int j=0;j<9;j++){
                char c = board[i][j];
                if( c >='0' && c <= '9' && !valid(board,c,i,j))return false;
            }
        }
        return true;
    }
   static boolean valid(char[][] board,char k,int row,int col){
        for(int i=0 ; i<9;i++){
            if(i!=row && board[i][col]==k) return false;
            if(i !=col && board[row][i]==k)return false;
        }
        int rowStart = 3 * (row/3);
        int colStart = 3 * (col/3);

        for(int i=rowStart; i<rowStart + 3; i++){
            for( int j = colStart; j<colStart + 3; j++){
                if(i!=row && j!=col && board[i][j] == board[row][col]) return false;
            }
        }
        return true;
    }
}
