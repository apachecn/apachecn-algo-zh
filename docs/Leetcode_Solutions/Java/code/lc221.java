package code;
/*
 * 221. Maximal Square
 * 题意：0，1数组中最大正方形
 * 难度：Medium
 * 分类：Dynamic Programming
 * 思路：三个正方形+上右下角位置，可以组成一个新的正方形
 * Tips：和lc85作比较
 */
public class lc221 {
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));
    }
    public static int maximalSquare(char[][] matrix) {
        if(matrix.length==0)
            return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length ; j++) {
                if(i==0 || j==0) {
                    dp[i][j] = matrix[i][j]-'0';
                    max = Math.max(dp[i][j],max);
                }
                else{
                    if(matrix[i][j]=='1') {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;    //dp[i][j] 最大正方形边长
                        max = Math.max(dp[i][j], max);
                    }
                }
            }
        }
        return max*max;
    }
}
