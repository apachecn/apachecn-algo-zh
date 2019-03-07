package code;

import java.util.PriorityQueue;

/*
 * 264. Ugly Number II
 * 题意：因子只包含2，3，5的数称为丑数，求第n个丑数
 * 难度：Medium
 * 分类：Math, Heap, Dynamic Programming
 * 思路：丑数乘以2，3，或5还是丑数
 * Tips：注意可能存在重复的数字，和溢出
 *       lc23, lc378
 */
public class lc264 {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pr = new PriorityQueue<>(); //用Long,防止溢出
        pr.add(1L);
        long res = 0;
        while(n>0){
            res = pr.remove();
            while(pr.size()>0 &&pr.peek()==res ) pr.remove();   //注意可能存在重复的数字
            pr.add(res*2);
            pr.add(res*3);
            pr.add(res*5);
            n--;
        }
        return (int)res;
    }
}
