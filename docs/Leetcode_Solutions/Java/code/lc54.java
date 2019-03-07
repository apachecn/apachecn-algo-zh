package code;
/*
 * 54. Spiral Matrix
 * 题意：螺旋输出矩阵
 * 难度：Medium
 * 分类：Array
 * 思路：很直接的思路，就是循环打印
 * Tips：需要注意很多细节，最后调试成功
 */
import java.util.ArrayList;
import java.util.List;

public class lc54 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length==0) return res;
        int r=0, c=-1;  // -1开始，循环内首先++
        int row_r = matrix.length;
        int col_r = matrix[0].length;
        int row_l = -1;
        int col_l =-1;
        while( row_l+1<row_r || col_l+1<col_r ){
            c++;
            if(c<col_r){
                while(c<col_r){
                    res.add(matrix[r][c]);
                    c++;
                }
            }else   //提前终止
                return res;
            c--;    // -- 恢复正常
            r++;
            if(r<row_r) {
                while (r < row_r) {
                    res.add(matrix[r][c]);
                    r++;
                }
            }else
                return res;
            r--;
            c--;
            if(c>col_l){
                while(c>col_l){
                    res.add(matrix[r][c]);
                    c--;
                }
            }else
                return res;
            c++;
            r--;
            if(r>row_l+1) {
                while (r > row_l + 1) {
                    res.add(matrix[r][c]);
                    r--;
                }
            }else
                return res;
            r++;
            row_l++;
            row_r--;
            col_l++;
            col_r--;
        }
        return res;
    }
}
