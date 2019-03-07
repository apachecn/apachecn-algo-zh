package code;

import java.util.Stack;

/*
 * 226. Invert Binary Tree
 * 题意：反转二叉树
 * 难度：Easy
 * 分类：Tree
 * 思路：递归或迭代，两种思路，都很简单
 * Tips：
 */
public class lc226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode invertTree(TreeNode root) {
        //递归
        if(root==null)
            return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        //迭代
        if(root==null)
            return null;
        Stack<TreeNode> st = new Stack();
        st.add(root);
        while(!st.isEmpty()){
            TreeNode tn = st.pop();
            TreeNode temp = tn.left;
            tn.left = tn.right;
            tn.right = temp;
            if(tn.left!=null)
                st.add(tn.left);
            if(tn.right!=null)
                st.add(tn.right);
        }
        return root;
    }
}
