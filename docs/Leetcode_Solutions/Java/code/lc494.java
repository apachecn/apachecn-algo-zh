package code;
/*
 * 494. Target Sum
 * 题意：给数组中的元素赋加减号，使得和为target的分配方案有几种
 * 难度：Medium
 * 分类：Dynamic Programming, Depth-first Search
 * 思路：可以用递归+mem的方法。也可以转化为0，1背包问题，注意dp的时候把下标移位。另一种方法是转化为子数组的和为(target + sum(nums))/2的问题，求解方法类似lc416
 * Tips：多抽象总结一下相关的问题，如何抽象出背包。对于这个数字，要么+，要么-，就两种情况。
 */
public class lc494 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if(S>sum||S<-sum)
            return 0;
        int[] dp = new int[sum*2+1]; //还有0,所以+1
        dp[sum] = 1;
        for (int i = 0; i < nums.length ; i++) {
            int[] dp2 = new int[sum*2+1];
            for (int j = 0; j < dp.length ; j++) {
                if(j+nums[i]<dp.length)     //判断下别越界了
                    dp2[j+nums[i]] += dp[j];       // +=dp[j]  求得是总数
                if(j-nums[i]>=0)
                    dp2[j-nums[i]] += dp[j];
            }
            dp = dp2;
        }
        return dp[S+sum];
    }
}
