package code;
/*
 * 384. Shuffle an Array
 * 题意：重排列一个数组，每个值在每个位置的概率都是均匀的
 * 难度：Medium
 * 分类：
 * 思路：
 * Tips：
 */
public class lc384 {
    public class Solution {

        private int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] rand = new int[nums.length];
            for (int i = 0; i < nums.length; i++){
                int r = (int) (Math.random() * (i+1));
                rand[i] = rand[r];
                rand[r] = nums[i];
            }
            return rand;
        }
    }
}
