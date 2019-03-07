package code;

import java.util.HashSet;
import java.util.Set;

/*
 * 128. Longest Consecutive Sequence
 * 题意：无序数组，求最长连续子序列的长度
 * 难度：Hard
 * 分类：Array, Union Find
 * 思路：用set先把所有元素放一遍，再遍历，每次找边界，remove掉
 * Tips：也可以只用一个循环，每次放进去以后，更新边界的值即可
 */
public class lc128 {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet();
        for(int i:nums) s.add(i);
        int max_len = 0;
        for(int i:nums) {
            if(s.contains(i)){
                s.remove((Integer)i);
                int left = i-1;
                while(s.contains(left)){
                    s.remove((Integer)left);
                    left--;
                }
                int right = i+1;
                while(s.contains(right)){
                    s.remove((Integer)right);
                    right++;
                }
                max_len = Math.max(right-left-1, max_len);
            }
        }
        return max_len;
    }
}
