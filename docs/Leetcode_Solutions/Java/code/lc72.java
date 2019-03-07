package code;
/*
 * 72. Edit Distance
 * 题意：编辑距离
 * 难度：Hard
 * 分类：String, Dynamic Programming
 * 思路：dp[i][j] 可以由 dp[i-1][j], dp[i][j-1], dp[i-1][j-1] 变过来
 * Tips：很经典的题，注意如何初始化dp[0][i]和dp[i][0]，以及dp更新规则。空间复杂度还可以优化。
 */
public class lc72 {
    public static void main(String[] args) {
        System.out.println(minDistance("intention","execution"));
    }
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i < word2.length()+1 ; i++)
            dp[0][i] = i;
        for (int i = 0; i < word1.length()+1 ; i++)
            dp[i][0] = i;
        for (int i = 1; i < word1.length()+1 ; i++) {
            for (int j = 1; j < word2.length()+1 ; j++) {
                int temp = Math.min(dp[i][j-1]+1,dp[i-1][j]+1);
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j] = Math.min(dp[i-1][j-1],temp);
                else
                    dp[i][j] = Math.min(dp[i-1][j-1]+1,temp);
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
