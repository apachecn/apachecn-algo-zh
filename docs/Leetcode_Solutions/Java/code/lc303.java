package code;
/*
 * 303. Range Sum Query - Immutable
 * 题意：i到j的和
 * 难度：Easy
 * 分类：Dynamic Programming
 * 思路：
 * Tips：Bingo!
 */
public class lc303 {
    class NumArray {
        int[] arr;
        public NumArray(int[] nums) {
            arr = nums;
            for(int i=1; i<arr.length; i++){
                arr[i] = arr[i-1]+arr[i];
            }
        }

        public int sumRange(int i, int j) {
            return i==0? arr[j] : arr[j]-arr[i-1];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
}
