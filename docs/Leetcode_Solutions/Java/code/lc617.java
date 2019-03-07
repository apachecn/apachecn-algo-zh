package code;
/*
 * 617. Merge Two Binary Trees
 * 题意：合并两个二叉树
 * 难度：Easy
 * 分类：Tree
 * 思路：递归的方法
 * Tips：对比下自己的代码和别人的代码，为什么别人的更简洁。自己的思路还是有些乱，应该先想清楚递归的子问题，再开始写。
 *       想明白了再写，不要修修补补的。
 */
public class lc617 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null) return t2;
        if(t2==null) return t1;
        if(t1!=null && t2!=null) t1.val = t1.val + t2.val;
        helper(t1, t2);
        return t1;
    }
    public void helper(TreeNode t1, TreeNode t2){
        if(t1.left==null) {
            t1.left = t2.left;
            return;
        }
        if(t1.right==null) {
            t1.right = t2.right;
            return;
        }
        if( t1.left!=null && t2.left!=null ) {
            t1.left.val = t1.left.val + t2.left.val;
            helper(t1.left, t2.left);
        }
        if( t1.right!=null && t2.right!=null ) {
            t1.right.val = t1.right.val + t2.right.val;
            helper(t1.right, t2.right);
        }
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
