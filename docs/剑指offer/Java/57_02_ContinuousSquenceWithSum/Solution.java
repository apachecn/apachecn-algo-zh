import java.util.*;

/**
 * @author bingo
 * @since 2018/12/12
 */

class Solution {

    /**
     * 找出和为sum的连续正整数序列
     * 
     * @param sum 和
     * @return 结果列表
     */
    public List<List<Integer>> findContinuousSequence(int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (sum < 3) {
            return res;
        }
        int p = 1, q = 2;
        int mid = (1 + sum) >> 1;
        int curSum = p + q;
        while (p < mid) {
            if (curSum == sum) {
                res.add(getList(p, q));
            }
            while (curSum > sum && p < mid) {
                curSum -= p;
                ++p;
                if (curSum == sum) {
                    res.add(getList(p, q));
                }
            }
            ++q;
            curSum += q;
        }
        return res;
    }

    private List<Integer> getList(int from, int to) {
        List<Integer> res = new ArrayList<>();
        for (int i = from; i <= to; ++i) {
            res.add(i);
        }
        return res;
    }
}