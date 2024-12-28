import java.util.Arrays;

public class QMaxAndMinElementOFArray {
    public static void main(String[] args) {
        int [] arr = {1,2,3,99,1,88,-2,100,0,-1};
        int max = arr[0];
        int min = arr[0];
        for (int a : arr){
            if(a > max)
                max =a;
            if(a < min)
                min = a;
        }
        System.out.println("\n\nMax element of array "+ Arrays.toString(arr)+" is: "+max);
        System.out.println("\n\nMinimum element of array "+ Arrays.toString(arr)+" is: "+min);
        System.out.println("\n***********************************************************");
    }
}
