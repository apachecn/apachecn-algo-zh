package code;

import java.util.HashMap;

/*
 * 454. 4Sum II
 * 题意：从4个数组中各挑一个数，使得和为0
 * 难度：Medium
 * 分类：Hash Table, Binary Search
 * 思路：自己没想起来，看了答案后感觉很无聊
 *      两个集合暴力求出所有和的可能，然后2Sum的思路，利用Hashmap即可
 *      其实是利用了二分的思想，把4个数的和变为两个2个数的和
 * Tips：
 */
public class lc454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> hm = new HashMap();
        int res=0;
        for(int i=0; i<A.length; i++){
            for(int j=0; j<B.length; j++){  //从0开始
                hm.put(A[i]+B[j],hm.getOrDefault(A[i]+B[j],0)+1);
            }
        }
        for(int i=0; i<C.length; i++){
            for(int j=0; j<D.length; j++){
                res+=hm.getOrDefault(-C[i]-D[j],0);
            }
        }
        return res;
    }
}
