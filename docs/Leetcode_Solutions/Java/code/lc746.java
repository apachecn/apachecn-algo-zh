package code;
/*
 * 746. Min Cost Climbing Stairs
 * 题意：上楼梯，变了一下形
 * 难度：Easy
 * 分类：Array, Dynamic Programming
 * 思路：
 * Tips：Bingo!
 */
public class lc746 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==1) return cost[0];
        int dp1 = cost[0], dp2 = cost[1], dp3 = Integer.MAX_VALUE;
        for(int i=2; i<cost.length; i++){
            dp3 = Math.min(dp1+cost[i], dp2+cost[i]);
            dp1 = dp2;
            dp2 = dp3;
        }
        return Math.min(dp1,dp2);  //注意下返回值，还要比较一下
    }
}
