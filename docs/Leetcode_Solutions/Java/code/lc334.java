package code;
/*
 * 334. Increasing Triplet Subsequence
 * 题意：数组中是否存在递增的3个数
 * 难度：Medium
 * 分类：Array
 * 思路：思路很清奇，自己没想到，时间空间复杂度都是O(1)。其实和lc300 O(nlgn) 解法思路是一样的，只是固定了dp数组长度为两个数。
 * Tips：lc300最长递增子序列
 */
public class lc334 {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i]<small) small = nums[i];
            else if(nums[i]<big) big = nums[i];
            else return true;
        }
        return false;
    }
}
