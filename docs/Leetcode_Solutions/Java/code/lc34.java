package code;
/*
 * 31. Find First and Last Position of Element in Sorted Array
 * 题意：在有序数组中寻找某个数的起始和终止位置
 * 难度：Medium
 * 分类：Array, Binary Search
 * 思路：两次二分查找，第一次找到起始位置，第二次找终止位置
 * Tips：注意/2时是否+1
 */
public class lc34 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] res = searchRange(nums,8);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if(nums.length==0)
            return res;
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            int mid = (start+end)/2;
            if(nums[mid]<target){
                start = mid + 1;
            }else{  //当==时，起始位置在左边
                end = mid;
            }
        }
        if(nums[start]!=target)
            return res;
        res[0] = start;
        end = nums.length-1;    //不需要设置start=0了
        while(start<end){
            int mid = (start+end)/2+1;  //+1使其偏向右边，否则会死循环
            if(nums[mid]>target){
                end = mid-1;
            }else{
                start = mid;
            }
        }
        if(nums[start]!=target)
            return res;
        res[1]=end;
        return res;
    }
}
