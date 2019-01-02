/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2019/1/2
 */
public class Solution {
    /**
     * 转圈打印矩阵
     * @param matrix 矩阵
     * @return 存放结果的list
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {

        ArrayList<Integer> reList = new ArrayList<>();
        if (matrix == null) {
            return reList;
        }

        int start = 0;
        int rows = matrix.length;
        int colums = matrix[0].length;

        while (rows > start * 2 && colums > start * 2) {
            printMatrix(matrix, rows, colums, start, reList);
            start++;
        }

        return reList;
    }

    private void printMatrix(int[][] matrix, int rows, int columns, int start, ArrayList<Integer> reList) {

        // 相当于坐标轴中的y坐标
        int endX = columns - start - 1;
        // 相当于坐标轴中的x坐标
        int endY = rows - start - 1;

        // 从左到右，x增加y不变
        for (int i = start; i <= endX; i++) {
            reList.add(matrix[start][i]);
        }

        if (start < endY) {
            // 从上到下，x不变y增加
            for (int i = start + 1; i <= endY; i++) {
                reList.add(matrix[i][endX]);
            }
        }

        if (start < endX && start < endY) {
            // 从右到左，x减少y不变
            for (int i = endX - 1; i >= start; i--) {
                reList.add(matrix[endY][i]);
            }
        }

        if (start < endX && start < endY - 1) {
            // 从下到上，x不变y减少
            for (int i = endY - 1; i > start; i--) {
                reList.add(matrix[i][start]);
            }
        }
    }
}