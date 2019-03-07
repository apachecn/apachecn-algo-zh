package code;

/*
 * 63. Unique Paths II
 * 题意：路径数
 * 难度：Medium
 * 分类：Array, Dynamic Programming
 * 思路：和lc64, lc62思路一样, arr存储的内容由路径数换成了和
 * Tips：可以用一位数组减小空间复杂度
 */
public class lc63 {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(arr));
    }


    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] m = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j <obstacleGrid[i].length ; j++) {
                if(obstacleGrid[i][j]==1){
                    m[i][j] = 0;
                }else if(i==0&&j==0){
                    m[i][j] = 1;
                }else if(i==0){
                    m[i][j] = m[i][j-1];
                }else if(j==0){
                    m[i][j] = m[i-1][j];
                }else{
                    m[i][j] = m[i-1][j]+m[i][j-1];
                }
            }
        }
        return m[m.length-1][m[0].length-1];
    }
}
