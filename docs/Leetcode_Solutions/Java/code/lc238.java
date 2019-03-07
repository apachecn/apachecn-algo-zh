package code;
/*
 * 238. Product of Array Except Self
 * 题意：数组中除了nums[i]的乘积
 * 难度：Medium
 * 分类：Array
 * 思路：左右两个方向简单dp，空间压缩以后可以直接迭代的方法算
 * Tips：
 */
public class lc238 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1]*nums[i-1];
        }
        int temp = 1;   //用temp记录右边值，每次迭代一下
        res[nums.length-1] = res[nums.length-1] * temp;
        for (int i = nums.length-2; i>=0 ; i--) {
            temp = temp * nums[i+1];
            res[i] = res[i] * temp;
        }
        return res;
    }
}
