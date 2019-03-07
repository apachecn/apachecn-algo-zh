package code;
/*
 * 31. Next Permutation
 * 题意：找出排列组合的下一个排列
 * 难度：Medium
 * 分类：Array
 * 思路：从后往前找第一个变小的数x，从这个数之后的数中找出第一个比x大的数，交换，再把之后的数逆序即可
 * Tips：很典型的排列组合题，思路方法记忆一下。注意比较时是否有=。
 */
public class lc31 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,3,3};
        nextPermutation(nums);
        for (int i:nums){
            System.out.println(i);
        }
    }

    public static void nextPermutation(int[] nums) {
        int ptr = nums.length-1;

        //从后往前找第一个变小的数x
        while(ptr>0&&nums[ptr-1]>=nums[ptr]){// 注意是 >= {5,1,1} , 等于--
            ptr--;
        }

        if(ptr!=0){
            //从这个数之后的数中找出第一个比x大的数
            int n = nums[ptr];
            int ptr2 = ptr;
            for(int i=ptr+1; i<nums.length; i++){
                if( nums[i]>nums[ptr-1] && nums[i]<=n ) {//注意 <= {2,3,1,3,3}
                    n = nums[i];
                    ptr2 = i;
                }
            }
            nums[ptr2] = nums[ptr-1];
            nums[ptr-1] = n;
        }

        //把之后的数逆序
        ReverseNums(nums,ptr,nums.length-1);
    }
    public static void ReverseNums(int[] nums, int start, int end){
        int l = end+start;
        for (int i = start; i < (start+end+1)/2 ; i++) {
            int temp = nums[i];
            nums[i] = nums[l-i];
            nums[l-i] = temp;
        }
    }
}
