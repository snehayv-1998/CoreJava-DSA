package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;



public class NQueen {
    public static void main(String[] args) {
        /*
        https://leetcode.com/problems/n-queens/description/
         */
        System.out.println("N Queens: "+solveNQueens(4));
    }
    static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j = 0;j<n;j++){
                board[i][j]='.';
            }
        }
        int leftRow[] = new int[n];
        int upperDiagnol[] = new int[2*n-1];
        int lowerDiagnol[] = new int[2*n-1];
        dfs(0,board,res,leftRow,upperDiagnol,lowerDiagnol,n);
        return res;
    }

    private static void dfs(int col, char[][] board, List<List<String>> res, int[] leftRow, int upperDiagnol[], int lowerDiagnol[], int n) {
        if(col==board.length){
            res.add(construct(board));
            return;
        }

        for (int row=0 ;row<n;row++){
            if(leftRow[row]!=1 && upperDiagnol[(n-1)+col-row]!=1 && lowerDiagnol[row+col]!=1){
                board[row][col] = 'Q';
                leftRow[row]=1;
                upperDiagnol[(n-1)+col-row]=1;
                lowerDiagnol[row+col]=1;
                dfs(col+1,board,res,leftRow,upperDiagnol,lowerDiagnol,n);
                board[row][col] = '.';
                leftRow[row]=0;
                upperDiagnol[(n-1)+col-row]=0;
                lowerDiagnol[row+col]=0;
            }
        }
    }

    private static List<String> construct(char[][] board) {
        List<String> res =new ArrayList<>();
        for (int i =0;i<board.length;i++ ) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
