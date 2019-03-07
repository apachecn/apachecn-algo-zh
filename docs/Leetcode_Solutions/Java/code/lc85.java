package code;

import java.util.Stack;

/*
 * 85. Maximal Rectangle
 * 题意：为1的组成的最大矩形面积
 * 难度：Hard
 * 分类：Array, Hash Table, Dynamic Programming, Stack
 * 思路：将问题转化为 84.Largest Rectangle in Histogram
 * Tips：很难，lc84就够难了，没写过的谁能想到。。。
 */
public class lc85 {
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},
                          {'1','0','1','1','1'},
                          {'1','1','1','1','1'},
                          {'1','0','0','1','0'}};
        System.out.println(maximalRectangle(matrix));
    }
    public static int maximalRectangle(char[][] matrix) {
        if(matrix.length==0||matrix[0].length==0)
            return 0;
        int col = matrix[0].length;
        int[] row = new int[col];   // 用来记录直方图高度
        int res =0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < col ; j++) {
                if(matrix[i][j]=='0')
                    row[j] =0;
                else
                    row[j] = row[j]+1;
            }
            // 求直方图最大面积
            Stack<Integer> st = new Stack();
            for (int j = 0; j <= col ; j++) {
                int h = ( j==col ? 0 : row[j] );
                if(st.isEmpty() || h>row[st.peek()]){
                    st.add(j);
                }else{
                    int index = st.pop();
                    res = Math.max(res, row[index]*(j- ( st.isEmpty() ? -1 : st.peek() ) -1));
                    j--;
                }
            }
        }
        return res;
    }
}
