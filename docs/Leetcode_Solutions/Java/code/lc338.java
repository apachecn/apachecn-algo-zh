package code;
/*
 * 338. Counting Bits
 * 题意：0~n数字上1的个数
 * 难度：Medium
 * 分类：Dynamic Programming, Bit Maniputation
 * 思路：把前几个数的二进制写出来，就很容易看出来dp公式，前边的值+1即可
 * Tips：注意细节，边界情况
 */
public class lc338 {
    public static void main(String[] args) {
        int[] res = countBits(0);
        for (int i = 0; i < res.length ; i++) {
            System.out.print(res[i]);
            System.out.print(" ");
        }
    }
    public static int[] countBits(int num) {
        int[] dp = new int[num+1];
        int i = 1;
        while(i<=num) {
            dp[i] = 1;
            int max = i;
            for (int j = 0; j<max && i<=num ; j++) {
                dp[i] = 1 + dp[j];
                i++;
            }
        }
        return dp;
    }
}
