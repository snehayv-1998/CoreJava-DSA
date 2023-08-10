import java.util.Arrays;

public class QReturnTargetsIndexOf2DArray {
    public static void main(String[] args) {
        int[][] array = {
                {9,11,8},
                {13,2,31},
                {25,19,1}
        };
        int target = 1;
        int[] targetIndex = new int[1];
        for(int i =0;i<array.length;i++){
            for (int j =0 ; j<array[i].length;j++){
                if(array[i][j]==target)
                    targetIndex = new int[]{i, j};
            }
        }
        System.out.println("\n\nTarget "+target+" index at 2D array is : "+Arrays.toString(targetIndex));
    }
}
