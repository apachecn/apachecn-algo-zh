package code;
/*
 * 53. Maximum Subarray
 * 题意：最大连续子序列和
 * 难度：Easy
 * 分类：Array, Divide and Conquer, Dynamic Programming
 * 注意：分治方法如何进行merge，merge时，必须包含mid元素，因为是连续子序列
 */
public class lc53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));
    }

    public static int maxSubArray(int[] nums) {
        // dp[i] 表示以nums[i]结尾的最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i <nums.length ; i++) {
            dp[i] = dp[i-1]>0 ? dp[i-1]+nums[i] : nums[i];
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static int maxSubArray2(int[] nums) {
        return DivideConquer(nums,0,nums.length-1);
    }

    public static int DivideConquer(int[] nums, int start, int end){
        if(start == end)
            return nums[start];
        else{
            int mid = (start+end)/2;
            int left = DivideConquer(nums, start, mid);
            int right = DivideConquer(nums, mid+1, end);
            int temp = 0;
            int lmax = nums[mid];
            for (int i = mid; i >=start ; i--) {
                temp += nums[i];
                lmax = Math.max(temp,lmax);
            }
            temp = 0;
            int rmax = nums[mid+1];
            for (int i = mid+1; i <= end ; i++) {
                temp += nums[i];
                rmax = Math.max(temp,rmax);
            }
            return Math.max(Math.max(left,right),lmax+rmax);
        }
    }
}
