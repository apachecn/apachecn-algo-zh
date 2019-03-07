package code;

import java.util.HashMap;

/*
 * 149. Max Points on a Line
 * 题意：给定多个点，问一条线上最多几个点
 * 难度：Hard
 * 分类：HashTable, Math
 * 思路：每次选出一个点，与其他点匹配。因为斜率是小数，所以用两个整数（双层HashMap）来表示小数。时间O(n^2)
 * Tips：
 */
public class lc149 {
    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
    public int maxPoints(Point[] points) {
        if(points.length<=2) return points.length;
        int res = 0;
        for (int i = 0; i < points.length-1 ; i++) {
            HashMap<Integer, HashMap<Integer, Integer>> hm = new HashMap<>();
            int overlap = 1;
            int max = 0;
            for (int j = i+1; j < points.length ; j++) {
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                if(x==0&&y==0){ //重复点
                    overlap++;
                    continue;
                }
                int gcd = genGCD(x, y);
                if(gcd!=0){ //注意，当一个值为0时，gcd==0
                    x = x/gcd;
                    y = y/gcd;
                }
                HashMap<Integer, Integer> hm2 = hm.getOrDefault(x, new HashMap<Integer, Integer>());
                hm2.put(y,hm2.getOrDefault(y,0)+1);
                hm.put(x,hm2);
                max = Math.max(max, hm2.get(y));
            }
            res = Math.max(res, max+overlap);   //里边循环完了，才知道有几个overlap，所以在循环外加
        }
        return res;
    }

    public int genGCD(int a, int b){
        if(b==0) return a;  //注意和GCD不一样的是这没有比较大小，交换a,b。因为可能有负数
        return genGCD(b, a%b);
    }
}
