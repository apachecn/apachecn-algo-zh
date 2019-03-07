package code;
/*
 * 239. Sliding Window Maximum
 * 题意：滑动窗口最大值
 * 难度：Hard
 * 分类：Heap
 * 思路：用双向队列，保证队列里是递增的。单调队列，好好学习一下。
 * Tips：与lc84做比较，84是递增栈
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class lc239 {
    public static void main(String[] args) {
        int nums[] = {-95,92,-85,59,-59,-14,88,-39,2,92,94,79,78,-58,37,48,63,-91,91,74,-28,39,90,-9,-72,-88,-72,93,38,14,-83,-2,21,4,-75,-65,3,63,100,59,-48,43,35,-49,48,-36,-64,-13,-7,-29,87,34,56,-39,-5,-27,-28,10,-57,100,-43,-98,19,-59,78,-28,-91,67,41,-64,76,5,-58,-89,83,26,-7,-82,-32,-76,86,52,-6,84,20,51,-86,26,46,35,-23,30,-51,54,19,30,27,80,45,22};
        int k = 10;
        int[] res = maxSlidingWindow(nums,k);
        for (int i = 0; i < res.length ; i++) {
            System.out.print(res[i]);
            System.out.print(',');
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0)
            return new int[]{};
        int[] res = new int[nums.length-k+1];
        int cur = 0;
        Deque<Integer> dq = new ArrayDeque();
        for (int i = 0; i < nums.length ; i++) {
            if( !dq.isEmpty() && dq.peekFirst()<=i-k)
                dq.removeFirst();
            while( !dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){// removeLast 不是 First。  自己写的时候这写错了，如果是First的话，有些Case也能过
                dq.removeLast();
            }
            dq.addLast(i);
            if(i>=k-1){
                res[cur] = nums[dq.peekFirst()];
                cur++;
            }
        }
        return res;
    }
}
