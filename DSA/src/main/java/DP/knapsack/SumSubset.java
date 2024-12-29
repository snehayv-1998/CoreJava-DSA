package DP.knapsack;
public class SumSubset {
    /*
    Given an array arr[] of non-negative integers and a value sum, the task is to check if there is a subset of the given array whose sum is equal to the given sum.

Examples:

Input: arr[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True
Explanation: There is a subset (4, 5) with sum 9.


Input: arr[] = {3, 34, 4, 12, 5, 2}, sum = 30
Output: False
Explanation: There is no subset that add up to 30.
     */

    public static void main(String[] args) {
        System.out.println(subsetTabulation(new int[]{3, 34, 4, 12, 5, 2},9,6));
        System.out.println(subsetTabulation(new int[]{3, 34, 4, 12, 5, 2},30,6));

    }
    public static boolean subsetTabulation(int[] nums, int w,int n) {
        boolean[][] dp = new boolean[n + 1][w + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }
            }
        }
        return dp[n][w];
    }
}
