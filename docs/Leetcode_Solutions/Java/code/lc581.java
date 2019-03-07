package code;
/*
 * 581. Shortest Unsorted Continuous Subarray
 * 题意：找出数组中需要排序的长度
 * 难度：Easy
 * 分类：Array
 * 思路：
 * Tips：直接写出来的
 */
public class lc581 {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length<2)
            return 0;
        int left =0, right = 0;
        int temp = nums[nums.length-1];
        for (int i = nums.length-2; i >=0 ; i--) {
            if(nums[i]>temp) left = i;          //小于最小值就不用排序了，大于的话记录一下
            if(nums[i]<temp) temp = nums[i];    //记录最小值
        }
        temp = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            if(nums[i]<temp) right = i;     //找right
            if(nums[i]>temp) temp = nums[i];
        }
        return left==right? 0 : right-left+1;
    }
}
