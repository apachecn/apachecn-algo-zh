import java.util.ArrayList;

/**
 * @author bingo
 * @since 2018/11/22
 */

public class Solution {
    /**
     * 转圈打印矩阵
     * 
     * @param matrix 矩阵
     * @return 存放结果的list
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null) {
            return list;
        }
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int i = 0, j = 0;
        while (i <= m && j <= n) {
            circlePrint(list, matrix, i++, j++, m--, n--);
        }
        return list;
    }

    private void circlePrint(ArrayList<Integer> list, int[][] matrix, int i, int j, int m, int n) {
        if (i == m) {
            for (int p = j; p <= n; ++p) {
                list.add(matrix[i][p]);
            }
        } else if (j == n) {
            for (int p = i; p <= m; ++p) {
                list.add(matrix[p][j]);
            }
        } else {
            for (int p = j; p < n; ++p) {
                list.add(matrix[i][p]);
            }
            for (int p = i; p < m; ++p) {
                list.add(matrix[p][n]);
            }
            for (int p = n; p > j; --p) {
                list.add(matrix[m][p]);
            }
            for (int p = m; p > i; --p) {
                list.add(matrix[p][j]);
            }
        }
    }
}