package code;
/*
 * 101. Symmetric Tree
 * 题意：判断二叉树是否对称
 * 难度：Easy
 * 分类：Tree, DFS, BFS
 * Tips：递归与非递归两种方法
 * 注意：题目规定是二叉树，递归方法 left.left与right.right, left.right与right.left 进行比较
 */
import java.util.Stack;

public class lc101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        //非递归方法
        if(root==null)
            return true;

        Stack<TreeNode> s = new Stack();
        s.push(root.left);
        s.push(root.right);
        while(!s.isEmpty()){
            TreeNode tn1 = s.pop(), tn2 = s.pop();
            if(tn1==null||tn2==null)
                if(tn1 == tn2)  //都为空
                    continue;
                else
                    return false;
            if(tn1.val!=tn2.val)
                return false;
            s.push(tn1.left);
            s.push(tn2.right);
            s.push(tn1.right);
            s.push(tn2.left);
        }
        return true;
    }

    // 递归法
    public boolean isSymmetric2(TreeNode root) {
        return root==null || func(root.left, root.right);
    }

    public static boolean func(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left == right;
        return (left.val==right.val) && func(left.left,right.right) && func(left.right,right.left);
    }
}
