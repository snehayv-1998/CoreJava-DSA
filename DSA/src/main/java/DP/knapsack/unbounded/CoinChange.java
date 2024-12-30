package DP.knapsack.unbounded;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        //https://leetcode.com/problems/coin-change/description/?envType=problem-list-v2&envId=dynamic-programming
        System.out.println("--------------------minCoinChange-----------------------");
        System.out.println(minCoinChange(new int[]{1,5,11,5},6));
        System.out.println(minCoinChange(new int[]{1,2,5},11));
        System.out.println(minCoinChange(new int[]{},11));
        System.out.println(minCoinChange(new int[]{1},0));

        //https://leetcode.com/problems/coin-change-ii/description/?envType=problem-list-v2&envId=dynamic-programming
        System.out.println("--------------------countCoinChange-----------------------");
        System.out.println(countCoinChange(new int[]{1,5,11,5},6));
        System.out.println(countCoinChange(new int[]{1,2,5},11));
        System.out.println(countCoinChange(new int[]{},11));
        System.out.println(countCoinChange(new int[]{1},0));
    }
    public static int minCoinChange(int[] coins, int amount) {
        int res = minCoinChangeTabulation(coins, amount, coins.length);
        return res == Integer.MAX_VALUE-1 ? -1 : res;
    }

    static  int minCoinChangeTabulation(int[] coins, int w, int n) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i=0;i<=n;i++){
        for (int j=0;j<=w;j++) {
            if (j == 0) {
                dp[i][j] = 0; // Amount 0 requires 0 coins
            } else if (i == 0) {
                dp[i][j] = Integer.MAX_VALUE-1; // No coins to form the amount
            }
        }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (coins[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                }
            }
        }
        return dp[n][w];
    }

    static int countCoinChange(int[] coins,int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] =  dp[i][j - coins[i - 1]] + dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];

    }
}
