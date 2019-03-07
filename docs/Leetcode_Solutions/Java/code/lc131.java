package code;

import java.util.ArrayList;
import java.util.List;
/*
 * 131. Palindrome Partitioning
 * 题意：回文切割，找出所有切法
 * 难度：Medium
 * 分类：Backtracking
 * 思路：典型回溯法，注意向res添加内容时要重新new一下
 * Tips：lc39
 */
public class lc131 {
    public static void main(String[] args) {
        List res = partition("aab");
        System.out.println();
    }
    public static  List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(s, res, new ArrayList<>());
        return res;
    }

    public static void helper(String s, List<List<String>> res, List<String> curr){
        if(s.length()==0) {
            res.add(new ArrayList<>(curr));  //新new一个
        }
        for (int i = 1; i <= s.length() ; i++) {
            String curr_str = s.substring(0,i);
            if(isPalindrome(curr_str)){
                curr.add(curr_str);
                helper(s.substring(i), res, curr);
                curr.remove(curr.size()-1);     //不要用curr.remove(curr_str); 会把集合内顺序打乱，AC不了
            }
        }
    }

    public static boolean isPalindrome(String s){   //判断是否为回文
        int b =0;
        int e = s.length()-1;
        while(b<e){
            if(s.charAt(b)!=s.charAt(e))
                return false;
            b++;
            e--;
        }
        return true;
    }
}
