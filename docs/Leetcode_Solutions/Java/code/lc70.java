package code;
/*
 * 70. Climbing Stairs
 * 题意：上楼梯问题，一次走一步或两步
 * 难度：Easy
 * 分类：Dynamic Programming
 */
public class lc70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}
