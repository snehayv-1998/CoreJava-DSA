package binarySearch;

import java.util.Arrays;

public class EBinarySearch {
    public static void main(String[] args) {

        //simple binary search
        int[] sortedArray = {1,2,3,4,15,19,28,88,99};
        int target = 10;
        int start = 0;
        int end = sortedArray.length-1;
        boolean flag = false;
        while (start<=end){
            int mid = start + (end - start) / 2; // might be possible that (start + end) exceeds the range of int in java so this approach is used.

            if(target == sortedArray[mid]){
                flag = true;
                break;
            }
            else if(target>sortedArray[mid])
                start = mid+1;
            else
                end = mid-1 ;
        }

        if (flag)
            System.out.println("\n\nTarget "+target+" is present in the array "+ Arrays.toString(sortedArray));
        else
            System.out.println("\n\nTarget "+target+" is not present in the array "+ Arrays.toString(sortedArray));
        System.out.println("\n\n**********************************************************************");




        //order-agnostic-binary-search
        sortedArray = new int[]{99, 97, 88, 86, 77, 55};
        target = 55;
        start = 0;
        end = sortedArray.length-1;
        flag = false;

        boolean ascending = sortedArray[0]<sortedArray[end-1];

        while (start <= end){

            int mid = start+(end-start)/2;

            if(target ==sortedArray[mid]){
                flag = true;
                break;
            }

            if(ascending) {
             if (target > sortedArray[mid])
                    start = mid + 1;
             else
                 end = mid - 1;
            }

            else {
                if (target < sortedArray[mid])
                    start = mid +1;
                else
                    end = mid - 1;
            }

        }

        if (flag)
            System.out.println("\n\nTarget "+target+" is present in the array "+ Arrays.toString(sortedArray));
        else
            System.out.println("\n\nTarget "+target+" is not present in the array "+ Arrays.toString(sortedArray));
        System.out.println("\n\n**********************************************************************");

    }
}
