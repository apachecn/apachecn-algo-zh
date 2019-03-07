package code;

import java.util.HashSet;
/*
 * 217. Contains Duplicate
 * 题意：数组中是否有重复的数字
 * 难度：Easy
 * 分类：Array, Hash Table
 * 思路：用Hashset记录是否有重复
 * Tips：
 */
public class lc217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet hs = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++){
            if(hs.contains(nums[i])) return true;
            hs.add(nums[i]);
        }
        return false;
    }
}
