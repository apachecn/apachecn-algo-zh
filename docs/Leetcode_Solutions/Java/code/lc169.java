package code;
/*
 * 169. Majority Element
 * 题意：数组中有一个元素出现次数 >len/2 ,找出这个数
 * 难度：Easy
 * 分类：Array, Divide and Conquer, Bit Maniputation
 * 思路：很多种方法， Hashmap 是 O(n), O(n)的。 快排是O(log(n)), O(1)的。最巧妙的办法是  O(n), O(1) 的如下。
 * Tips：之所以能够 O(n), O(1) 是因为题目已经给定了数组中一定能找到这个数，该方法充分利用了这一点
 */
public class lc169 {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length ; i++) {
            if(nums[i]!=res)    // 不是这个数就 --， ==0就用当前数替换res
                count--;
            else
                count++;
            if(count==0){
                res = nums[i];
                count++;
            }
        }
        return res;
    }
}
