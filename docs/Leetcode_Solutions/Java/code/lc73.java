package code;
/*
 * 73. Set Matrix Zeroes
 * 题意：把含有0的行和列都设成0
 * 难度：Medium
 * 分类：Array
 * 思路：用第一行和第一列作为标志位。注意赋值的时候从后往前，防止标志位被改变
 * Tips：注意赋值的顺序，防止标志位被改变
 *       思路是很简单，但有许多细节
 */
public class lc73 {
    public void setZeroes(int[][] matrix) {
        boolean col0 = false;   //因为 matrix[0][0] 只有一个位置，所以用一个变量单独记录
        for (int i = 0; i < matrix.length ; i++) {
            if(matrix[i][0]==0) col0 = true;
            for (int j = 1; j < matrix[0].length ; j++) {
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = matrix.length-1; i >= 0 ; i--) {   //从后往前，标志位那一行最后改变
            for (int j = matrix[0].length-1; j >= 1 ; j--) {    // j>=1 不包含j==0
                if( matrix[i][0]==0 || matrix[0][j]==0 ) matrix[i][j] = 0;
            }
            if(col0==true) matrix[i][0]=0;  //要在for循环后，再把[i][0]改变
        }
    }
}
