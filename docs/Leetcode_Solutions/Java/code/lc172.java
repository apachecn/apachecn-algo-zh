package code;
/*
 * 172. Factorial Trailing Zeroes
 * 题意：求n!末尾有几个0
 * 难度：Easy
 * 分类：Math
 * 思路：思路记一下。如果末尾为0，则一定是2*5得到的0，2的数量一定比5多，所以只考虑5的数量，25算两个5。
 * Tips：题目看似简单，没做过的话不好想
 */
public class lc172 {
    public int trailingZeroes(int n) {
        if(n==0) return 0;
        return n/5 + trailingZeroes(n/5);
    }
}
