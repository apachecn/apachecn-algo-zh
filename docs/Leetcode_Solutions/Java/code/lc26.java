package code;
/*
 * 26. Remove Duplicates from Sorted Array
 * 题意：移除数组中重复元素
 * 难度：Easy
 * 分类：Array, Two Pointers
 */
public class lc26 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int n = removeDuplicates(nums);
        for (int i = 0; i <n ; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int n = 1;
        for (int i = 1; i < nums.length ; i++) {
            if(nums[i]!=nums[i-1]){
                nums[n] = nums[i];
                n++;
            }
        }
        return n;
    }
}
