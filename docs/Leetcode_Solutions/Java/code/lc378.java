package code;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 378. Kth Smallest Element in a Sorted Matrix
 * 题意：在矩阵中搜索第k大的数，横轴和纵轴都是有序的
 * 难度：Medium
 * 分类：Binary Search, Heap
 * 思路：两种思路。 1是类似多个有序链表合并的思路，优先队列。
 *                2是二分，二分的是val，看比这个val小的数是不是k
 * Tips：lc23方法很像
 */
public class lc378 {
    class Cell{
        int val, row, col;
        Cell(int v, int r, int c){
            val = v;
            row = r;
            col = c;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Cell> pq = new PriorityQueue(new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.val-o2.val;
            }
        });
        for (int i = 0; i < matrix.length ; i++) pq.add(new Cell(matrix[i][0], i, 0));
        while(k>1){
            Cell c = pq.remove();
            if(c.col+1<matrix[0].length) pq.add(new Cell(matrix[c.row][c.col+1], c.row, c.col+1));
            k--;
        }
        return pq.remove().val;
    }

    public int kthSmallest2(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length-1][matrix[0].length-1];
        while(low<=high){   //确保区间最后缩到0
            int mid = low+(high-low)/2;
            int num = getLessNum(matrix, mid);
            if(num<k) low = mid+1;
            else high = mid-1;
        }
        return low-1;
    }
    public int getLessNum(int[][] matrix, int val){ //求矩阵中比这个数小的数的个数
        int res = 0;
        int row = 0;
        while(row<matrix.length){
            int col = 0;
            while(col<matrix[0].length && matrix[row][col]<val) col++;
            res += col;
            row++;
        }
        return res;
    }
}
