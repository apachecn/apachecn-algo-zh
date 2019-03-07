package code;

import java.util.ArrayList;
import java.util.List;
/*
 * 412. Fizz Buzz
 * 题意：遇到3就Fizz，5就Buzz，既能被3又能被5就FizzBuzz
 * 难度：Easy
 * 分类：
 * 思路：避免来回除，自下向上
 * Tips：
 */
public class lc412 {
    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<String>(n);
        for(int i=1,fizz=0,buzz=0;i<=n ;i++){
            fizz++;
            buzz++;
            if(fizz==3 && buzz==5){
                ret.add("FizzBuzz");
                fizz=0;
                buzz=0;
            }else if(fizz==3){
                ret.add("Fizz");
                fizz=0;
            }else if(buzz==5){
                ret.add("Buzz");
                buzz=0;
            }else{
                ret.add(String.valueOf(i));
            }
        }
        return ret;
    }
}
