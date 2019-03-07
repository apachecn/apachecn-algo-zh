package code;

import java.util.Stack;

/*
 * 227. Basic Calculator II
 * 题意：表达式计算
 * 难度：Medium
 * 分类：String
 * 思路：很巧妙的方法，每次遍历到下一个符号的时候，计算前一个符号的运算，泥面膜了复杂的逻辑。
 *      + - 运算直接入栈，* / 运算则计算后将结果入栈，实现了 * / 优先运算
 * Tips：自己想的方法会非常麻烦。这个解法非常聪明。
 */
public class lc227 {
    public int calculate(String s) {
        char[] chs = s.replace(" ","").toCharArray();
        int num = 0;
        char sign = '+';
        Stack<Integer> st = new Stack();
        for (int i = 0; i < chs.length ; i++) {
            if(Character.isDigit(chs[i])){
                num = num * 10 + chs[i]-'0';
            }
            if( !Character.isDigit(chs[i]) || i==chs.length-1 ){    //便利到最后，即使不是符号，也要计算
                if(sign=='+'){
                    st.push(num);
                }
                else if(sign=='-'){
                    st.push(-num);
                }
                else if(sign=='*'){
                    st.push(st.pop()*num);
                }
                else if(sign=='/'){
                    st.push(st.pop()/num);
                }
                num = 0;
                sign = chs[i];  //非常聪明
            }
        }
        int res = 0;
        for(Integer i : st){
            System.out.println(i);
            res += i;
        }
        return res;
    }
}
