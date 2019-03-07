package code;
/*
 * 240. Search a 2D Matrix II
 * 题意：有序矩阵中搜索值
 * 难度：Medium
 * 分类：Binary Search, Divide and Conquer
 * 思路：两种方法，一种O(mlg(n))，遍历每一行，每行二分查找。另一种O(m+n)，从右上角开始移动
 * Tips：
 */
public class lc240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0)
            return false;
        int i = 0;
        int j = matrix[0].length;
        while( i<matrix.length || j>=0 ){
            if(matrix[i][j]==target)
                return true;
            else if(matrix[i][j]>target)
                j--;
            else
                i++;
        }
        return false;
    }
}
