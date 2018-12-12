## [和为S的两个数字](https://www.acwing.com/problem/content/71/)

### 题目描述
输入一个数组和一个数字 s，在数组中查找两个数，使得它们的和正好是 s。

如果有多对数字的和等于s，输出任意一对即可。

你可以认为每组输入中都至少含有一组满足条件的输出。

**样例**
```
输入：[1,2,3,4] , sum=7

输出：[3,4]
```

### 解法
利用 set 记录元素即可。

```java
import java.util.HashSet;
import java.util.Set;

/**
 * @author bingo
 * @since 2018/12/10
 */

class Solution {
    /**
     * 在数组中找出和为target的两个数
     * 
     * @param nums 数组
     * @param target 目标和
     * @return 满足条件的两个数构成的数组
     */
    public int[] findNumbersWithSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            if (set.contains(target - nums[i])) {
                return new int[] {target- nums[i], nums[i]};
            }
            set.add(nums[i]);
        }
        return null;
    }
}
```

### 测试用例
1. 功能测试（数组中存在和为 s 的两个数；数组中不存在和为 s 的两个数）；
2. 特殊输入测试（表示数组的指针为空指针）。