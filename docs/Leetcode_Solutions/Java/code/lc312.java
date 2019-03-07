package code;
/*
 * 312. Burst Balloons
 * 题意：踩气球，求怎样踩，值最大
 * 难度：Hard
 * 分类：Divide and Conquer, Dynamic Programming
 * 思路：假设第n个气球是最后一个被踩爆，则从第n个气球开始，数组可以分为无前后相关性的两块
 *      首尾补1，最小区间为3个数，maxCoins[1,4],则需遍历2,3两种情况, 1,4指的是边界
 *      maxCoins[0][n - 1] = maxCoins[0][i - 1] + maxCoins[i + 1][n - 1] + nums[left] * nums[i] * nums[right]
 *      left是左边界，right是右边界，不一定是相邻的
 * Tips：太难了，弃疗了，不会写。直接粘答案。区间dp。
 */
public class lc312 {
    public static void main(String[] args) {
        System.out.println(maxCoins2(new int[]{3,1,5,8}));
    }
    public static int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;
        int[][] memo = new int[n][n];
        int res =  burst(memo, nums, 0, n - 1);
        return res;
    }

    public static int burst(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; ++i)
            ans = Math.max(ans, nums[left] * nums[i] * nums[right]
                    + burst(memo, nums, left, i) + burst(memo, nums, i, right));
        memo[left][right] = ans;
        return ans;
    }

    public static int maxCoins2(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;


        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right],
                            nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
            }

        return dp[0][n - 1];
    }

}
