package code;
/*
 * 79. Word Search
 * 题意：在字符数组中搜索字符串
 * 难度：Medium
 * 分类：Array, Backtracking
 * 思路：回溯法
 * Tips：访问过的格子要标记，不能重复访问。回溯法注意回来的时候要重置标志位。向下找的时候直接找4个方向的，回来的时候不用再找了，只需重置标志位。
 */
public class lc79 {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board,"SEE"));
    }

    public static boolean exist(char[][] board, String word) {
        if(board.length==0)
            return false;
        boolean [][] flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[0].length ; j++) {
                if(search(board,word,i,j,0,flag))
                    return true;
            }
        }
        return false;
    }

    public static boolean search(char[][] board, String word, int i, int j, int sum, boolean[][] flag){
        if(sum==word.length())
            return true;
        if(i<0||j<0||i>=board.length||j>=board[0].length)
            return false;
        if(board[i][j]!=word.charAt(sum)||flag[i][j]==true)
            return false;
        flag[i][j] = true;
        sum++;
        boolean r = search(board, word, i, j+1, sum, flag)  || search(board, word, i, j-1, sum, flag) || search(board, word, i+1, j, sum, flag) ||search(board, word, i-1, j, sum, flag);
        flag[i][j] = false;
        return r;
    }
}
