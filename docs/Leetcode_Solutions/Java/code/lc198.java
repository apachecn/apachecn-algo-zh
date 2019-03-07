package code;
/*
 * 198. House Robber
 * 题意：数组最大和，不能选取相邻的两个数
 * 难度：Easy
 * 分类：Dynamic Programming
 * 思路：经典的dp题，记一下
 * Tips：时间复杂度为 O(n)
 */
public class lc198 {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length ; i++) {
            dp[i] = Math.max((dp[i-2] + nums[i]),dp[i-1]);  //dp[i] 表示以 0~i 的数组的结果
        }
        return dp[nums.length-1];
    }
}
