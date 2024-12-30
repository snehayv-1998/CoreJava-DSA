package DP.knapsack;

public class EqualSumPartition {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,5,11,5}));
        System.out.println(canPartition(new int[]{1,3}));
    }
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0)
            return false;
        return subsetTabulation(nums, sum / 2, nums.length);
    }

    public static boolean subsetRecursive(int[] nums, int w, int n) {
        if (n == 0)
            return false;
        if (w == 0)
            return true;
        if (nums[n - 1] > w) {
            return subsetRecursive(nums, w, n - 1);
        }
        return subsetRecursive(nums, w - nums[n - 1], n - 1) || subsetRecursive(nums, w, n - 1);
    }

    public static boolean subsetTabulation(int[] nums, int w,int n){
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
