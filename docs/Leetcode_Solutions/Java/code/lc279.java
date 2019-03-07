package code;
/*
 * 279. Perfect Squares
 * 题意：给定一个数，求该数最少可以由几个平方数的和组成
 * 难度：Medium
 * 分类：Math, Dynamic Programming, Breadth-first Search
 * 思路：dp[i] = dp[i-j*j] +1
 * Tips：
 */
import java.util.Arrays;

public class lc279 {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
    public static int numSquares(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for (int i = 1; i <= n ; i++) { //两个for循环
            for (int j=1; j<=i ; j++) {
                if(j*j==i)
                    dp[i-1] = 1;
                if(j*j<i){
                    dp[i-1] = Math.min(dp[i-1-j*j]+1,dp[i-1]);
                }
            }
        }
        return dp[n-1];
    }
}
