package code;
/*
 * 300. Longest Increasing Subsequence
 * 题意：最长递增子数组，不一定是连续的
 * 难度：Medium
 * 分类：Binary Search, Dynamic Programming
 * 思路：基本的思路是dp[i]记录以nums[i]结尾的最长长度，每次遍历 dp[i] 得到dp[i+1]，复杂度为O(n^2)。最优的解法是O(nlgn)，dp[i]是递增的数组，每次插入时二分查找是lgn。
 * Tips：经典题目，记一下
 */
import java.util.Arrays;

public class lc300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length<2)
            return nums.length;
        int[] dp = new int[nums.length]; //dp[i] 存储以nums[i]结尾的最大长度
        Arrays.fill(dp,1);
        int res = 1;
        for (int i = 1; i < nums.length ; i++) {
            for (int j = 0; j < i ; j++) {
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int lengthOfLIS2(int[] nums) {
        if(nums.length<2)
            return nums.length;
        int size = 0;   //size指dp中递增的长度。  dp[0~i] 表示了长度为 i+1 的递增子数组，且最后一个值是最小值
        int[] dp = new int[nums.length];    //dp存储递增的数组，之后更新这个数组。如果x>最后一个值，则插入到末尾，否则更新对应位置上的值为该值。
        for (int i = 0; i < nums.length ; i++) {
            int left = 0;
            int right = size;
            while(left!=right){ //得到要插入的位置
                int mid = (left+right)/2;
                if(dp[mid]<nums[i])
                    left = mid+1;
                else
                    right = mid;
            }
            dp[left] = nums[i];
            if(left==size) size++;
        }
        return size;
    }
}
