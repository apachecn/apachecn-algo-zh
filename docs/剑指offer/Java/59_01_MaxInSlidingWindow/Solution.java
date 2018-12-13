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
     * @param k    滑动窗口的大小
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