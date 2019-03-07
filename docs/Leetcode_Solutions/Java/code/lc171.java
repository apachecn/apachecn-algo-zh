package code;
/*
 * 171. Excel Sheet Column Number
 * 题意：Excel列的表示转换为数字
 * 难度：Easy
 * 分类：Math
 * 思路：注意AA代表的是27， 没有0的表示。26进位不是27。
 * Tips：
 */
public class lc171 {
    public int titleToNumber(String s) {
        char[] ch_arr = s.toCharArray();
        int res = 0;
        for(int i=0; i<ch_arr.length; i++){
            res += ( (ch_arr[i]-'A'+1) * Math.pow(26, ch_arr.length-1-i) );
        }
        return res;
    }
}
