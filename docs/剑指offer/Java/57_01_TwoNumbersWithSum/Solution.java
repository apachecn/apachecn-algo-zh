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
     * @param nums   数组
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
                return new int[] { target - nums[i], nums[i] };
            }
            set.add(nums[i]);
        }
        return null;
    }
}