package code;

import java.util.*;

/*
 * 207. Course Schedule
 * 题意：课程是否能够完成
 * 难度：Medium
 * 分类：Depth-first Search, Breadth-first Search, Graph, Topology Sort
 * 思路：两种方法，一种BFS拓扑排序(每个节点，先求出入度)，另一种DFS找是否有环
 * Tips：很经典的题，拓扑排序，判断图是否有环的DFS
 */
public class lc207 {
    public static void main(String[] args) {
        int[][] prerequisites = {{1,0},{0,1}};
        //System.out.println(canFinish(2, prerequisites));
        System.out.println(canFinish2(2, prerequisites));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];   //计算入度
        int[][] graph = new int[numCourses][numCourses];    //邻接矩阵
        for (int i = 0; i < prerequisites.length ; i++) {
            int node1 = prerequisites[i][0];
            int node2 = prerequisites[i][1];
            graph[node2][node1] = 1;
            indegree[node1]++;  //存下入度，入度为0时，表示该课程可以修
        }
        Stack<Integer> st = new Stack();
        int count = 0;
        for (int i = 0; i < numCourses ; i++) {
            if(indegree[i]==0) {
                st.add(i);
                count++;
            }
        }
        while(!st.isEmpty()){
            int node = st.pop();
            for (int i = 0; i < numCourses ; i++) {
                if(graph[node][i]==1) {
                    indegree[i]--;
                    if(indegree[i]==0){
                        st.add(i);
                        count++;
                    }
                }
            }
        }
        return count==numCourses;   //可以修的课程==课程数
    }

    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();
        // 转换成连接表
        for (int i = 0; i < prerequisites.length ; i++) {
            int node1 = prerequisites[i][0];
            int node2 = prerequisites[i][1];
            if(graph.containsKey(node1)){
                graph.get(node1).add(node2);
            }else{
                LinkedList l = new LinkedList<>();
                l.add(node2);
                graph.put(node1, l);
            }
        }

        Set<Integer> visited = new HashSet();   //记录没有环的节点
        for (int i = 0; i < numCourses ; i++) {
            Set<Integer> onpath = new HashSet();    //路径上的节点,要声明在里边,换节课后就清空了
            if(hascycle(i,graph,onpath,visited))//有环
                return false;
        }
        return true;
    }
    public static boolean hascycle(int course, HashMap graph, Set<Integer> onpath, Set<Integer> visited){
        if( visited.contains(course))   //如果该节点之前判断过了没有环
            return false;
        if( onpath.contains(course))
            return true;
        onpath.add(course); //没有回溯了，自顶向下的，不用remove
        LinkedList<Integer> nodes = (LinkedList<Integer>)graph.get(course);
        if(nodes==null)
            return false;
        for (int i = 0; i < nodes.size() ; i++) {
            if(!hascycle(nodes.get(i), graph, onpath, visited))
                visited.add(nodes.get(i));
            else
                return true;
        }
        onpath.remove((Integer)course);
        return false;
    }
}
