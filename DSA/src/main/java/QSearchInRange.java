import java.util.Arrays;

public class QSearchInRange {
    public static void main(String[] args) {
        int[] array = {1, 92, -75, -99, 99999999,8,10};
        int start = 2;
        int end = 6;
        int target=8;
        boolean flag =false;
        for (int i =start;i<end;i++){
            if(array[i]==target)
                flag = true;
        }
        if (flag)
            System.out.println("\n\nTarget "+target+" is present within the specified range of array "+ Arrays.toString(array));
        else
            System.out.println("\n\nTarget "+target+" is not present within the specified range of array "+ Arrays.toString(array));
        System.out.println("\n\n**********************************************************************");
    }
}
