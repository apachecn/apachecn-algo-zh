package code;
/*
 * 64. Minimum Path Sum
 * 题意：求矩阵和最小的路径
 * 难度：Medium
 * 分类：Array, Dynamic Programming
 * 思路：和lc63, lc62思路一样, arr存储的内容由路径数换成了和
 */
public class lc64 {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] arr = new int[m][n];
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                if(i==0 && j==0)
                    arr[i][j] = grid[i][j];
                else if(i==0)
                    arr[i][j] = arr[i][j-1] + grid[i][j];
                else if(j==0)
                    arr[i][j] = arr[i-1][j] + grid[i][j];
                else
                    arr[i][j] = Math.min(arr[i-1][j],arr[i][j-1]) + grid[i][j];
            }
        }
        return arr[m-1][n-1];
    }
}
