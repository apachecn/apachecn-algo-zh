package code;
/*
 * 287. Find the Duplicate Number
 * 题意：n+1个数属于[1~n]，找出重复的那个数
 * 难度：Medium
 * 分类：Array, Two Pointers, Binary Search
 * 思路：如果nums[i]不在对应位置，则和对应位置交换。如果对应位置上也为该数，说明这个数就是重复的数字。这个方法改变了数组。是错误的。
 *      另一种方法，把问题转换成有环链表，找环的起始节点。O(n) O(1) lc142
 *      二分查找，每次看一边数字的个数, O(nlog(n)) O(1)
 * Tips：剑指offer原题
 */
public class lc287 {
    public int findDuplicate(int[] nums) {  //该方法修改了数组，是错误的，没看清题意
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i]!=i+1){
                int temp = nums[nums[i]-1];
                if(temp==nums[i])
                    return temp;
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
                i--;
            }
        }
        return -1;
    }

    public int findDuplicate2(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;   // fast是0,不是nums[0]
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
