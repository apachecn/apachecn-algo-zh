package code;
/*
 * 28. Implement strStr()
 * 题意：找出子串在给定字符串的起始位置
 * 难度：Easy
 * 分类：Two Pointers, String
 * Tips：注意判断子串为空的方法为needle.length()==0，不要用needle==""
 */
public class lc28 {
    public static void main(String[] args) {
        String haystack = "aaaaa";
        String needle = "ab";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if(needle.length()==0)
            return 0;
        int cur1 = 0, cur2 = 0;
        while(cur1<haystack.length()){
            if(haystack.charAt(cur1)==needle.charAt(cur2)){
                cur1++;
                cur2++;
                if(cur2==needle.length())
                    return cur1-cur2;
            }else{
                cur1++;
                cur1 = cur1-cur2;
                cur2 = 0;
            }
        }
        return -1;
    }
}
