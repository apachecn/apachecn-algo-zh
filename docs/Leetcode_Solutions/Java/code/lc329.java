package code;
/*
 * 329. Longest Increasing Path in a Matrix
 * 题意：寻找最长的递增路径
 * 难度：Hard
 * 分类：Depth-first Search, Topological Sort, Memoization
 * 思路：带记忆的dfs，之前计算的最优解可以直接合并
 * Tips：
 */
public class lc329 {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0) return 0;
        int[][] cache = new int[matrix.length][matrix[0].length];   //存储计算过的结果
        int res = 0;
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length ; j++) {
                res = Math.max(dfs(matrix, i, j, cache), res);
            }
        }
        return res;
    }

    public int dfs(int[][] matrix, int i, int j, int[][] cache){
        int max = 1;
        if(cache[i][j]!=0) return cache[i][j];
        if( i>0 && matrix[i-1][j]>matrix[i][j]) max = Math.max(dfs(matrix, i-1, j, cache)+1, max);
        if( j>0 && matrix[i][j-1]>matrix[i][j]) max = Math.max(dfs(matrix, i, j-1, cache)+1, max);
        if( i+1<matrix.length && matrix[i+1][j]>matrix[i][j]) max = Math.max(dfs(matrix, i+1, j, cache)+1, max);
        if( j+1<matrix[0].length && matrix[i][j+1]>matrix[i][j]) max = Math.max(dfs(matrix, i, j+1, cache)+1, max);
        cache[i][j] = max;
        return max;
    }
}
