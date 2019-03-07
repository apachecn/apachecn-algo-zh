package code;
/*
 * 162. Find Peak Element
 * 题意：找出数组中任意一个山顶点，时间复杂度O(lg(n))，山顶点指该数左右两边都的数都小于他
 * 难度：Medium
 * 分类：Array, Binary Search
 * 思路：二分查找，想好左右两边递归判断。只有nums[mid]<nums[mid+1]，说名右半边就存在峰值
 * Tips：
 */
public class lc162 {
    public int findPeakElement(int[] nums) {
        int[] nums2 = new int[nums.length+2];   //左右加了个最小值
        for (int i = 0; i < nums.length ; i++) {
            nums2[i+1] = nums[i];
        }
        nums2[0] = Integer.MIN_VALUE;
        nums2[nums2.length-1] = Integer.MIN_VALUE;
        return helper(nums2, 1, nums2.length-2)-1;
    }
    public int helper(int[] nums, int left, int right){
        System.out.println(nums.length);
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]>nums[mid+1]&&nums[mid]>nums[mid-1]) return mid;
            if(nums[mid]<nums[mid+1]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }

    public int findPeakElement2(int[] nums) {   //第二种方法不用左右加个边界
        return helper2(nums, 0, nums.length-1);
    }
    public int helper2(int[] nums, int left, int right){
        while(left<right){  //这没有==
            int mid = (left+right)/2;
            if(nums[mid]<nums[mid+1]){
                left = mid+1;
            }else{
                right = mid;      //这没有-1
            }
        }
        return left;
    }
}
