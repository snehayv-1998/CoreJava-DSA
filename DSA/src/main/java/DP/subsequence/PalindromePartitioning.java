package DP.subsequence;

import java.util.Arrays;

public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(minCut("abb"));
        System.out.println(memoize("abb"));
    }
    static int minCut(String s) {
        return recursive(s, 0, s.length() - 1);
    }

   static int recursive(String s, int i, int j) {
        if (i >= j)
            return 0;
        if (isPalindrome(s, i, j))
            return 0;
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = 1 + recursive(s, i, k) + recursive(s, k + 1, j);
            min = Math.min(min, temp);
        }
        return min;
    }

   static  boolean isPalindrome(String s, int i, int j) {
        if (i >= j)
            return true;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
   static int memoize(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return solve(s, 0, s.length() - 1, dp);
    }

 static int solve(String s, int i, int j, int[][] dp) {
        if (i >= j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (isPalindrome(s, i, j))
            return 0;
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int left = 0;
            int right = 0;
            if (dp[i][k] != -1)
                left = dp[i][k];
            else {
                left = solve(s, i, k, dp);
                dp[i][k] = left;
            }
            if (dp[k + 1][j] != -1)
                right = dp[k + 1][j];
            else {
                right = solve(s, k + 1, j, dp);
                dp[k + 1][j] = right;
            }
            int temp = 1 + left + right;
            min = Math.min(min, temp);
        }
        return dp[i][j] = min;
    }
}
