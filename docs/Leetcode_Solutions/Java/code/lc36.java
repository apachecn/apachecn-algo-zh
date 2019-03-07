package code;
/*
 * 36. Valid Sudoku
 * 题意：横排，竖排，3*3不能包含相同数字
 * 难度：Medium
 * 分类：Hash Table
 * 思路：用一个Set即可，把行号，列号拼上去
 * Tips：注意add如果已经有了，返回的是false
 */
import java.util.HashSet;

public class lc36 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hs = new HashSet();  // 如果此set已包含该元素，则该调用不更改set并返回false。
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[0].length ; j++) {
                if(board[i][j]=='.') continue;
                boolean flag1 = hs.add(board[i][j]+"row"+i);
                boolean flag2 = hs.add(board[i][j]+"col"+j);
                boolean flag3 = hs.add(board[i][j]+"box"+i/3+j/3);
                if((!flag1)||(!flag2)||(!flag3)) {
                    return false;
                }
            }
        }
        return true;
    }
}
