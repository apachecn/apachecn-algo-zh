package code;

/*
 * 190. Reverse Bits
 * 题意：转换为二进制，反转，再输出
 * 难度：Easy
 * 分类：Bit Manipulation
 * 思路：做位移操作，自己没想起来，好好看看
 * Tips：注意 >>> 无符号位移 它不会将所处理的值的最高位视为正负符号，所以作位移处理时，会直接在空出的高位填入0
 */
public class lc190 {
    public static void main(String[] args) {
        System.out.println(reverseBits(10));
    }
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32 ; i++) {
            result += n&1;
            n >>>= 1;       //无视符号右移
            if(i<31) result<<=1;
        }
        return result;
    }
}
