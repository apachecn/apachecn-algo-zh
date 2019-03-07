package code;
/*
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * 题意：最佳时间买卖股票，有冷却期，如果前一天卖了，下一天就不能买
 * 难度：Medium
 * 分类：Dynamic Programming
 * 思路：状态DP，自己不会写。要分两种状态，手中有股票时最大收益，手中没股票时最大收益(包括冷冻期)。
 *      buy[i] = max( buy[i-1], sell[i-2]-price[i] )
 *      sell[i] = max( sell[i-1], buy[i-1]+price[i] )
 *      空间压缩以后时间是O(n)，空间是O(1)
 * Tips：https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75931/Easiest-JAVA-solution-with-explanations
 *  lc122
 */
public class lc309 {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int b1 = -prices[0];
        int s2=0, s1=0;
        int b = 0, s = 0;
        for (int i = 0; i < prices.length ; i++) {
            b = Math.max(b1, s2-prices[i]);
            s = Math.max(s1, b1+prices[i]);
            s2 = s1;
            s1 = s;
            b1 = b;
        }
        return Math.max(s,b);
    }
}
