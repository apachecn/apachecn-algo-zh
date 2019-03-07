package code;
/*
 * 242. Valid Anagram
 * 题意：字符串t是否为s打乱后的重排列
 * 难度：Easy
 * 分类：Hash Table, Sort
 * 思路：hash table 计算即可，<0了直接返回false
 * Tips：和重排列那题联系一下 lc46
 */
public class lc242 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] chs = new int[26];
        for(int i=0; i<s.length(); i++){
            chs[s.charAt(i)-'a']++;
        }
        for(int i=0; i<t.length(); i++){
            chs[t.charAt(i)-'a']--;
            if(chs[t.charAt(i)-'a']<0) return false;
        }
        return true;
    }
}
