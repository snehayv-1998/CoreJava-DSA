package DP.subsequence;

public class LargestCommonSubString {
    public static void main(String[] args) {
        System.out.println(tabulation("abdef","ade",5,3));

        //https://leetcode.com/problems/maximum-length-of-repeated-subarray/
        System.out.println("---------------------sub array--------------------");
        System.out.println(findLength(new int[]{1,2,3,2,1},new int[]{3,2,1,4,7}));
    }
    static int tabulation(String text1,String text2, int n, int m){
        int[][] dp= new int[n+1][m+1];
        int ans=0;
        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans=Math.max(ans,dp[i][j]); //because of the discontinuity dp may not hold max element, so we need some variable to track overall max element
                }
                else
                    dp[i][j]=  0;
            }
        }
        return ans;
    }
    static int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else
                    dp[i][j] = 0;
            }
        }
        return ans;
    }
}
