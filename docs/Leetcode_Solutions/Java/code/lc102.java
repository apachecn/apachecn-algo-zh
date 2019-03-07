package code;
/*
 * 102. Binary Tree Level Order Traversal
 * 题意：二叉树层次遍历
 * 难度：Medium
 * 分类：Tree, Breadth-first Search
 * 思路：用一个队列
 * Tips：如何判断遍历完一层了？pop的时候先看下size
 */
import java.util.*;

public class lc102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        qu.add(root);
        while(!qu.isEmpty()){
            int size = qu.size();
            List<Integer> temp = new ArrayList<>();
            while(size>0){
                TreeNode tn = qu.remove();
                if(tn!=null) {
                    if(tn.left!=null)
                        qu.add(tn.left);
                    if(tn.right!=null)
                        qu.add(tn.right);
                }
                temp.add(tn.val);
                size--;
            }
            res.add(temp);
        }
        return res;
    }
}
