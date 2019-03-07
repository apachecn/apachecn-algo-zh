package code;
/*
 * 121. Best Time to Buy and Sell Stock
 * 题意：股票买卖1次，最大利润
 * 难度：Easy
 * 分类：Arryas, Dynamic Programming
 * Tips：lc122
 */
public class lc121 {
    public int maxProfit(int[] prices) {
        int min = prices[0];if(prices.length==0)
            return 0;
        int res =0;
        for (int i = 1; i < prices.length ; i++) {
            res = Math.max(prices[i]-min,res);
            if(prices[i]<min)
                min = prices[i];
        }
        return res;
    }
}
