package code;
/*
 * 155. Min Stack
 * 题意：设计一个栈，这个栈有一个getmin方法
 * 难度：Easy
 * 分类：Stack, Design
 * 思路：每次替换最小值时，把当前最小值入栈用以记录，以便之后更新最小值
 * Tips：
 */
import java.util.Stack;

public class lc155 {
    class MinStack {
        Stack<Integer> st;
        int min = Integer.MAX_VALUE;
        /** initialize your data structure here. */
        public MinStack() {
            this.st = new Stack<Integer>();
        }

        public void push(int x) {
            if(x<=min){     //别忘了=
                st.push(this.min);
                this.min = x;
            }
            st.push(x);
        }

        public void pop() {
            int x = st.pop();
            if(x==this.min){
                this.min = st.pop();
            }
        }

        public int top() {
            return st.peek();
        }

        public int getMin() {
            return this.min;
        }
    }
}
