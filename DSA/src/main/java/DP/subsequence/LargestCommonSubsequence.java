package DP.subsequence;

import java.util.Arrays;

public class LargestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(recursive("abdef","ade",5,3));
        System.out.println(longestCommonSubsequence("abdef","ade"));
        System.out.println(tabulation("abdef","ade",5,3));
    }
    static int recursive(String text1,String text2, int n, int m){
        if(n==0||m==0)
            return 0;
        if(text1.charAt(n-1)==text2.charAt(m-1)){
            return 1+recursive(text1,text2,n-1,m-1);
        }
        return Math.max(recursive(text1,text2,n-1,m),recursive(text1,text2,n,m-1));
    }
    static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int [] d: dp){
            Arrays.fill(d,-1);
        }
        return helper(dp,text1,text2,text1.length(),text2.length());
    }
    static int helper(int[][] dp, String text1, String text2, int n, int m){
        if(n==0||m==0)
            return 0;
        if(dp[n][m] != -1) return dp[n][m];
        if(text1.charAt(n-1)==text2.charAt(m-1)){
            return dp[n][m]= 1+helper(dp,text1,text2,n-1,m-1);
        }
            return dp[n][m]= Math.max(helper(dp,text1,text2,n-1,m),helper(dp,text1,text2,n,m-1));
    }
    static int tabulation(String text1,String text2, int n, int m){
        int[][] dp= new int[n+1][m+1];
        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j] =dp[i-1][j-1]+1;
                else
                    dp[i][j]=  Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
}
