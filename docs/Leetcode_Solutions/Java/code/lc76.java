package code;
/*
 * 76. Minimum Window Substring
 * 题意：字符串s中找出能包含t所有字母的最短串
 * 难度：Hard
 * 分类：Hash Table, Two Pointers, String
 * 思路：两个指针，移动右指针使得满足条件，移动左指针缩短距离。用hashmap存储进行判断是否满足条件。
 * Tips：很难的题，思路记一下。
 *      https://leetcode.com/problems/minimum-window-substring/discuss/26808/here-is-a-10-line-template-that-can-solve-most-substring-problems
 */
import java.util.HashMap;

public class lc76 {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
    public static String minWindow(String s, String t) {
        HashMap<Character,Integer> mp = new HashMap();
        for (int i = 0; i < t.length() ; i++) { //统计每个字符出现的个数
            char ch = t.charAt(i);
            if(mp.containsKey(ch))
                mp.put(ch,mp.get(ch)+1);
            else
                mp.put(t.charAt(i),1);
        }
        int right = 0;
        int left = 0;
        int count = 0;
        int res_left = 0;
        int res_len = s.length()+1;
        while(right<s.length()){
            // 移动右指针,到能够覆盖t
            char ch_r = s.charAt(right);
            if(mp.containsKey(ch_r)){
                mp.put(ch_r,mp.get(ch_r)-1);
                if(mp.get(ch_r)>=0) // <0说明重复了
                    count++;
            }
            while(count==t.length()){//右移左指针
                if(right-left+1<res_len){ //更新结果
                    res_left = left;
                    res_len = right-left+1;
                }
                char ch_l = s.charAt(left);
                if(mp.containsKey(ch_l)){
                    mp.put(ch_l,mp.get(ch_l)+1);
                    if(mp.get(ch_l)>0)
                        count--;
                }
                left++;
            }
            right++;
        }
        if(res_len==s.length()+1)
            return "";
        return s.substring(res_left,res_left+res_len);
    }
}
