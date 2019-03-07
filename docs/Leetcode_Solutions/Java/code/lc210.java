package code;

import java.util.ArrayDeque;
import java.util.Queue;
/*
 * 210. Course Schedule II
 * 题意：课程是否能够完成
 * 难度：Medium
 * 分类：Depth-first Search, Breadth-first Search, Graph, Topology Sort
 * 思路：两种方法，一种BFS拓扑排序(每个节点，先求出入度)，另一种DFS找是否有环
 * Tips：和lc207一模一样，换了个输出
 *       注意先统计入度并转化为邻接矩阵，之后就好操作了
 */
public class lc210 {
    public static void main(String[] args) {
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        //System.out.println(canFinish(2, prerequisites));
        System.out.println(findOrder(4, prerequisites));
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        int[][] graph = new int[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length ; i++) {
            int course1 = prerequisites[i][0];
            int course2 = prerequisites[i][1];
            graph[course2][course1] = 1;
            degrees[course1]++;
        }
        Queue<Integer> qu = new ArrayDeque();
        int[] res = new int[numCourses];
        int sum = 0;
        for (int i = 0; i < degrees.length ; i++) {
            if(degrees[i]==0) {
                qu.add(i);
                res[sum] = i;
                sum++;
            }
        }
        while(!qu.isEmpty()){
            int curr_course = qu.remove();
            for (int i = 0; i < numCourses ; i++) {
                if(graph[curr_course][i]==1){
                    degrees[i]--;
                    if(degrees[i]==0){
                        qu.add(i);
                        res[sum] = i;
                        sum++;
                    }
                }
            }
        }
        return sum==numCourses ? res : new int[0];
    }
}
