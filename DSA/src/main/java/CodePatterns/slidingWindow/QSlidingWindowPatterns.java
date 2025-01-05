package CodePatterns.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QSlidingWindowPatterns {
    public static void main(String[] args) {
        {
            /*
            find a sub array with 3 element such that it has the maximum sum
             */
            int[] array ={1,3,4,5,1};
            int k =3;

            int[] result =  slidingWindow(array,k);
            System.out.println("Result : "+ Arrays.toString(result)+ " max sum is:"+ Arrays.stream(result).sum());
        }
        {
            /*
            Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
            The result should also be sorted in ascending order.
            An integer a is closer to x than an integer b if:
            Example 1:
            Input: arr = [1,2,3,4,5], k = 4, x = 3 Output: [1,2,3,4]
             */
            int[] array ={1,1,1,10,10,10};
            int k =4;
            int x =3;
            System.out.println( "findClosestElements: "+findClosestElements(array,1,9));
        }
    }

    private static int[] slidingWindow(int[] array, int k) {
        int windowSum = 0;
        int[] result = new int[k];
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0;i<k;i++){
            windowSum += array[i];
        }
        maxSum = windowSum;
        for (int i= k ;i<array.length;i++){
            windowSum -=array[i-k];
            windowSum += array[i];
            if(maxSum<windowSum){
                maxSum = windowSum;
                result[0] = array[i-2];
                result[1] = array[i-1];
                result[2] = array[i];
            }
        }
        return result;
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
            int distance = 0;
            List<Integer> res = new ArrayList<>();
            int resStartIndex=0;
            for(int i =0;i<k;i++){
                distance +=Math.abs(arr[i]-x);
            }
            int minDistance =distance;
            for(int i = k;i<arr.length;i++){
                distance -=Math.abs(arr[i-k]-x);
                distance +=Math.abs(arr[i]-x);
                if(minDistance>distance){
                    minDistance = distance;
                    resStartIndex = i-k+1;
                }
            }
            for(int i =resStartIndex ;i<resStartIndex+k;i++){
                res.add(arr[i]);
            }
            return res;
    }
}
