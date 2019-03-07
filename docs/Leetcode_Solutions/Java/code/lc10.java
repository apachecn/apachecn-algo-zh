package code;
/*
 * 10. Regular Expression Matching
 * 题意：正则表达式匹配
 * 难度：Hard
 * 分类：String, Dynamic Programming, Backtracking
 * Tips：可用递归的方法，每次判断两位字符。 也可用dp方法。
 */
public class lc10 {
    public static void main(String[] args) {
        System.out.println(isMatch("aaa","ab*a*c*a"));
    }

    public static boolean isMatch(String s, String p) {
        // dp[i][j] = true 表示 s[0~(i-1)],p[0~(j-1)] 匹配
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        //初始化dp[0][i]. dp[i][0]不用初始化,因为一定为false.
        for (int i = 1; i < p.length()+1 ; i++) {
            if(p.charAt(i-1)=='*')
                if(i>1 && dp[0][i-2])
                    dp[0][i] = true;
        }
        for (int i = 1; i < s.length()+1 ; i++) {
            for (int j = 1; j < p.length()+1 ; j++) {
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.')
                    dp[i][j] = dp[i-1][j-1];
                if (p.charAt(j-1)=='*') {
                    if(s.charAt(i-1)!=p.charAt(j-2) && p.charAt(j-2)!='.'){
                        //判断s最后一位与 * 前一位是否匹配，若不匹配，则 char* 匹配空，*表示前边字符出现0次
                        dp[i][j] = dp[i][j-2];
                    }else{
                        dp[i][j] = (dp[i-1][j] || dp[i-1][j-1] || dp[i][j-2]);
                        //dp[i-1][j] * 表示前面字符出现多次
                        //dp[i-1][j-1] * 表示前面字符出现一次  dp[i]dp[j-1]也行
                        // dp[i][j-2] *表示前边字符出现0次，覆盖这些情况. s="ba" p="baa*"; s="a" p="ab*a*"
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
