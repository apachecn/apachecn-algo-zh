package code;
/*
 * 96. Unique Binary Search Trees
 * 题意：给定n，多少棵二叉搜索树，1~n
 * 难度：Medium
 * 分类：Dynamic Programming, Tree
 * 思路：1~n都可以做根节点，分成左右两个子问题 dp[i] * dp[n-1-i]
 * Tips：
 */
public class lc96 {
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
    public static int numTrees(int n) {
        if(n<2)
            return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j <i ; j++) {
                dp[i] += dp[j] * dp[i-1-j];
            }
        }
        return dp[n];
    }
}
