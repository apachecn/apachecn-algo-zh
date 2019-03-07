package code;
/*
 * 538. Convert BST to Greater Tree
 * 题意：二叉搜索树，让节点上的值+上所有比它大的值
 * 难度：Easy
 * 分类：Tree
 * 思路：因为是二叉搜索树，右，中，左，这样遍历就可以最大的值递减遍历出结果了。
 *      记住，不好递归返回值的，直接设置一个全局变量即可，简单方便。全局变量，全局变量，全局变量！！！
 * Tips：
 */
public class lc538 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }
    public void helper(TreeNode root){
        if(root==null) return;
        helper(root.right);
        root.val = root.val + sum;
        sum = root.val;
        helper(root.left);
    }
}
