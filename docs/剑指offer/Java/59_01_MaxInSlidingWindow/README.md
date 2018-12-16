## [滑动窗口的最大值](https://www.acwing.com/problem/content/75/)

### 题目描述
给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。

例如，如果输入数组 `[2, 3, 4, 2, 6, 2, 5, 1]` 及滑动窗口的大小 3,那么一共存在 6 个滑动窗口，它们的最大值分别为 `[4, 4, 6, 6, 6, 5]`。

**注意：**

- 数据保证 k 大于 0，且 k 小于等于数组长度。

**样例**
```
输入：[2, 3, 4, 2, 6, 2, 5, 1] , k=3

输出: [4, 4, 6, 6, 6, 5]
```

### 解法
利用双向队列，保证队列头部存放的是最大值的下标，当队列头部下标过期时弹出。

细节：

- 当数组元素小于队列头部下标对应的元素时，在队列尾部中插入数组元素下标。（如果队列尾部有比该元素小的元素，先弹出，再插入。）
- 当数组元素大于或等于队列头部下标构成的元素时，弹出元素直至队列为空，再插入数组元素下标。

```java
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author bingo
 * @since 2018/12/12
 */

class Solution {
    /**
     * 求滑动窗口的最大值
     * 
     * @param nums 数组
     * @param k 滑动窗口的大小
     * @return 最大值构成的数组
     */
    public int[] maxInWindows(int[] nums, int k) {
        if (nums == null || k < 1 || k > nums.length) {
            return null;
        }
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; ++i) {
            if (queue.isEmpty()) {
                queue.addLast(i);
            } else {
                if (nums[queue.getFirst()] < nums[i]) {
                    while (!queue.isEmpty()) {
                        queue.removeFirst();
                    }
                } else {
                    while (nums[queue.getLast()] < nums[i]) {
                        queue.removeLast();
                    }
                }
                queue.addLast(i);
            }
        }

        for (int i = k; i < nums.length; ++i) {
            res[i - k] = nums[queue.getFirst()];
            if (nums[i] < nums[queue.getFirst()]) {
                while (nums[queue.getLast()] < nums[i]) {
                    queue.removeLast();
                }
            } else {
                while (!queue.isEmpty()) {
                    queue.removeFirst();
                }
            }
            queue.addLast(i);
            if (i - queue.getFirst() == k) {
                queue.removeFirst();
            }
        }
        res[nums.length - k] = nums[queue.getFirst()];
        return res;
    }
}
```

### 测试用例
1. 功能测试（输入数组的数字大小无序；输入数组的数字单调递增；输入数组的数字单调递减）；
2. 边界值测试（滑动窗口的大小为 0、1、等于输入数组的长度、大于输入数组的长度）；
3. 特殊输入测试（输入数组为空）。