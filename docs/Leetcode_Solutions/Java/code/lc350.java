package code;
/*
 * 350. Intersection of Two Arrays II
 * 题意：求两个数组的交集
 * 难度：Easy
 * 分类：Hash Table, Two Pointers, Binary Search, Sort
 * 思路：HashMap, 注意重复的数字，用计数进行处理
 * Tips：如果两个数组足够大，那么如何处理？
 *       如果其中一个可以加载到内存中，则HashMap处理以后，流式读取第二个数组
 *       如果都不能加载，则先外部排序，再用类似归并链表的方式读取数据
 */
import java.util.ArrayList;
import java.util.HashMap;

public class lc350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList();
        HashMap<Integer, Integer> hm = new HashMap();
        for (int i : nums1) hm.put(i, hm.getOrDefault(i, 0) + 1);
        for (int i : nums2) {
            if (hm.getOrDefault(i, 0) > 0) {
                res.add(i);
                hm.put(i, hm.get(i) - 1);
            }
        }
        int[] res_arr = new int[res.size()];    //toArray方法只能转化为 Integer[] 类型，和返回值不一致
        for (int i = 0; i < res_arr.length; i++) {
            res_arr[i] = res.get(i);
        }
        return res_arr;
    }
}