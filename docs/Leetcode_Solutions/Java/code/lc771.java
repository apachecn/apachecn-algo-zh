package code;
/*
 * 771. Jewels and Stones
 * 题意：S中出现的字符，在J中也出现的个数
 * 难度：Easy
 * 分类：Hash Table
 * 思路：
 * Tips：
 */
public class lc771 {
    public int numJewelsInStones(String J, String S) {
        int res=0;
        for(char c : S.toCharArray()){
            if(J.indexOf(c) != -1){
                res++;
            }
        }
        return res;
    }
}
