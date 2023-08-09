import java.util.Arrays;

public class QMaxElementOFArray {
    public static void main(String[] args) {
        int [] arr = {1,2,3,99,1,88,100,0,-1};
        int max = arr[0];
        for (int a : arr){
            if(a > max)
                max =a;
        }
        System.out.println("\n\nMax element of array "+ Arrays.toString(arr)+" is: "+max);
    }
}
