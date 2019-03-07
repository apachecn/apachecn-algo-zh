package code;

import java.util.*;
/*
 * 218. The Skyline Problem
 * 题意：高楼轮廓
 * 难度：Hard
 * 分类：Divide and Conquer, Heap, Binary indexed Tree, Segment Tree
 * 思路：转化为坐标，按x排序。左端点add，右端点remove，用优先队列输出y坐标，如果y更改了就输出。
 * Tips：
 */
public class lc218 {
    public static void main(String[] args) {
        int[][] buildings = {{0,2,3}, {2,5,3}};
        getSkyline(buildings);
    }
    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        int[][] arr = new int[buildings.length*2][2];
        for (int i = 0, j=0; i < buildings.length ; i++) {  //转换成坐标
            arr[j][0] = buildings[i][0];
            arr[j][1] = buildings[i][2];
            j++;
            arr[j][0] = buildings[i][1];
            arr[j][1] = -buildings[i][2];   //结束节点y用负数表示
            j++;
        }
        Arrays.sort(arr, new Comparator<int[]>() {  //定义比较方法
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0])
                    return o1[0] - o2[0];
                else
                    return o2[1] - o1[1];       //注意这一点，防止 {{0,2,3}, {2,5,3}} case。 两个点重合了不会连续输出。
            }
        });
        PriorityQueue<Integer> pr = new PriorityQueue<Integer>();
        pr.add(0);
        int pre = 0;
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i][1]>0){
                pr.add(-arr[i][1]);
            }else{
                pr.remove(arr[i][1]);
            }
            if(pr.peek()!=pre){
                res.add(new int[]{arr[i][0], -pr.peek()});
                pre = pr.peek();
            }
        }
        return res;
    }
}
