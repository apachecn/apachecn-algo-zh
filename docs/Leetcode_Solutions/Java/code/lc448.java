package code;

import java.util.ArrayList;
import java.util.List;

/*
 * 448. Find All Numbers Disappeared in an Array
 * 题意：数组长度为n，数组中数字取值为1~n，有些数字可能出现多次，有些可能不出现，找出未出现的数字
 * 难度：Easy
 * 分类：Array
 * 思路：把对应的数字放到对应的位置，最后遍历一遍，如果位置和数字不对应，则为缺失的值。
 * Tips：
 */
public class lc448 {
    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i]-1!=i && nums[nums[i]-1]!=nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
                i--;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i]!=i+1)
                res.add(i+1);
        }
        return res;
    }
}
