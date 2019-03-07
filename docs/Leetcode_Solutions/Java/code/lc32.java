package code;

import java.util.Stack;

/*
 * 32. Longest Valid Parentheses
 * 题意：最长有效子串
 * 难度：Hard
 * 分类：Dynamic Programming, String
 * 思路：两种常规方法，一是dp，每个位置记录以该位置结尾的最长长度。另一种是用栈，把位置索引入栈。
 * Tips：想到了用dp，也想到了用数组记录位置结尾的解，但没有想好如何进行更新迭代计算。把位置索引入栈的方法很典型，关注一下。
 */
public class lc32 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses2("()(())"));
    }

    public static int longestValidParentheses(String s) {
        if(s.length()==0)
            return 0;
        // dp 方法
        int[] dp = new int[s.length()+1];
        int res=0;
        for (int i = 2; i <dp.length; i++) {
            if(s.charAt(i-1)=='(')
                dp[i] = 0;
            else{
                if(s.charAt(i-2)=='('){ // 这种情况：(())()
                    dp[i] = dp[i-2]+2;
                }else if(i-2-dp[i-1]>=0 && s.charAt(i-2-dp[i-1])=='('){ // 这种情况：()(())
                    dp[i] = dp[i-1] + dp[i-2-dp[i-1]]+2;
                }
            }
            if(dp[i]>res)
                res = dp[i];
        }
        return res;
    }

    public static int longestValidParentheses2(String s) {
        //栈方法  ()(())
        Stack<Integer> st = new Stack();
        st.add(-1);
        int res = 0;
        for (int i = 0; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if(ch=='(')
                st.add(i);
            else if(ch==')'){
                st.pop();
                if(st.isEmpty())
                    st.push(i);
                res = Math.max(res,i-st.peek());
            }
        }
        return res;
    }
}
