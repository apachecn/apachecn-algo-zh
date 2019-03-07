package code;
import java.util.List;
import java.util.Vector;
/*
 * 17. Letter Combinations of a Phone Number
 * 题意：手机键盘字母输入
 * 难度：Medium
 * 分类：String, Backtracking
 */
public class lc17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23").toString());
    }

    public static List<String> letterCombinations(String digits) {
        Vector<String> res = new Vector<>();
        if(digits.length()==0)
            return res;
        String[] charmap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int n = digits.charAt(i)-'0';
            Vector<String> temp_res = new Vector<>();
            for (int j = 0; j < charmap[n].length(); j++) {
                for (int k = 0; k < res.size(); k++) {
                    temp_res.add(res.get(k)+charmap[n].charAt(j));
                }
            }

            res = temp_res;
        }
        return res;
    }
}
