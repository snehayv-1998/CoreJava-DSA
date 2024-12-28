import java.util.Arrays;
import java.util.Scanner;

public class EArray {
    /*
    1. 1D array syntax:
    <dataType> [] variableName = new <dataType>[size];

    2. 2D array syntax:
     <dataType> [][] variableName = new <dataType>[rowSize][columnSize];

    3. default value = null
     */

    public static void main(String[] args) {
        int[] oneDArray = new int[5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nEnter the 1D array elements: ");
        for (int i =0 ; i< oneDArray.length;i++){
          oneDArray[i] = scanner.nextInt();
        }
        System.out.println("\n1D array element: "+Arrays.toString(oneDArray));

        //2D Array:
        int[][] twoDArray = new int[3][3];
        System.out.println("\n\nEnter the 2D array elements: ");
        for (int row =0 ; row< twoDArray.length;row++){
            for (int col=0 ; col< twoDArray[row].length ;col++){
                twoDArray[row][col] = scanner.nextInt();
            }
        }
        System.out.println("\n2D array elements: ");
        for (int row =0 ; row< twoDArray.length;row++){
            System.out.println(Arrays.toString(twoDArray[row]));
        }
        System.out.println();
    }
}
