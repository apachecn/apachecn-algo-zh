package code;
/*
 * 98. Validate Binary Search Tree
 * 题意：判断是否为二叉搜索树
 * 难度：Medium
 * 分类：Tree, Depth-first Search
 * 思路：两种方法，一种递归；另一种中序遍历的思路；
 * Tips：递归时注意设置最大最小两个参数，因为节点间val限制会传递的
 */
import java.util.Stack;

public class lc98 {
    public static void main(String[] args) {
        TreeNode tn1 = new TreeNode(0);
        tn1.left = new TreeNode(-1);
        //System.out.println(isValidBST(tn1));
        System.out.println(isValidBST2(tn1));
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        return dfs(root, -Double.MAX_VALUE, Double.MAX_VALUE);  // 注意Double.MIN_VALUE是接近0的正数
    }
    public static boolean dfs(TreeNode root, double min_bound, double max_bound){   //设置两个参数，一个最大值，一个最小值
        if (root == null) return true;
        if (root.val >= max_bound || root.val <= min_bound) return false;
        return dfs(root.left, min_bound, root.val) && dfs(root.right, root.val, max_bound);
    }

    public static boolean isValidBST2(TreeNode root) {
        if(root == null)
            return true;
        Stack<TreeNode> st = new Stack();
        TreeNode pre = null;
        while( !st.isEmpty() || root!=null ){
            while(root!=null){
                st.add(root);
                root = root.left;
            }
            root = st.pop();
            if( pre!=null && root.val<=pre.val )    //先序遍历，自下而上，孩子节点小于父节点
                return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

}
