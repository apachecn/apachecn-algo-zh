package code;

import java.util.ArrayList;
import java.util.List;

/*
 * 39. Combination Sum
 * 题意：找出和为sum的所有组合
 * 难度：Medium
 * 分类：Array, Backtracking
 * 思路：回溯法
 * Tips：向res添加答案时注意要new一个新的List,否则后续循环的操作会影响res中的L; 设置一个start标志，记录上次数组循环到哪了,防止重复集合。
 * 和lc46,lc78做比较，46是排列组合，所以不需要start标志，start标志是为了防止相同元素的组合排列不同而当做了另一种
 */
public class lc39 {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target).toString());
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates.length==0||target==0)
            return res;
        List<Integer> l = new ArrayList<Integer>();
        backtracking(res,candidates,target,l,0,0);
        return res;
    }

    public static void backtracking(List<List<Integer>> res, int[] candidates, int target, List<Integer> l, int sum, int start){
        for (int i = start; i < candidates.length; i++) {
            l.add(candidates[i]);
            if(sum+candidates[i]==target) {
                res.add(new ArrayList<>(l));//new 新的 List
            } else if(sum+candidates[i]<target){
                backtracking(res, candidates, target, l, sum+candidates[i],i);
            }
            l.remove((Integer)candidates[i]);
        }
    }
}
