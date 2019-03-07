package code;
/*
 * 118. Pascal's Triangle
 * 题意：上层元素相邻的和，两边补1，得到下层元素
 * 难度：Easy
 * 分类：Array
 * 思路：迭代计算
 * Tips：
 */
import java.util.ArrayList;
import java.util.List;

public class lc118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows==0) return res;
        List<Integer> ls = new ArrayList();
        ls.add(1);  //第一层1个1
        res.add(ls);
        numRows--;
        if(numRows==0) return res;
        while(numRows>0){
            ArrayList<Integer> temp = new ArrayList();
            temp.add(1);
            for (int i = 0; i < ls.size()-1 ; i++) {
                temp.add(ls.get(i)+ls.get(i+1));
            }
            temp.add(1);
            res.add(temp);
            ls = temp;
            numRows--;
        }
        return res;
    }
}
