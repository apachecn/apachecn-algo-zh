package code;

import java.util.HashMap;

/*
 * 166. Fraction to Recurring Decimal
 * 题意：实现除法，循环小数部分用（）括起来
 * 难度：Medium
 * 分类：Hash Table, Math
 * 思路：首先计算整数部分，然后加上小数点，再计算小数部分
 *      用 Hash Table 记录之前的余数，余数相同表示小数点开始循环。
 *      注意符号和溢出的情况
 * Tips：看似简单的题，并不好写
 */
public class lc166 {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if( (numerator>0&&denominator<0) || (numerator<0&&denominator>0)) sb.append("-");   //符号
        long num = Math.abs((long)numerator);     //用long防止溢出
        long den = Math.abs((long)denominator);
        sb.append(num/den);   //整数部分

        HashMap<Long, Integer> hm = new HashMap();    //key存储余数，余数>0 <9， value存储index，用来加(
        long n = num%den;
        if(n!=0) sb.append(".");
        while( n!=0 && !hm.containsKey(n)){
            hm.put(n, sb.length());
            n = n*10;
            sb.append(n/den);
            n = n%den;
        }
        if(hm.containsKey(n)){
            int index = hm.get(n);
            sb.insert(index, "(");
            sb.append(")");
        }
        return sb.toString();
    }
}
