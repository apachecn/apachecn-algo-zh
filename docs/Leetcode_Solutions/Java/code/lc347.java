package code;
/*
 * 347. Top K Frequent Elements
 * 题意：找出数组中出现次数最大的k个元素
 * 难度：Medium
 * 分类：Hash Table, Heap
 * 思路：放入hashmap计数是基本思路，后续可以用桶排序的方法，时间复杂度为O(n)。若用优先队列，则时间复杂度为nlg(k)。
 * Tips：第二部巧妙的用了桶排序，避免了比较排序的复杂度
 */
import java.util.*;

public class lc347 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(topKFrequent(nums,2));
    }
    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap();
        TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {    //放入hashmap计数
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        }
        for( int i : hm.keySet() ){ //key,value反转，放入treemap  TreeMap中默认是按照升序进行排序的
            int freq = hm.get(i);
            if(tm.containsKey(freq))
                tm.get(freq).add(i);
            else {
                tm.put(freq, new ArrayList<>());
                tm.get(freq).add(i);
            }
        }
        while(res.size()<k) {
            List ls = tm.pollLastEntry().getValue();    //pollLastEntry将最后一个弹出，而LastEntry只是查看
            res.addAll(ls);
        }
        return res;
    }

    public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
        for (int key : frequencyMap.keySet()) { //桶排序，开辟一个nums.length+1的数组，因为一个数出现次数取值为[0~nums.length]
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }
}
