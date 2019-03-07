package code;
/*
 * 122. Best Time to Buy and Sell Stock II
 * 题意：买卖股票最大利润，可以买多次
 * 难度：Easy
 * 分类：Array, Greedy
 * 思路：计算 prices[i] 与 prices[i-1] 的差值，把正数全加起来就行了
 * Tips：lc121, lc309
 */
public class lc122 {
    public int maxProfit(int[] prices) {
        if(prices.length<1) return 0;
        int res = 0;
        for (int i = 1; i < prices.length ; i++) {
            if(prices[i]-prices[i-1]>0)
                res += prices[i]-prices[i-1];
        }
        return res;
    }
}
