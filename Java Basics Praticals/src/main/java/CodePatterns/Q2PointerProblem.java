package CodePatterns;

import java.util.Arrays;

public class Q2PointerProblem {
    public static void main(String[] args) {

        {
            /*
            arr =[-9,-8,-4,-2,1,3,8,11]
            In this sorted array find first 2 numbers such that their sum =0.
             */
            int[] array = {-9, -8, -4, -2, 2, 4, 8, 9};
            int start = 0;
            int end = array.length - 1;
            int ans[] = new int[2];
            while (start <= end) {
                if (array[start] + array[end] == 0) {
                    ans[0] = array[start];
                    ans[1] = array[end];
                    break;
                }
                start++;
                end--;
            }
            System.out.println("\n\nResult1 : " + Arrays.toString(ans));
        }

        {
        /*
        Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
        You may assume that each input would have exactly one solution, and you may not use the same element twice.
        You can return the answer in any order.
        Example 1:
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
         */
            int[] array = {2, 7, 11, 15};
            int target = 26;
            int start = 0;
            int pointer = 1;
            int l =array.length-1;
            int ans[] = {-1,-1};
            while (start < l) {
                if (array[start] + array[pointer] == target) {
                    ans[0] = start;
                    ans[1] = pointer;
                    break;
                }
                if (pointer >=l){
                    start ++;
                    pointer = start+1;
                }else
                    pointer++;
            }
            System.out.println("\n\nResult2 : " + Arrays.toString(ans));
        }
    }
}
