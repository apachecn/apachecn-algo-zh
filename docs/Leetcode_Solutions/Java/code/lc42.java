package code;

import java.util.Stack;

/*
 * 42. Trapping Rain Water
 * 题意：能盛多少水
 * 难度：Hard
 * 分类：Array, Two Pointers, Stack
 * 思路：三种方法:1.DP先求出来每个位置的maxleft,maxright，再遍历一遍;2.两个指针，类似lc11题的思路;3.用栈数据结构;
 * Tips：
 */
public class lc42 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
        System.out.println(trap2(height));
    }
    public static int trap(int[] height) {
        if(height.length<3)
            return 0;
        int left = 0;
        int right = height.length-1;
        int res =0;

        while(left<right){
            if(height[left]<height[right]){
                int edge_l = height[left];
                left++;
                while(height[left]<edge_l && left<right){
                    if(edge_l-height[left]>0)
                        res += edge_l-height[left];
                    left++;
                }
            }else if(height[left]>=height[right] && left<right){
                int edge_r = height[right];
                right--;
                while(height[right]<edge_r){
                    if(edge_r-height[right]>0)
                        res += edge_r-height[right];
                    right--;
                }
            }
        }
        return res;
    }

    public static int trap2(int[] A) {
        //栈方法
        if (A==null) return 0;
        Stack<Integer> s = new Stack<Integer>();
        int i = 0, maxWater = 0, maxBotWater = 0;
        while (i < A.length){
            if (s.isEmpty() || A[i]<=A[s.peek()]){
                s.push(i++);
            }
            else {
                int bot = s.pop();
                maxBotWater = s.isEmpty()? // empty means no il
                        0:(Math.min(A[s.peek()],A[i])-A[bot])*(i-s.peek()-1);
                maxWater += maxBotWater;
            }
        }
        return maxWater;
    }
}
