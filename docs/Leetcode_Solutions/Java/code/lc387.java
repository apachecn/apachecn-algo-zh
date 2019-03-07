package code;
/*
 * 387. First Unique Character in a String
 * 题意：第一个没有重复的字符索引
 * 难度：Easy
 * 分类：Hash Table, String
 * 思路：
 * Tips：
 */
public class lc387 {
    public int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}
