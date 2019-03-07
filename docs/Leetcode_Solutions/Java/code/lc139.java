package code;
/*
 * 139. Word Break
 * 题意：是否能够分词
 * 难度：Medium
 * 分类：Dynamic Programming
 * 思路：动态规划
 * Tips：巧妙的方法，防止了复杂的操作，通过遍历之前计算出来的结果
 */
import java.util.List;

public class lc139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i < dp.length ; i++) {
            for (int j = 0; j < i ; j++) {  //遍历之前计算出来的结果
                if( dp[j]==true && wordDict.contains(s.substring(j,i)))
                    dp[i] = true;
            }
        }
        return dp[s.length()+1];
    }
}
