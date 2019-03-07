package code;
/*
 * 8. String to Integer (atoi)
 * 题意：字符串转数字，按题目要求转换。(题出的不好，没什么意义)
 * 难度：Medium
 * 分类：Math, String
 * 注意：如何判断溢出
 */
public class lc8 {
    public static void main(String[] args) {
        System.out.println(myAtoi("     -42"));
    }

    public static int myAtoi(String str) {
        char[] s = str.toCharArray();
        int i = 0;
        int num = 0;
        int sign = 1;
        while( i<s.length && s[i]==' ')
            i++;
        if( i<s.length && s[i]=='+' ){
            sign = 1;
            i++;
        }
        else if( i<s.length && s[i]=='-' ){
            sign = -1;
            i++;
        }
        while( i<s.length && s[i]>='0' && s[i]<='9' ){
            //sign 乘了两次，保证num为正，以便*10+下一位
            int temp = sign * (num * 10 + Integer.parseInt(String.valueOf(s[i])));
            if( sign==1 && temp/10*sign != num )
                return Integer.MAX_VALUE;
            else if( sign==-1 && temp/10*sign != num )
                return Integer.MIN_VALUE;
            num = temp * sign;
            i++;
        }
        return sign * num;
    }
}
