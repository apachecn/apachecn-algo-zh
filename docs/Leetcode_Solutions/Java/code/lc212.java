package code;
/*
 * 212. Word Search II
 * 题意：找出字符数组中路径可以拼出的字符串
 * 难度：Hard
 * 分类：Backtracking, Trie
 * 思路：暴力搜索回溯法就可以AC
 *      更好的方法是借助字典树数据结构进行剪枝，减少重复的搜索路径
 *      https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
 * Tips：
 */
import java.util.ArrayList;
import java.util.List;

public class lc212 {
    public List<String> findWords(char[][] board, String[] words) {
        //暴力搜索
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[0].length ; j++) {
                for (int k = 0; k < words.length ; k++) {
                    char[] str = words[k].toCharArray();
                    if(dfs(board, i, j, str, 0)&&!res.contains(words[k])) res.add(words[k]);  //记得去重
                }
            }
        }
        return res;
    }
    public boolean dfs(char[][] board, int i, int j, char[] str, int index){
        if(i<0||j<0||i>=board.length||j>=board[0].length||index>=str.length) return false;
        if(board[i][j]==str[index]){
            if(index==str.length-1) return true;
            board[i][j] = '0';
            boolean res = dfs(board, i+1, j, str, index+1)||
                    dfs(board, i-1, j, str, index+1)||
                    dfs(board, i, j+1, str, index+1)||
                    dfs(board, i, j-1, str, index+1);   //用res记录结果，重置字符以后再返回
            board[i][j] = str[index];   //记得回溯后重置为原来的字符
            return res;
        }
        return false;
    }
}
