package code;
/*
 * 877. Stone Game
 * 题意：两个人拿石头堆，每次只能从最左边或最右边拿
 * 难度：Medium
 * 分类：Math, Dynamic Programming, Minimax
 * 思路：之前做过有印象，先拿的人一定赢的。
 *      dp的思路需要借鉴一下的， dp[i][j] 表示数组 i~j 的最优解
 *      向两边拓展的dp, 用一个变量表示 size 这个dp。想想一下三角形的区域是怎么一步步被填满的，斜线斜线的，最后是一个点
 *      拿了piles[i]， 则dp[i+1][j]就被另一个人拿了，结果是 piles[i] - dp[i + 1][j]
 *      拿了piles[j]， 则dp[i][j-1]就被另一个人拿了，结果是 piles[j] - dp[i][j - 1]
 * Tips：
 */
public class lc877 {
    public boolean stoneGame(int[] piles) {
        return true;
    }

    public boolean stoneGame2(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        for (int i = 0; i < piles.length ; i++) dp[i][i] = piles[i];   //最后是第二个人拿的，用符号
        for (int size = 1; size < piles.length ; size++) {  //外循环是 size
            for (int i = 0; i+size < piles.length ; i++) { //size<len
                dp[i][i+size] = Math.max(piles[i]-dp[i+1][i+size], piles[i+size]-dp[i][i+size-1]);
            }
        }
        return dp[0][piles.length-1]>0;
    }

}
