package code;
/*
 * 344. Reverse String
 * 题意：反转字符串
 * 难度：Easy
 * 分类：Two Pointers, String
 * 思路：
 * Tips：
 */
public class lc344 {
    public void reverseString(char[] s) {
        int begin = 0, end = s.length-1;
        while(begin<end){
            char ch = s[begin];
            s[begin] = s[end];
            s[end] = ch;
            begin++;
            end--;
        }
    }
}
