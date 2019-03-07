package code;

import java.util.HashMap;
import java.util.Stack;

/*
 * 20. Valid Parentheses
 * 题意：括号匹配
 * 难度：Easy
 * 分类：String, Stack
 */
public class lc20 {
    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }
    public static boolean isValid(String s) {
        Stack<String> st = new Stack();
        HashMap<String,String> hm = new HashMap();
        hm.put("(",")");
        hm.put("[","]");
        hm.put("{","}");
        for (int i = 0; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{'){
                st.push(String.valueOf(ch));
            }else{
                if(st.size()==0)
                    return false;
                String temp1 = hm.get(st.pop());
                String temp2 = String.valueOf(ch);
                if(!temp1.equals(temp2))
                    return false;
            }
        }
        if(st.size()==0)
            return true;
        return false;
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
