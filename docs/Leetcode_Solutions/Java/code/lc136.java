package code;
/*
 * 136. Single Number
 * 题意：找出数组中单一的数
 * 难度：Easy
 * 分类：Hash Table, Bit Maniputation
 * 思路：两种巧妙方法：1.异或  2. set以后sum*2 - sum
 * Tips：
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class lc136 {
    public static void main(String[] args) {
        int[] nums = {2,2,1};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumber2(nums));
    }
    public static int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
    public static int singleNumber2(int[] nums) {
        Set<Integer> s = new HashSet();
        int sum = 0;
        int sum2 = 0;
        for (int i = 0; i < nums.length ; i++) {
            sum += nums[i];
            s.add(nums[i]);
        }
        for(Integer i : s){
            sum2 += i;
        }
        return 2*sum2 - sum;
    }
}
