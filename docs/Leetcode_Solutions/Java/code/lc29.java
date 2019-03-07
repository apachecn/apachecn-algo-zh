package code;
/*
 * 29. Divide Two Integers
 * 题意：不用乘法，除法，取模运算实现除法
 * 难度：Medium
 * 分类：Math, Binary Search
 * 思路：被除数减去除数，除数每次左移一位，也就是*2 来实现类似二分的思想
 * Tips：注意下用long类型，以及溢出的情况
 */
public class lc29 {
    public static void main(String[] args) {
        System.out.println(divide(-1010369383,-2147483648));
    }
    public static int divide(int dividend, int divisor) {
        if(divisor==0||dividend==Integer.MIN_VALUE&&divisor==-1) return Integer.MAX_VALUE;  //溢出的话直接返回最小值
        int sign;
        if( (dividend>0&&divisor>0) || (dividend<0&&divisor<0) ) sign = 1;
        else sign = -1;
        long dividend2 = Math.abs((long)dividend);      //注意这要强制转换成long，再取abs
        long divisor2 = Math.abs((long)divisor);
        long div = divisor2;
        long res = 0;   //这里也是long
        int p = 0;
        while( !(div>dividend2 && div==divisor2) ){
            long temp = dividend2 - div;
            if(temp>=0){
                res += Math.pow(2, p);
                p++;
                div = div << 1;
                dividend2 = temp;
            }else{
                div = divisor2;
                p = 0;
            }
        }
        return (int)res*sign;
    }
}
