package code;
/*
 * 15. 3Sum
 * 题意：找出数组中所有和为0的三元组合
 * 难度：Medium
 * 分类：Array, Two Pointers
 * 注意：如何避免 List 重复元素
 */
import java.util.*;

public class lc15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums).toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2 ; i++) {
            if( i>0 && nums[i]==nums[i-1] ) //防止重复添加相同内容List
                continue;
            int left = i+1, right = nums.length-1;
            while(left<right){
                if( nums[i]+nums[left]+nums[right] == 0 ){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));   //Arrays.asList(int a, int b, intc);
                    while(left<right && nums[left]==nums[left+1])   //防止重复添加相同内容List
                        left++;
                    while(left<right && nums[right]==nums[right-1])     //防止重复添加相同内容List
                        right--;
                    left++;
                    right--;
                }else if( nums[i]+nums[left]+nums[right] < 0 )
                    left++;
                else
                    right--;
            }
        }
        return result;
    }

}
