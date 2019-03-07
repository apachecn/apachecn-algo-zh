package code;
/*
 * 301. Remove Invalid Parentheses
 * 题意：删掉不匹配的括号
 * 难度：Hard
 * 分类：Depth-first Search, Breadth-first Search
 * 思路：先计数),如果多的话,在前边的字符里删掉一个。反转字符串,计数(
 * Tips：好难啊，里边很多细节需要注意。还有一种bfs的思路，挨个删字符，判断是否合规。
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class lc301 {
    public static void main(String[] args) {
        System.out.println(removeInvalidParentheses("()())()").toString());
    }
    public static List<String> removeInvalidParentheses(String s) {
        HashSet<String> res = new HashSet();
        StringBuilder sb = new StringBuilder();
        helper(s, res, 0, 0, new char[]{'(',')'});
        return new ArrayList<>(res);
    }
    public static void helper(String s, HashSet<String> res, int pos, int pos2, char[] chs){
        int count = 0;
        char[] str_arr = s.toCharArray();
        for (int i = pos; i < s.length() ; i++) {
            if( str_arr[i]==chs[0] )
                count++;
            else if( str_arr[i]==chs[1] )
                count--;
            if (count < 0) {    //需要删除一个 ')'
                for (int j = pos2; j <= i; j++) {   // pos2 避免重复的情况又算一次
                    if (str_arr[j] == chs[1] && j == 0)
                        helper(s.substring(0,j)+s.substring(j+1), res, i, j,chs);
                    if (str_arr[j] == chs[1] && j > 0 && str_arr[j - 1] != chs[1])
                        helper(s.substring(0,j)+s.substring(j+1), res, i, j,chs);  //把截取后的s传到递归函数里， i不用+1，因为已经删掉一个字符了
                }
                return;
            }
        }
        s = new StringBuilder(s).reverse().toString();
        if(chs[0]=='(')
            helper(s, res, 0, 0, new char[]{')','('}); //反转
        else
            res.add(s);
    }
}
