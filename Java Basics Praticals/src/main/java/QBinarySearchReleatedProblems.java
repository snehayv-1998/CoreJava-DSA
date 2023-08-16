import java.util.Arrays;

public class QBinarySearchReleatedProblems {
    public static void main(String[] args) {

        {
            //ceiling =  the smallest element in the array that is greater than or equals to target(both for asc and desc order sorted array)
            int[] array = {1,2,9,10,99,100};
            int target =99;
            System.out.println("\n\nceiling of "+target+" array "+ Arrays.toString(array)+" is : "+ceilingSearch(array,0,array.length-1,target));

            //flooring=the greatest element in the array that is smaller than or equals to target
            target = 2;
            System.out.println("\n\nflooring of "+target+" in array "+ Arrays.toString(array)+" is : "+  flooringSearch(array,0,array.length-1,target));
        }

        {/*
        Given a characters array letters that is sorted in non-decreasing order and a character
        target, return the smallest character in the array that is larger than target.
        Note that the letters wrap around.
        • For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'
        */

            char[] letters = {'a', 'b','c'};
            char key = 'b';
            System.out.println("\n\nceiling of "+key+" in array "+ Arrays.toString(letters)+" is : "+charCeilingSearch(letters,0,letters.length-1,key));

        }


        {
            /*
        Given an array of integers nums sorted in ascending order, find the starting and
        ending position of a given target value.
        If target is not found in the array, return [-1, -1].
        You must write an algorithm with O(log n) runtime complexity.
        Example 1:
        Input: nums [5,7,7,8,8,10], target = 8
        Output: [3,4]
         */
           int[] array = {5, 6, 7, 7, 8, 10};
           int target =7;
           int result[]= {-1,-1};
           result[0] = searchInRepeatedElementArray(array,0,array.length-1,target,true);
           if(result[0]!= -1)
               result[1] = searchInRepeatedElementArray(array,0,array.length-1,target,false);
           System.out.println("\n\nStarting and ending position of "+target+" in array "+ Arrays.toString(array)+" is : "+Arrays.toString(result));
        }

        {
            // infinite array

        }

        {
            //find peak of mountain array
            int array[] = {1,2,3,5,6,7,9,3,2,1,0};//mountain array
            System.out.println("\n\nPeak of mountain array "+Arrays.toString(array)+" is : "+ array[ searchPeakOfArray(array,0,array.length-1)]);
        }

        {
            /*
            You may recall that an array A is a mountain array if and only if: A.length >= 3
            • There exists some i with 0 < i < A. length- 1 such that:
            • A[0] < A[1] <... A[i-1] < A[i]
            • A[i] > A[i+1] > ... > A[A.length - 1]
            Given a mountain array mountainArr, return the minimum index such that
            mountainArr.get(index) == target. If such an index doesn't exist, return -1.
             */

            int array[] = {1,2,3,5,6,7,9,3,2,1,0};//mountain array
            int target = 0;
            int peak = searchPeakOfArray(array,0,array.length-1);
            int result;
            if(target == array[peak])
                result = peak;
            else{
                result = orderAgnosticSearch(array,target,0,peak);
                if(result == -1){
                    result =  orderAgnosticSearch(array,target,peak,array.length-1);
                }
            }
            System.out.println("\n\nTarget Index of "+target+" in mountain array "+Arrays.toString(array)+" is : "+ result);
        }

        {
            /*
            There is an integer array nums sorted in ascending order (with distinct values).
             Prior to being passed to your function, nums is rotated at an unknown pivot index x
             (0 < x < nums.length) such that the resulting array is [nums[k].
             nums[k+1],..., nums[n-1], nums[0], nums[1], ., nums[-1]] (0-
             indexed). For example, 10,1,2,4,5,6,7] might be rotated at pivot index 3 and
             become [4,5,6,7,0,1,2]-
             Given the array nuns after the rotation and an integer target, return the index of
             target if it is in array, or -1 if it is not in array
             You must write an algorithm with o(log n) runtime complexity.
             Example 1:
             Input: array [4,5,6,7,0,1,2), target = 0
             Output: 4
             */

        }
        {
            /*
            There is an integer array nums sorted in ascending order (with duplicate values).
             Prior to being passed to your function, nums is rotated at an unknown pivot index x
             (0 < x < nums.length) such that the resulting array is [nums[k].
             nums[k+1],..., nums[n-1], nums[0], nums[1], ., nums[-1]] (0-
             indexed). For example, 10,1,2,4,5,6,7] might be rotated at pivot index 3 and
             become [4,5,6,7,0,1,2]-
             Given the array nuns after the rotation and an integer target, return the index of
             target if it is in array, or -1 if it is not in array
             You must write an algorithm with o(log n) runtime complexity.
             Example 1:
             Input: array [4,5,6,7,0,1,2), target = 0
             Output: 4
             */

        }
        {
            //rotation count

        }
        {
            /*
            Given an integer array nums and an integer k, split nums into k non-empty sub arrays such that the largest
            sum of any sub array is minimized.Return the minimized largest sum of the split. A sub array is a contiguous part of the array.
            Example 1:
            Input: nums = [7,2,5,10,8], k = 2
            Output: 18
            Explanation: There are four ways to split nums into two sub arrays.
            The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two sub arrays is only 18.
             */
            int[] nums = {7,2,5,10,8};
            int k = 2;
            int ans = splitArray(nums,k);
        }

    }

