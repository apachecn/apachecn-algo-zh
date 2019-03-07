package code;
/*
 * 127. Word Ladder
 * 题意：给定开始字符串，结束字符串，和一个字符串数组，每次替换字符串中的一个字符，问最少几个步骤变为终止字符串
 * 难度：Medium
 * 分类：Breadth-first Search
 * 思路：bfs, 利用双向bfs可以加快搜索https://leetcode.com/problems/word-ladder/discuss/40711/Two-end-BFS-in-Java-31ms.
 * Tips：拓扑排序，很经典的BFS，好好看看
 */
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class lc127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Queue<String> qu = new ArrayDeque();    //用一个Queue和int size类似树的层次遍历，和两个hashset效果一样
        qu.add(beginWord);
        int level = 2;
        while(!qu.isEmpty()){
            int size = qu.size();
            for (int i = 0; i < size ; i++) {
                char[] curr_str = qu.remove().toCharArray();
                System.out.println(String.valueOf(curr_str));
                for (int j = 0; j < curr_str.length ; j++) {
                    char ch = curr_str[j];
                    for (char k = 'a'; k <='z' ; k++) { //如果每次比较两个字符串是否差一位，时间复杂度太大，所以直接替换一个字符
                        curr_str[j] = k;
                        if(String.valueOf(curr_str).equals(endWord)) return level;
                        if(wordList.contains(String.valueOf(curr_str))){
                            wordList.remove(String.valueOf(curr_str));
                            qu.add(String.valueOf(curr_str));
                        }
                    }
                    curr_str[j] = ch;
                }
            }
            level++;
        }
        return 0;
    }
}
