package code;

import java.util.HashMap;

/*
 * 560. Subarray Sum Equals K
 * 题意：子数组的和等于k的个数
 * 难度：Medium
 * 分类：Array, Hash Table
 * 思路：求出累加和存在hashmap中，如果当前hashmap中存在sum-k，那么就是一个解
 * Tips：经典思路，记一下。lc437有类似思想。
 */
public class lc560 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hs = new HashMap();
        hs.put(0,1);
        int res = 0;
        for (int sum = 0, i = 0; i < nums.length ; i++) {
            sum += nums[i];
            res += hs.getOrDefault(sum-k,0);    // sum1+sum2 = k ，说明sum2-sum1那一段是一个解
            hs.put(sum, hs.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
