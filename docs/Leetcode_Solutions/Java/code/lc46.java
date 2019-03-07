package code;

import java.util.ArrayList;
import java.util.List;

/*
 * 46. Permutations
 * 题意：全排列
 * 难度：Medium
 * 分类：Backtracking
 * 思路：典型的回溯题,注意判断下相同元素重复添加,和lc39,lc78做比较
 */
public class lc46 {
    public static void main(String[] args) {
        int nums[] = {};
        System.out.println(permute(nums).toString());
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res,nums,new ArrayList());
        return res;
    }
    public static void backtracking(List<List<Integer>> res, int[] nums, List l){
        if(l.size()==nums.length){
            res.add(new ArrayList<>(l));
            return;
        }

        for (int i = 0; i < nums.length ; i++) {
            if(l.contains((Integer)nums[i]))    //防止相同的元素再次添加
                continue;
            l.add(nums[i]);
            backtracking(res,nums,l);
            l.remove((Integer)nums[i]);
        }
    }

}
