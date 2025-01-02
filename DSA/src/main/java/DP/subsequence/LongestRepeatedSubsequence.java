package DP.subsequence;

public class LongestRepeatedSubsequence {
    public static void main(String[] args) {
        System.out.println(isMatch("aa","a"));
    }
    static boolean isMatch(String s, String p) {
        if (p.equals("*"))
            return true;
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        int lcs = longestCommonSubSequence(s, p, s.length(), p.length(), dp);
        return lcs == p.length();
    }

    static int longestCommonSubSequence(String s, String p, int n, int m, int[][] dp) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
