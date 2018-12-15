## [和为S的连续正数序列](https://www.acwing.com/problem/content/72/)

### 题目描述
输入一个正数 s，打印出所有和为 s 的连续正数序列（至少含有两个数）。

例如输入 15，由于 `1+2+3+4+5=4+5+6=7+8=15`，所以结果打印出 3 个连续序列 1～5、4～6 和 7～8。

**样例**
```
输入：15

输出：[[1,2,3,4,5],[4,5,6],[7,8]]
```

### 解法
用两个指针 `p, q` 指示序列的最小值和最大值。如果序列和大于 s，则从序列中去掉较小的值，即 `++p`；如果序列和小于 s，则序列向右再包含一个数字，即 `++q`。

当 p 超过 s 的一半时，停止。

```java
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
```

### 测试用例
1. 功能测试（存在和为 s 的连续序列，如 9、100 等；不存在和为 s 的连续序列，如 4、0 等）；
2. 边界值测试（连续序列的最小和 3）。