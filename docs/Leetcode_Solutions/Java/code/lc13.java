package code;
/*
 * 13. Roman to Integer
 * 题意：罗马数字转Int
 * 难度：Easy
 * 分类：Math, String
 * 注意：如何解决6种反例，两种方式: (1)判断该位置上与下一位置上大小，决定加减. (2)如何字符串中包含该情况，减去误差
 */
public class lc13 {
    public static void main(String[] args) {
        String s = "IV";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        int sum =0;
        for (int i = 0; i <s.length(); i++) {
            if(s.charAt(i)=='I')
                sum += 1;
            else if(s.charAt(i)=='V')
                sum += 5;
            else if(s.charAt(i)=='X')
                sum += 10;
            else if(s.charAt(i)=='L')
                sum += 50;
            else if(s.charAt(i)=='C')
                sum += 100;
            else if(s.charAt(i)=='D')
                sum += 500;
            else if(s.charAt(i)=='M')
                sum += 1000;
        }
        if(s.contains("IV"))
            sum -= 2;
        if(s.contains("IX"))
            sum -= 2;
        if(s.contains("XL"))
            sum -= 20;
        if(s.contains("XC"))
            sum -= 20;
        if(s.contains("CD"))
            sum -= 200;
        if(s.contains("CM"))
            sum -= 200;
        return sum;
    }
}
