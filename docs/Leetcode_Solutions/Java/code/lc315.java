package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * 315. Count of Smaller Numbers After Self
 * 题意：给一个数组，计算这个数右边比这个数小的数的个数
 * 难度：Hard
 * 分类：Divide and Conquer, Binary indexed Tree, Segment Tree, Binary Search Tree
 * 思路：两种思路，一种用二叉搜索树这类数据结构 https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76580/9ms-short-Java-BST-solution-get-answer-when-building-BST
 *      一种归并排序的思路，归并的时候统计左右交换数目。如果一个数从这个数的右边交换到左边，则+1。因为有重复数字，所以用将ndex进行排序
 *      https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76583/11ms-JAVA-solution-using-merge-sort-with-explanation
 *      再有一种复杂度稍微高点的思路，从后往前插入排序，插入的时候二分搜索
 *      https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76576/My-simple-AC-Java-Binary-Search-code
 * Tips：好难呀，我日！
 */
public class lc315 {
    class TreeNode{
        int val;
        int dup_num;
        int sum;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, int dup_num, int sum){
            this.val = val;
            this.dup_num = dup_num; //相同点的数目
            this.sum = sum; //该节点左下节点个数，也就是比该节点值小的
        }
    }

    TreeNode root;
    public List<Integer> countSmaller(int[] nums) {
        if(nums.length<1) return new ArrayList<>();
        Integer[] res_arr = new Integer[nums.length];   //用res_arr保存结果，否则结束了还要遍历数来找结果
        root = new TreeNode(nums[nums.length-1], 1, 0);
        res_arr[nums.length-1] = 0;
        for (int i = nums.length-2; i >=0 ; i--) {
            insert(root, nums[i], res_arr, i, 0);
        }
        return Arrays.asList(res_arr);  //数组转换为list
    }

    public TreeNode insert(TreeNode tn, int n, Integer[] res_arr, int i, int path){ //path记录了路径上比该点小的节点的个数
        if(tn==null) {
            tn = new TreeNode(n, 1, 0);
            res_arr[i] = path;
            System.out.print(i);
            System.out.println("----"+path);
        }
        else if(tn.val==n){
            tn.dup_num++;
            res_arr[i] = path + tn.sum;
        }else if(tn.val>n){
            tn.sum++;
            tn.left = insert(tn.left, n, res_arr, i, path);
        }else{
            tn.right = insert(tn.right, n, res_arr, i, path + tn.dup_num + tn.sum);
        }
        return tn;  //递归，返回的结果为节点，供上层节点赋值
    }
}
