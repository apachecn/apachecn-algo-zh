package code;
/*
 * 108. Convert Sorted Array to Binary Search Tree
 * 题意：将有序数组转换为二叉平衡树
 * 难度：Easy
 * 分类：Tree, Depth-first Search
 * 思路：类似二分查找，每次把数组劈成两半
 * Tips：Bingo!
 */
public class lc108 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode tn = helper(nums, 0, nums.length-1);
        return tn;
    }
    public TreeNode helper(int[] nums, int left, int right){
        if(left<right) return null;
        int mid = (left+right)/2;
        TreeNode tn = new TreeNode(nums[mid]);
        tn.left = helper(nums, left, mid-1);
        tn.right = helper(nums, mid+1, right);
        return tn;
    }
}
