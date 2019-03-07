package code;
/*
 * 179. Largest Number
 * 题意：给一个由数字组成的数组，返回排列组合成的最大数
 * 难度：Medium
 * 分类：Sort
 * 思路：两个数字，i+j 与 j+i 比较，排序。
 *      学会实现Comparator接口
 * Tips：要先转换成string再实现Comparator接口，直接比较字符串，比较数字会报错。。。
 */
import java.util.Arrays;
import java.util.Comparator;

public class lc179 {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];    //先转换成string再比较
        for (int i = 0; i < strs.length ; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {    // Comparator接口
            @Override
            public int compare(String i, String j) {
                String s1 = i+j;    // i+j 与 j+i 比较
                String s2 = j+i;
                return s2.compareTo(s1);
            }
        });
        if(strs[0].equals("0")) return "0";     //防止"000"的情况
        String res = "";
        for (String str:strs) {
            res+=str;
        }
        return res;
    }
}
