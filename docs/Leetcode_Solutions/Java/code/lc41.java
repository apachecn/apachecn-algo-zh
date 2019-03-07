package code;
/*
 * 41. First Missing Positive
 * 题意：返回数组中最小的未出现的正整数
 * 难度：Hard
 * 分类：Array
 * 思路：未出现的正整数一定在 [1~nums.length+1] 中，理解了这一点就好做了
 * Tips：
 */
public class lc41 {
    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println(firstMissingPositive(nums));
    }
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i]>0&&nums[i]<=nums.length&&nums[nums[i]-1]!=nums[i]){  //第三个判断条件判断要交换的位置上是否已经就为了，防止重复元素死循环
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
                i--;
            }
        }
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i]!=i+1)
                return i+1;
        }
        return nums.length+1;
    }
}
