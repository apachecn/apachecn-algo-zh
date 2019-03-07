package code;
/*
 * 58. Length of Last Word
 * 题意：最后一个单词的长度
 * 难度：Easy
 * 分类：String
 * 注意：要考虑空字符，串首尾空格等情况
 */
public class lc58 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("aaa"));
    }

    public static int lengthOfLastWord(String s) {
        int pointer = s.length()-1;
        while(pointer>=0 && s.charAt(pointer)==' ')
            pointer--;
        int end = pointer;
        while( pointer>=0 && s.charAt(pointer)!=' ')
            pointer--;
        return end-pointer;
    }
}
