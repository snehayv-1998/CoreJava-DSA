package DP;

import java.util.concurrent.CompletableFuture;

public class Basic  {

        // Using memoization (top-down) with recursion
        public static long fibonacciMemoization(int n) {
            long[] memo = new long[n + 1];
            return fibonacciMemoizationHelper(n, memo);
        }

        private static long fibonacciMemoizationHelper(int n, long[] memo) {
            if (n <= 1) {
                return n;
            }

            if (memo[n] != 0) {
                return memo[n];
            }

            memo[n] = fibonacciMemoizationHelper(n - 1, memo) + fibonacciMemoizationHelper(n - 2, memo);
            return memo[n];
        }

        // Using tabulation (bottom-up) with iteration
        public static long fibonacciTabulation(int n) {
            if (n <= 1) {
                return n;
            }

            long[] dp = new long[n + 1];
            dp[0] = 0;
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            return dp[n];
        }

    // Using constant space complexity with iteration
    public static long fibonacciConstant(int n) {
        if(n==0)return 1;
        if(n==1)return 1;
        int prev = 1;
        int prev2 = 1;
        int cur =0;
        for(int i = 2; i<=n; i++){
            cur=prev+prev2;
            prev2= prev;
            prev = cur;
        }
        return cur;
    }


    public static void main(String[] args) {
            int n = 40; // Adjust the value of n as needed

        CompletableFuture.runAsync(()->{
            long startTime = System.nanoTime();
            long resultMemoization = fibonacciMemoization(n);
            long endTime = System.nanoTime();
            System.out.println("Fibonacci using memoization: " + resultMemoization);
            System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
        });
        CompletableFuture.runAsync(()->{
            long startTime = System.nanoTime();
            long resultTabulation = fibonacciTabulation(n);
            long  endTime = System.nanoTime();
            System.out.println("Fibonacci using tabulation: " + resultTabulation);
            System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");

        });
        CompletableFuture.runAsync(()->{
            long startTime = System.nanoTime();
            long resConstant = fibonacciConstant(n);
            long endTime = System.nanoTime();
            System.out.println("Fibonacci using constant: " + resConstant);
            System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
        });
        }
}
