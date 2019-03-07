package code;
/*
 * 48. Rotate Image
 * 题意：将数组顺时针翻转90度
 * 难度：Medium
 * 分类：Array
 * 思路：两种思路：先对角，再以竖轴对称；先以横轴对称，再对角.思路很新奇，记一下.
 */
public class lc48 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printArr(matrix);
        rotate(matrix);
        System.out.println();
        printArr(matrix);
    }
    public static void rotate(int[][] matrix) {
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[0].length/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length-1-j];
                matrix[i][matrix[0].length-1-j] = temp;
            }
        }
    }

    public static void printArr(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
