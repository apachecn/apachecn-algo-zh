package code;
/*
 * 263. Ugly Number
 * 题意：因子只包含2，3，5的数称为丑数
 * 难度：Easy
 * 分类：Math
 * 思路：
 * Tips：
 */
public class lc263 {
    public boolean isUgly(int num) {
        if(num==0) return false;
        if(num==1) return true;
        while(num%2==0) num/=2;
        while(num%3==0) num/=3;
        while(num%5==0) num/=5;
        return num==1;
    }
}
