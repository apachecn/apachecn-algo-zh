package code;
/*
 * 371. Sum of Two Integers
 * 题意：两个数相加，但不能用 + - 操作符号
 * 难度：Easy
 * 分类：Bit Maniputation
 * 思路：自己没想起来
 *      https://leetcode.com/problems/sum-of-two-integers/discuss/84278/A-summary%3A-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently
 * Tips：
 */
public class lc371 {
    public int getSum(int a, int b) {
        return b==0? a:getSum(a^b, (a&b)<<1);   // a^b 为不算进位的结果，加上进位
    }
}
