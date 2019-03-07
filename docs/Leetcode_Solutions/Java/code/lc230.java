package code;

import java.util.Stack;

/*
 * 230. Kth Smallest Element in a BST
 * 题意：二叉搜索树种第k小的数
 * 难度：Medium
 * 分类：Binary Search, Tree
 * 思路：每次找到最小的值，k--。中序遍历。
 * Tips：非递归中序遍历还是不熟练。。。
 */
public class lc230 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack();
        while(!st.isEmpty()||root!=null){
            while(root!=null) {
                st.add(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if(k==0) return root.val;
            root = root.right;
        }
        return 0;
    }
}
