package code;
/*
 * 204. Count Primes
 * 题意：计算小于n的素数的个数
 * 难度：Easy
 * 分类：Hash Table, Math
 * 思路：两个循环，相乘得到的数不是素数。
 * Tips：
 */
public class lc204 {
    public int countPrimes(int n) {
        if(n<3) return 0;
        boolean[] flags = new boolean[n];
        int sum = 0;
        for(int i=2; i<n; i++){
            if(flags[i]==false) sum++;      // 内循环已经计算过了
            for(int j=2; i*j<n; j++){       // i*j<n
                flags[i*j] = true;
            }
        }
        return sum;
    }
}
