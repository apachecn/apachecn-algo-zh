package code;

import java.util.Arrays;

/*
 * 324. Wiggle Sort II
 * 题意：小大小大小大 这样排序
 * 难度：Medium
 * 分类：Sort
 * 思路：先找到中位数，然后一个小于中位数的，一个大于中位数的这样组合
 *      用 index map 的方式可以使空间也为O(1)
 * Tips：挺难的。
 */
public class lc324 {
    public void wiggleSort(int[] nums) {
        if(nums.length==1) return;
        int n = nums.length, m = (n + 1) >> 1;// (nums.length+1)/2 注意+1
        int[] copy = Arrays.copyOf(nums, n);
        int median = findMedium(nums, 0, nums.length-1, m);

        for (int i = 0, j = 0, k = n - 1; j <= k;) {    // <medium的放左边， >在右边
            if (copy[j] < median) {
                swap(copy, i++, j++);
            } else if (copy[j] > median) {
                swap(copy, j, k--);
            } else {
                j++;
            }
        }

        for (int i = m - 1, j = 0; i >= 0; i--, j += 2) nums[j] = copy[i];  //注意这点细节，i--倒着来，防止中位数重复的情况bug
        for (int i = n - 1, j = 1; i >= m; i--, j += 2) nums[j] = copy[i];
    }



    private int getMiddle(int[] nums, int l, int r) {
        int i = l;

        for (int j = l + 1; j <= r; j++) {
            if (nums[j] < nums[l]) swap(nums, ++i, j);
        }

        swap(nums, l, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    public static int findMedium(int[] nums, int left, int right, int k){
        int cur = nums[left];
        int l = left;
        int r = right;
        while(left<right){
            while( left<right && nums[right]>=nums[left] ) right--;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            while( left<right && nums[left]<nums[right]) left++;
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        if(left==k-1) return nums[left];
        else if(left>=k) return findMedium(nums, l, right-1, k);
        else return findMedium(nums, right+1, r, k);
    }

    public static int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }
}
