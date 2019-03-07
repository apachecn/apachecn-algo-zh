package code;
/*
 * 189. Rotate Array
 * 题意：数组向后移几位，超出末尾的补到前边
 * 难度：Easy
 * 分类：Array
 * 思路：一种换状替换，别忘了可能是多个环。
 *      reverse 的方法，先整体反转，再按照k划分成两个数组分别反转
 * Tips：
 */
public class lc189 {
    public void rotate(int[] nums, int k) {
        if(nums.length<2) return;
        int sum = 0;
        for (int start_index = 0; start_index < nums.length ; start_index++) {  //可能多个环，用sum判断是否停止
            if(sum==nums.length) break;
            int curr_index = start_index;
            int next_index = (start_index+k)%nums.length;
            int temp1 = nums[start_index];
            int temp2 =0;
            while(next_index!=start_index){
                sum++;
                temp2 = nums[next_index];
                nums[next_index] = temp1;
                temp1 =temp2;
                curr_index = next_index;
                next_index = (curr_index+k)%nums.length;
            }
            nums[start_index] = temp1;
            sum++;
        }
    }

    public void rotate2(int[] nums, int k) {
        if(nums.length<2) return;
        k = k%nums.length;      //处理k>length的case
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    public void reverse(int[] nums, int begin, int end){
        while(begin<end){
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
        return;
    }
}
