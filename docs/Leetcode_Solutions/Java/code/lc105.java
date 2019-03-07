package code;
/*
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * 题意：根据先序和中序，构造二叉树
 * 难度：Medium
 * 分类：Array, Tree, Depth-first Search
 * 思路：通过递归的方式，找左节点和右节点
 * Tips：思路记一下，自己想不起来。递归的方法，每次把inorder数组分为两半，设置一个pre_index，每次根据pre_index建立节点，向下递归。
 */
public class lc105 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        buildTree(preorder,inorder);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursion(preorder, inorder, 0, 0, inorder.length-1);
    }
    public static TreeNode recursion(int[] preorder, int[] inorder, int pre_index, int start, int end){   //start,end代表在inorder上搜索的范围
        if(start>end || start >inorder.length)
            return null;
        TreeNode tn = new TreeNode(preorder[pre_index]);
        int in_index = 0;
        for (int i = 0; i <= end; i++) {
            if(preorder[pre_index]==inorder[i])
                in_index = i;
        }
        tn.left = recursion(preorder, inorder, pre_index+1, start, in_index-1);
        tn.right = recursion(preorder, inorder, pre_index+in_index-start+1, in_index+1, end);   //注意右孩子节点index参数
        return tn;
    }

}
