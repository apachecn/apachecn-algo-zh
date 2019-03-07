package code;
/*
 * 66. Plus One
 * 题意：数组中各数字连起来表示一个整数，返回该整数+1后的数组
 * 难度：Easy
 * 分类：Array, Math
 * 注意：考虑全为9的情况，要进位，第一位为1，其他为0
 */
public class lc66 {
    public static void main(String[] args) {
        int[] nums = plusOne(new int[]{8,9,9,9});
        for(int i: nums)
            System.out.println(i);
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >=0 ; i--) {
            if(digits[i]<9) {
                digits[i]++;
                return digits;
            }else{
                //进位，下一位+1
                digits[i] = 0;
            }
        }
        // 全为9
        int[] res = new int[digits.length+1];
        res[0] = 1;
        return res;
    }
}
