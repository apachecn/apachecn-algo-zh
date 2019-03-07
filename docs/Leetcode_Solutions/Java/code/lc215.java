package code;
/*
 * 215. Kth Largest Element in an Array
 * 题意：找第k大的数
 * 难度：Medium
 * 分类：Divide and Conquer, Heap
 * 思路：快排的思想
 * Tips：经典的题目，记一下代码格式，方便快速写出
 */
public class lc215 {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
    }
    public static int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length-1, k);
    }

    public static int quickSort(int[] nums, int left, int right, int k){
        int origin_l = left;        //left 和 right 移动，但要保存一下原始的值，方便递归调用
        int origin_r = right;
        int cur = nums[left];
        while(left<right) {
            while (left<right && nums[right] < cur)
                right--;
            nums[left] = nums[right];
            while (left<right && nums[left] >= cur)
                left++;
            nums[right] = nums[left];
        }
        nums[left] = cur;
        if(left==k-1)
            return cur;
        else if(left>k-1)
            return quickSort(nums, origin_l, left-1, k);
        else
            return quickSort(nums, left+1, origin_r, k);
    }
}
