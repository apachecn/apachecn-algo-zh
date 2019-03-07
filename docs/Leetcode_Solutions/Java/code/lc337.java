package code;

import java.util.HashMap;

/*
 * 337. House Robber III
 * 题意：该节点被抢了，那么下层节点不能被抢
 * 难度：Medium
 * 分类：Tree, Depth-first Search
 * 思路：递归和dp。真的经典，树的递归与dp。
 * Tips：https://leetcode.com/problems/house-robber-iii/discuss/79330/Step-by-step-tackling-of-the-problem
 *       解答给了三种方法，递归，记忆递归，dp
 *       多理解一下树的dp，核心是返回数组而不是一个数字
 */
public class lc337 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int rob(TreeNode root) {
        return helper(root, new HashMap());
    }

    public int helper(TreeNode root, HashMap<TreeNode, Integer> mem){
        if(root==null)
            return 0;
        if(mem.containsKey(root))   //用mem去记忆一下资情况的结果，防止重复计算
            return mem.get(root);
        int val =0;
        if(root.left!=null){
            val += helper(root.left.left, mem);
            val += helper(root.left.right, mem);
        }
        if(root.right!=null){
            val += helper(root.right.left, mem);
            val += helper(root.right.right, mem);
        }
        int res = Math.max(root.val+val, helper(root.left, mem)+helper(root.right, mem));
        mem.put(root, res);
        return res;
    }

    public int rob2(TreeNode root) {
        return Math.max(helper2(root)[0], helper2(root)[1]);
    }
    public int[] helper2(TreeNode root){
        int[] res = new int[2];
        if(root==null) return res;
        int[] left = helper2(root.left);
        int[] right = helper2(root.right);
        res[0] = root.val + left[1] + right[1];     // res[0] 表示该节点被抢的最大结果，下层节点不能被抢
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);    // res[1] 表示该节点不抢的最大结果。注意不抢该节点，下层节点可能被抢，也可能不被抢，取大的。
        return res;
    }
}
