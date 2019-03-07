package code;
/*
 * 103. Binary Tree Zigzag Level Order Traversal
 * 题意：蛇形层次遍历
 * 难度：Medium
 * 分类：Stack, Tree, Breadth-first Search
 * 思路：层次遍历，加了个flag每次是在list头添加或尾添加
 * Tips：Bingo!
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class lc103 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new ArrayDeque();
        q.add(root);
        boolean flag = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> ls = new ArrayList<>();
            while(size>0){
                TreeNode temp = q.remove();
                if(flag) ls.add(temp.val);
                else ls.add(0,temp.val);    //在头部添加
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
                size--;
            }
            res.add(ls);
            flag = !flag;
        }
        return res;
    }
}
