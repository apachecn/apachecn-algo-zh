package code;

import java.util.*;

/*
 * 49. Group Anagrams
 * 题意：相同字母组合的字符串分到一个组里
 * 难度：Medium
 * 分类：Hash Table, String
 * Tips：思路很直接，用map即可.注意java和python的不一样，不能用set集合做key，即使set的内容一样，但java类似指针的引用方式，使得set不可能相等.
 */
public class lc49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> m = new HashMap();
        for (int i = 0; i < strs.length ; i++) {
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);
            if(m.containsKey(key))
                m.get(key).add(strs[i]);
            else {
                ArrayList<String> l = new ArrayList<String>();
                l.add(strs[i]);
                m.put(key,l);
            }
        }
        return new ArrayList(m.values());
    }
}
