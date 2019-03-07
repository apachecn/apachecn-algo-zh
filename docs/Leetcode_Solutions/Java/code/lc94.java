package code;
/*
 * 94. Binary Tree Inorder Traversal
 * 题意：二叉树中序遍历
 * 难度：Medium
 * 分类：HashTable, Stack, Tree
 * 思路：左节点依次入栈
 * Tips：和lc144前序,lc145后序一起看
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null)
            return res;
        Stack<TreeNode> st = new Stack();
        while( !st.isEmpty() || root!=null ) {      //注意停止条件
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
