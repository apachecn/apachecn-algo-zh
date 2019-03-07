package code;
/*
 * 7. Reverse Integer
 * 题意：反转一个整数
 * 难度：Easy
 * 分类：Math
 * 注意：如何判断溢出
 */
public class lc7 {
    public static void main(String[] args) {
        System.out.println(reverse(-987));
    }

    public static int reverse(int x) {
        int result =0;
        while(x!=0){
            int temp = result *10 + x%10;
            if(temp/10!=result)
                return 0;
            result = temp;
            x = x/10;
        }
        return result;
    }
}
