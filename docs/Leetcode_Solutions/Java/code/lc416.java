package code;

import java.util.HashSet;
/*
 * 416. Partition Equal Subset Sum
 * 题意：一个数组，可否分成和相等的两部分
 * 难度：Medium
 * 分类：Dynamic Programming
 * 思路：题意可以转换为用任意个元素组成的和等于数组和/2。可以和 lc1, lc15 3-Sum 对比。
 *      0，1背包问题，递推比较简单，所以空间可以压缩成一维
 *      自己想的思路其实和压缩后的0，1背包类似，但没想到该问题可以抽象为0，1背包
 * Tips：
 */
public class lc416 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        System.out.println(canPartition(nums));
    }
    public static boolean canPartition(int[] nums) {    //自己写的不知道什么，回头看已经看不懂自己的代码了。。。
        int sum = 0;
        for (int i : nums) {
            sum+=i;
        }
        if(sum%2==1)
            return false;
        sum/=2;
        HashSet<Integer> s = new HashSet();
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i]==sum)
                return true;
            HashSet<Integer> s2 = new HashSet();    // 新建一个set,用以存放这一轮的结果
            s2.add(nums[i]);
            for(int j: s){
                if(j+nums[i]==sum)
                    return true;
                s2.add(j+nums[i]);
            }
            s.addAll(s2);
        }
        return false;
    }

    public boolean canPartition2(int[] nums) {
        // check edge case
        if (nums == null || nums.length == 0) {
            return true;
        }
        // preprocess
        int volumn = 0;
        for (int num : nums) {
            volumn += num;
        }
        if (volumn % 2 != 0) {
            return false;
        }
        volumn /= 2;
        // dp def
        boolean[] dp = new boolean[volumn + 1];
        // dp init
        dp[0] = true;
        // dp transition
        for (int i = 1; i <= nums.length; i++) {
            for (int j = volumn; j >= nums[i-1]; j--) { //从后往前更新，压缩空间
                dp[j] = dp[j] || dp[j - nums[i-1]];
            }
        }
        return dp[volumn];
    }
}
