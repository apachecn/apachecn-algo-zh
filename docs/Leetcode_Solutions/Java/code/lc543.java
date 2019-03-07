package code;
/*
 * 543. Diameter of Binary Tree
 * 题意：树种的最长路径
 * 难度：Easy
 * 分类：Tree
 * 思路：和lc124思路一样，但lc124是Hard，这道竟然是Easy，哈哈哈
 * Tips：
 */
public class lc543 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }
    public int helper(TreeNode root){
        if(root==null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(left+right, max);
        return Math.max(left, right)+1;
    }
}
