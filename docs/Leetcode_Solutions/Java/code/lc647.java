package code;
/*
 * 647. Palindromic Substrings
 * 题意：一个字符串里有多少个回文子串
 * 难度：Medium
 * 分类：String, Dynamic Programming
 * 思路：时间为N^2，用二维dp空间复杂度是N^2. 该题直接让判断是否回文，直接选择找中心字符，向两边拓展，空间为O(1)
 * Tips：
 */
public class lc647 {
    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }
    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length() ; i++) {
            for (int j = 0; j <2 ; j++) {   //中心可能是两个字符，也可能是一个字符
                int left = i;
                int right = left+j;
                while( left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                    count++;
                    left--;
                    right++;
                }
            }
        }
        return count;
    }
}
