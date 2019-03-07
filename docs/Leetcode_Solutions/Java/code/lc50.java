package code;
/*
 * 50. Pow(x, n)
 * 题意：幂运算
 * 难度：Medium
 * 分类：Math, Binary Search
 * 思路：和lc29的思路类似，数值上的二分。用前一步的结果进行下一步的运算，降低了迭代次数
 * Tips：注意溢出的情况，负数的情况。
 */
public class lc50 {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n==Integer.MIN_VALUE && x!=1 && x!=-1) return 0;
        if(n<0){
            n = -n;
            x = 1/x;    //负数变成 1/x
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}
