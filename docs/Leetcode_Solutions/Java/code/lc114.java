package code;
/*
 * 114. Flatten Binary Tree to Linked List
 * 题意：二叉树转链表
 * 难度：Medium
 * 分类：Tree, Depth-first Search
 * 思路：就是节点间连接换一下，理清思路就行了，类似中序遍历
 * Tips：
 */
public class lc114 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        flatten(root.left);
        flatten(root.right);
        TreeNode origin_r = root.right;
        root.right = root.left;     //右节点替换为左节点
        TreeNode right_leaf = root;
        while(right_leaf.right!=null){      //右节点遍历到最后，把左节点接上
            right_leaf = right_leaf.right;
        }
        right_leaf.right = origin_r;
        root.left = null;       //别忘了把left设成null
    }
}
