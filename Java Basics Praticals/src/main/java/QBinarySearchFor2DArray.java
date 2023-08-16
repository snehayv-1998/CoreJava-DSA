import java.util.Arrays;

public class QBinarySearchFor2DArray {
    public static void main(String[] args) {
        {
            /*
        https://leetcode.com/problems/search-a-2d-matrix/description/
        You are given an m x n integer matrix with the following two properties:
        Each row is sorted in non-decreasing order.
        The first integer of each row is greater than the last integer of the previous row.
        Given an integer target, return true if target is in matrix or false otherwise.
        You must write a solution in O(log(m * n)) time complexity.
        Example 1:
        Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
        Output: true
         */

            int array[][]={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
            int target=3;
            System.out.println("\n\nIndex of "+target+" is : "+ Arrays.toString(searchIn2D(array,target)));
        }
        {
                    /*
        You are given an m x n integer matrix with the following two properties:
        Each row is sorted in decreasing order.
        The first integer of each row is greater than the last integer of the previous row.
        Given an integer target, return true if target is in matrix or false otherwise.
        You must write a solution in O(log(m * n)) time complexity.
        Example 1:
        Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
        Output: true
         */

            int array[][]={{9,8,7},{6,5,4},{3,1,2}};
            int target=2;
            System.out.println("\n\nIndex of "+target+" is : "+ Arrays.toString(searchIn2D(array,target)));
        }


    }
    private static int[]  searchIn2D(int[][] array, int target) {

        if(array == null || array[0].length == 0 || array.length==0)
            return new int[]{-1,-1};

        int row = 0;
        int col = array[0].length-1;
        boolean isAscending = array[0][0] < array[0][col];

        while(row <= array.length-1  && col >=0){

            if(array[row][col] ==target)
                return new int[]{row,col};

            if(isAscending){
                if(array[row][col] < target)
                    row = row+1;
                else
                    col = col-1;
            }
            else {
                if(array[row][col] < target)
                    col = col-1;
                else
                    row = row+1;
            }

        }
        return new int[]{-1,-1};
    }
}
