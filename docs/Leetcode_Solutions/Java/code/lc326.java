package code;
/*
 * 326. Power of Three
 * 题意：判断该数是否为3的幂
 * 难度：Easy
 * 分类：Math
 * 思路：除以3，除到不能整除，判断是否为1
 * Tips：
 */
public class lc326 {
    public boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        while (n % 3 == 0) n /= 3;
        return n == 1;
    }
    public boolean isPowerOfThree2(int n) {
        if(n==1) return true;
        double d = n;
        while(d>1){
            d=d/3;
            if(d==1) return true;
        }
        return false;
    }
}
