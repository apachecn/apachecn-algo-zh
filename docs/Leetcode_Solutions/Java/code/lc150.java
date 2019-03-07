package code;
/*
 * 150. Evaluate Reverse Polish Notation
 * 题意：波兰表达式运算
 * 难度：Medium
 * 分类：Stack
 * 思路：用栈即可
 * Tips：
 */
import java.util.Stack;

public class lc150 {
    public int evalRPN(String[] tokens) {
        if(tokens.length==1) return Integer.valueOf(tokens[0]);
        Stack<Integer> st = new Stack();
        String opration = "+-*/";
        int res = 0;
        for (int i = 0; i < tokens.length ; i++) {
            if(opration.contains(tokens[i])){
                int n2 = st.pop();  //注意n1,n2顺序，除法时两个数是有顺序的
                int n1 = st.pop();
                System.out.println(n1);
                System.out.println(n2);
                if(tokens[i].equals("+")){  //注意用equeals
                    res = n1 + n2;
                }else if(tokens[i].equals("-")){
                    res = n1 - n2;
                }else if(tokens[i].equals("*")){
                    res = n1 * n2;
                }else if(tokens[i].equals("/")){
                    res = n1 / n2;
                }
                st.push(res);
                System.out.println(res);
            }else{
                st.push(Integer.valueOf(tokens[i]));;
            }
        }
        return res;
    }
}
