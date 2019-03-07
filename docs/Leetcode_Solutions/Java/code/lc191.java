package code;
/*
 * 191. Number of 1 Bits
 * 题意：统计二进制数中1的个数
 * 难度：Easy
 * 分类：Bit Manipulation
 * 思路：每次移一位，与运算
 * Tips：
 */
public class lc191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        int a = 1;
        while(a!=0){
            int b = n&a;
            if(b!=0) sum += 1;
            a <<= 1;
        }
        return sum;
    }
}
