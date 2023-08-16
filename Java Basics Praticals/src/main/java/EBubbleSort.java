import java.util.Arrays;

public class EBubbleSort  {
    public static void main(String[] args) {

        int[] array =  {1,2,7,3,-1,-03,0,4,5};
        System.out.println("\n\nArray before bubble sorting: "+ Arrays.toString(array)+" after ascending order sorting : "+Arrays.toString(bubbleSort(array,true))+"\n\n");
        array = new int[]{1,2,-7,3,-1,-03,0,4,5};
        System.out.println("\n\nArray before bubble sorting: "+ Arrays.toString(array)+" after descending order sorting : "+Arrays.toString(bubbleSort(array,false))+"\n\n");

    }

    private static int[] bubbleSort(int[] array, boolean isAscending) {
        for(int i=0;i<array.length;i++){

            boolean isSwappled = false;

            for (int j= 0; j< array.length-i-1 ; j++){

                if( isAscending ? (array[j]>array[j+1] ) : (array[j]<array[j+1])){
                    int temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    isSwappled = true;
                }

            }

            //if in entire jth iteration, the elements are not swapped which indicates that array is sorted
            if(Boolean.FALSE.equals(isSwappled))
                return array;
        }
        return array;
    }
}
