package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
 * 140. Word Break II
 * 题意：给定词典，比照词典切字符串，能切出几种情况
 * 难度：Hard
 * 分类：Dynamic Programming, Backtracking
 * 思路：回溯法
 * Tips：和139做对比，因为需要每步骤返回值，所以递归的方法在这题更合适
 */
public class lc140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if(s.length()==0) return res;
        return helper(s, wordDict, new HashMap<>());
    }

    public List<String> helper(String s, List<String> wordDict, HashMap<String, List<String>> hm){
        List<String> res = new ArrayList<>();
        if(hm.containsKey(s)) return hm.get(s);     //hm用以记录子结果，之前递归已计算出，则直接返回。备忘录算法。
        for (int i = s.length()-1; i >=0 ; i--) {
            String cut_str = s.substring(i);
            if(wordDict.contains(cut_str)){
                List<String> ls = helper(s.substring(0,i), wordDict, hm);   //切掉以后剩下的字符串的结果
                for(String str:ls){
                    res.add(str+" "+cut_str);   //结果拼上切掉的字符串
                }
                if(i==0){   //切完了，不需要拼空格。hm中没有保存键值为""的，上个循环不会有效果。
                    res.add(cut_str);
                }
                hm.put(s, res);
            }
        }
        return res;
    }
}
