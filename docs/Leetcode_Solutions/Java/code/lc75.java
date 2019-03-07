package code;
/*
 * 75. Sort Colors
 * 题意：重排序，数组中只有0,1,2
 * 难度：Medium
 * 分类：Array, Two Pointers, Sort
 * 思路：两个指针，尾指针放2，头指针放1
 * Tips：一个for循环就可以了，注意避免自己与自己交换，造成l>i
 */
public class lc75 {
    public static void main(String[] args) {
        int[] nums = {1,0,2};
        sortColors(nums);
        for (int i = 0; i < nums.length ; i++) {
            System.out.println(nums[i]);
        }
    }
    public static void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        for (int i = 0; i <= r ; i++) {  // i<r而不是length, 否则又换回来了
            if(nums[i]==0 && i!=l ){    //避免自己与自己交换
                int temp = nums[l];
                nums[l] = nums[i];
                nums[i] = temp;
                l++;
                i--;
            }else if(nums[i]==2){
                int temp = nums[r];
                nums[r] = nums[i];
                nums[i] = temp;
                r--;
                i--;
            }
        }
    }
}
