package code;
/*
 * 395. Longest Substring with At Least K Repeating Characters
 * 题意：求最长子串，子串中每个字符都必须最少出现K次
 * 难度：Medium
 * 分类：
 * 思路：两种，一种是 Two Pointers 模板找子串，不过外层加了个循环，表示子串中有几个不同的字符
 *      递归，每次统计字符出现了几次，不足K的作为分割点
 * Tips：lc76模板
 *       想到了利用不足K的分割点作为切点，挺难的
 */
public class lc395 {
    public int longestSubstring(String s, int k) {
        int res = 0;
        for (int i = 1; i <= 26 ; i++) {
            int left = 0, right = 0, cur_uni_char = 0, less_than_k_char = 0;
            int[] map = new int[26];
            while(right<s.length()){    //右边推进
                map[s.charAt(right)-'a']++;
                if(map[s.charAt(right)-'a']==k) less_than_k_char++;
                if(map[s.charAt(right)-'a']==1) cur_uni_char++;
                right++;

                if( cur_uni_char==i && less_than_k_char==i) res = Math.max(res, right-left);

                else if(cur_uni_char>i){    //左边推进
                    while(cur_uni_char!=i){
                        map[s.charAt(left)-'a']--;
                        if(map[s.charAt(left)-'a']==0) cur_uni_char--;
                        if((map[s.charAt(left)-'a']==k-1)) less_than_k_char--;
                        left++;
                    }
                }
            }
        }
        return res;
    }

    public int longestSubstring2(String s, int k) {
        return helper(s, k, 0, s.length()-1);
    }
    public int helper(String s, int k, int left, int right){
        int[] map = new int[26];
        for (int i = left; i <= right ; i++) map[s.charAt(i)-'a']++;
        for (int i = left; i <= right ; i++) {  //遍历所有的分割点
            if(map[s.charAt(i)-'a']<k){
                int left_max = helper(s, k, left, i-1);
                int right_max = helper(s, k, i+1, right);
                return Math.max(left_max, right_max);   //直接返回了，就不遍历后续了，因为子情况会去计算后续的分割点
            }
        }
        return right-left+1;
    }
}
