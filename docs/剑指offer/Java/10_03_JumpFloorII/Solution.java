/**
 * @author bingo
 * @since 2018/11/23
 */

public class Solution {
    /**
     * 青蛙跳台阶II
     * 
     * @param target 跳上的那一级台阶
     * @return 多少种跳法
     */
    public int JumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }
}