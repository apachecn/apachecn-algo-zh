package code;
/*
* 3. Longest Substring Without Repeating Characters
* 题意：找出字符串中没有重复子串的最大长度
* 难度：Medium
* 分类：Hash Table, Two Pointers, String
* 算法：两个指针，记录没有重复字母的子串的首和尾
*/
import java.util.HashMap;

public class lc3 {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int max = 0;
        int j = 0;
        for (int i = 0; i <s.length() ; i++) {
            if(hm.containsKey(s.charAt(i))) {
                j = Math.max(hm.get(s.charAt(i))+1,j);
                //if input="abbabc"
                //when i = 3, s.chatAt(3) == 'a' ,
                //we will found last 'a' appears at index 0,
                //but we should not update j from 2 ('b') to 0 ('a'),
                //because here although the 'a' is in hashMap, but it appears before 'b'.
            }
            //i到j没有重复的字母，所以+1
            //写到if外，因为可能该串本身就没有重复的字母，以及串首与串尾也要考虑
            max = Math.max(i-j+1,max);
            hm.put(s.charAt(i), i);
        };
        return max;
    }
}
