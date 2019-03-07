package code;
/*
 * 152. Maximum Product Subarray
 * 题意：连续子序列最大乘积
 * 难度：Medium
 * 分类：Array, Dynamic Programming
 * 思路：保存最大，最小值，因为负负得正。dp不用保存数组，空间可以压缩。
 * Tips：Product是乘的意思
 */
public class lc152 {
    public static void main(String[] args) {
        int[] nums = {-4,-3,-2};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], res = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            if(nums[i]>0){
                max = Math.max(nums[i],nums[i]*max);
                min = Math.min(nums[i],nums[i]*min);
            }else{
                int temp = max; //注意maxh会被替换，先保存下
                max = Math.max(nums[i],nums[i]*min);
                min = Math.min(nums[i],nums[i]*temp);
            }
            res = Math.max(max, res);
        }
        return res;
    }
}
