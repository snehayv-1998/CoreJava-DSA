package DP.subsequence;

public class Word1ToWord2 {
    public static void main(String[] args) {
        //https://leetcode.com/problems/delete-operation-for-two-strings/description/
        System.out.println(minDistance("sea","eat"));

        //solve: https://leetcode.com/problems/edit-distance/description/
    }
    static int minDistance(String word1, String word2) {
        if(word1.isEmpty() || word2.isEmpty()) return 0;
        int lcs= longestCommonSequence(word1,word2,word1.length(),word2.length());
        //insertion = word2.length()-lcs , deletion = word1.length()-lcs
        return word1.length()+word2.length()-2*lcs ;
    }

  static   int longestCommonSequence(String word1, String word2, int m, int n) {
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
