import java.util.Arrays;

public class QSwapAndReverseArray {
    public static void main(String[] args) {

        System.out.println("\n***************************************\n");
        //Swapping the array elements
        int [] arr = {1,2,3,99,1,88,100,0,-1};
        System.out.println("Before swap of array "+ Arrays.toString(arr));
        swap(arr,1, 2);
        System.out.println("\nAfter swapping 1st and 2nd indexed element of array "+ Arrays.toString(arr));

        System.out.println("\n***************************************\n");
        //Reverse of the array
        int[] array = {1,2,3,8,99,55,77,-1,55};
        System.out.println("Before reversing the array "+ Arrays.toString(array));
        int start = 0;
        int end = array.length-1;
        while (start<end){
            swap(array,start,end);
            start++;
            end--;
        }
        System.out.println("\nAfter reversing the array "+ Arrays.toString(array));
        System.out.println("\n***************************************\n");
    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
