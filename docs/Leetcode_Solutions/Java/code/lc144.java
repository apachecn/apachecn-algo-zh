package code;
/*
 * 144. Binary Tree Preorder Traversal
 * 题意：二叉树先序遍历
 * 难度：Medium
 * 分类：Stack, Tree
 * 思路：左节点依次入栈
 * Tips：和lc94中序,lc145后序一起看
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc144 {
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
                res.add(root.val);
                root = root.left;
            }
            root = st.pop();
            root = root.right;
        }
        return res;
    }
}
