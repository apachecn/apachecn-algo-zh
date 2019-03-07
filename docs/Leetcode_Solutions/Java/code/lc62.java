package code;
/*
 * 62. Unique Paths
 * 题意：求从数组[0,0]走到[m,n]的不同路径数
 * 难度：Medium
 * 分类：Array, Dynamic Programming
 * 思路：和lc63, lc64思路一样, arr存储的内容由路径数换成了和
 */
public class lc62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));
    }

    public static int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                if(i==0 && j==0)
                    arr[i][j] = 1;
                else if(i==0)
                    arr[i][j] = arr[i][j-1];
                else if(j==0)
                    arr[i][j] = arr[i-1][j];
                else
                    arr[i][j] = arr[i-1][j]+arr[i][j-1];
            }
        }
        return arr[m-1][n-1];
    }
}
