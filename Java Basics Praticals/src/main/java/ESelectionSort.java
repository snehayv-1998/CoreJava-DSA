import java.util.Arrays;

public class ESelectionSort {
    public static void main(String[] args) {
        int[] array =  {1,2,7,3,-1,-03,0,4,5};
        System.out.println("\n\nArray before selection sorting: "+ Arrays.toString(array)+" after ascending order sorting : "+Arrays.toString(selectionSort(array))+"\n\n");
        array = new int[]{1,2,-7,3,-1,-03,0,4,5};
        System.out.println("\n\nArray before selection sorting: "+ Arrays.toString(array)+" after descending order sorting : "+Arrays.toString(selectionDescSort(array))+"\n\n");

    }

    private static int[] selectionSort(int[] array) {
        for(int i=0 ;i<array.length;i++){
            int lastIndex = array.length-i-1;
            int maxNumIndex = getMaxIndex(array,0,lastIndex);
            swap(array,maxNumIndex,lastIndex);
        }
        return array;
    }

    private static void swap(int[] array, int maxNumIndex, int lastIndex) {
        int temp = array[maxNumIndex];
        array[maxNumIndex]=array[lastIndex];
        array[lastIndex]=temp;
    }

    static int getMaxIndex(int[] arr, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }
    private static int[] selectionDescSort(int[] array) {

        int lastIndex = array.length-1;
        for(int i=0 ;i<array.length;i++){
            int maxNumIndex = getMaxIndex(array,i,lastIndex);
            swap(array,maxNumIndex,i);
        }
        return array;
    }
}
