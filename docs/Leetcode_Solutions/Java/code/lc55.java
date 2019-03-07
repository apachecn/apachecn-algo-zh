package code;
/*
 * 55. Jump Game
 * 题意：数组中存储能走的最大步数，问是否能从数组开始走到数组结尾
 * 难度：Medium
 * 分类：Array, Greedy
 * 思路：因为只要有一条路径走到就可以，不需要计算所有的路径，所以用贪心的方法.
 * Tips：很经典的题目，记忆一下
 */
public class lc55 {
    public static void main(String[] args) {
        int[] arr = {3,2,1,0,4};
        System.out.println(canJump(arr));
    }
    public static boolean canJump(int[] nums) {
        int des = nums.length-1;
        for (int i = nums.length-1 ; i >=0 ; i--) {
            if(i + nums[i] >= des)
                des = i;
        }
        return des == 0;
    }
}
