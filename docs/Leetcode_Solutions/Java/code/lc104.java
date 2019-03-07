package code;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * 104. Maximum Depth of Binary Tree
 * 题意：二叉树最大深度
 * 难度：Easy
 * 分类：Tree, Depth-first Search
 * 思路：深度优先搜索，递归实现。非递归BFS，相当于层序遍历。
 * Tips：
 */
public class lc104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int depth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                TreeNode tn = q.remove();
                if(tn.left!=null) q.add(tn.left);
                if(tn.right!=null) q.add(tn.right);
                size--;
            }
            depth++;
        }
        return depth;
    }
}
