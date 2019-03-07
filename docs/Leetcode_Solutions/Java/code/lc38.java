package code;
/*
 * 38. Count and Say
 * 题意：初始输出为1，后续输出为上次输出的读法，求第n次的读法
 * 难度：Easy
 * 分类：String
 * 注意：题意很难懂，读懂题意了就简单了
 */
public class lc38 {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        String temp = "1";
        while(n>1){
            temp = Say(temp);
            n--;
        }
        return temp;
    }

    public static String Say(String str){
        char[] chars = str.toCharArray();
        StringBuilder res = new StringBuilder();
        int sum =0;
        char pre = chars[0];
        for (int i = 0; i < chars.length ; i++) {
            if(chars[i]==pre)
                sum++;
            else{
                res.append(sum);
                res.append(pre);
                sum = 1;
                pre = chars[i];
            }
            if(i==chars.length-1){  //注意到字符末尾后要添加一次，因为不会再循环了
                res.append(sum);
                res.append(pre);
            }
        }
        return res.toString();
    }
}
