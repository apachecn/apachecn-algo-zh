package code;
/*
 * 145. Binary Tree Postorder Traversal
 * 题意：二叉树后序遍历
 * 难度：Hard
 * 分类：Stack, Tree
 * 思路：调整的先序遍历，再反转结果
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class lc145 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList();
        if(root==null)
            return res;
        Stack<TreeNode> st = new Stack();
        while(!st.isEmpty()||root!=null){
            while(root!=null) {
                st.add(root);
                res.add(root.val);
                root = root.right;  //先遍历右节点
            }
            root = st.pop();
            root =root.left;        //再左节点
        }
        Collections.reverse(res);   //反转链表
        return res;
    }
}
