package DP.subsequence;

public class LongestPalindromeSequence {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("ababccbaba"));
        System.out.println(longestPalindromeSubseq("bbbbab"));
    }
    static int longestPalindromeSubseq(String s) {
        int n = s.length();
        StringBuilder rev= new StringBuilder(s);
        return longestCommonSequence(s, rev.reverse().toString(), n, n);
    }

    static int longestCommonSequence(String word1, String word2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}
