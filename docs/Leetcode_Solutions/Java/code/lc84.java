package code;

import java.util.Stack;

/*
 * 84. Largest Rectangle in Histogram
 * 题意：直方图中最大矩形面积
 * 难度：Hard
 * 分类：Array, Stack
 * 思路：两种方法：1.用dp找到边界，再遍历一遍; 2.用栈，栈内存索引，保证栈内索引对应的高度是递增的，若减了即找到了右边界，出栈开始计算。因为栈内是递增的，左边界就是上个栈内的元素。若栈为空，左边界就是-1。
 * Tips：和lc42做比较，都可以用栈或者dp来做. 很难，栈的操作很难想到.
 *
 */
public class lc84 {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
        System.out.println(largestRectangleArea2(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack();
        int res = 0;
        for (int i = 0; i <= heights.length ; i++) {
            int h = (i == heights.length ? 0 : heights[i]);
            if( st.size()==0 || h>heights[st.peek()] ){ //递增入栈，保证栈内索引对应的Height递增
                st.push(i);
            }else{
                int n = st.pop();
                int left;
                if(st.isEmpty())
                    left = -1;  //若为空，则到最左边
                else
                    left = st.peek();
                res = Math.max(res, heights[n] * (i-left-1)); //i之前的，要-1
                i--;
            }
        }
        return res;
    }

    public static int largestRectangleArea2(int[] heights) {
        int[] leftMax = new int[heights.length];
        int[] rightMax = new int[heights.length];
        for (int i = 0; i < heights.length ; i++) { //get leftMax  注意这样dp时数组中保存的边界必须是i-1或i+1，否则无法dp传递
            int p = i-1;
            while( p>=0 && heights[p]>=heights[i]){
                p = leftMax[p];
            }
            leftMax[i] = p;
        }
        for (int i = heights.length-1; i >= 0 ; i--) { //get rightMax
            rightMax[i] = i;
            int p = i+1;
            while( p<heights.length && heights[p]>=heights[i]){
                p = rightMax[p];
            }
            rightMax[i] = p;
        }
        int res = 0;
        for (int i = 0; i < heights.length ; i++) {
            res = Math.max(res,(rightMax[i]-leftMax[i]-1)*heights[i]);
        }
        return res;
    }
}