    private static int splitArray(int[] nums, int maxSplit) {
        int ans = 0;
        int minSum = Arrays.stream(nums).max().orElse(0);
        int maxSum = Arrays.stream(nums).sum();
        if(maxSplit == 1)
            return maxSum;
        if (maxSplit == nums.length)
            return minSum;
        else {
           ans = maxSumOfSplitArray(nums,maxSplit,minSum,maxSum);

        }
        return ans;
    }

    private static int maxSumOfSplitArray(int[] nums, int maxSplit, int start, int end) {
        int numSplit =0 ;
        while (start<end){
            if(maxSplit ==numSplit)
                return-1;
        }
        return  -1;
    }

    private static int searchInRepeatedElementArray(int[] array, int start, int end, int target, boolean isFirstIndexSearch) {
        int ans = -1;
        while (start <= end){
            int mid = start +(end-start)/2;
            if(array[mid]==target){
                ans = mid;
                if(isFirstIndexSearch){
                    end = --mid;
                }else {
                    start = ++mid;
                }
            }else if(array[mid]<target){
                start = mid+1;
            }else
                end = mid-1;
        }
        return ans;
    }


    private static int ceilingSearch(int[] array, int start, int end, int target) {
        if(target>= array[end])
            return Integer.MIN_VALUE;
        while (start <= end){
            int mid = start +(end-start)/2;
            if(array[mid]==target){
                return array[++mid];
            }else if(array[mid]<target){
                start = mid+1;
            }else
                end = mid-1;
        }
        return Integer.MIN_VALUE;
    }

    private static int flooringSearch(int[] array, int start, int end, int target) {
        if(target <= array[start])
            return Integer.MIN_VALUE;
        while (start <= end){
            int mid = start +(end-start)/2;
            if(array[mid]==target){
                return array[--mid];
            }else if(array[mid]<target){
                start = mid+1;
            }else
                end = mid-1;
        }
        return Integer.MIN_VALUE;
    }

    private static char charCeilingSearch(char[] array, int start, int end, char target) {
        if(target>= array[end])
            return array[start];
        while (start <= end){
            int mid = start +(end-start)/2;
            if(array[mid]==target){
                return array[++mid];
            }else if(array[mid]<target){
                start = mid+1;
            }else
                end = mid-1;
        }
        return array[start];
    }

    private static int searchPeakOfArray(int[] array, int start, int end) {
        int mid = 0;
        while (start<=end){
            mid = start+(end-start)/2;
            if( array[mid] > array[mid+1])
                end = mid -1;
            else if(array[mid]<array[mid+1])
                start = mid+1;
        }
        return mid;
    }

    private static int orderAgnosticSearch(int[] array, int target, int start, int end) {
        boolean isAscending = array[start] < array[end];
        while (start<=end){
            int mid = start + (end-start)/2;
            if(array[mid] == target){
                return mid;
            }
            if(isAscending){
                if(array[mid]<target)
                    start = mid+1;
                else
                    end = mid -1;
            }else {
                if(array[mid]>target)
                    start = mid+1;
                else
                    end = mid -1;
            }

        }
        return -1;
    }
}
