package code;
/*
 * 88. Merge Sorted Array
 * 题意：归并数组
 * 难度：Easy
 * 分类：Array, Two Pointers
 * 注意：实际上 nums1.length = m+n , 不会>m+n ,题意没说清楚. 用一个指针指向nums的末端，从后往前走
 */
public class lc88 {
    public static void main(String[] args) {
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {1,2,3};
        int m = 3;
        int n = 3;
        merge(nums1,m,nums2,n);
        for(int i:nums1)
            System.out.println(i);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = m-1;
        int ptr2 = n-1;
        int cur = m+n-1;
        while(ptr1>=0 && ptr2>=0){
            if(nums1[ptr1]>nums2[ptr2]) {
                nums1[cur--] = nums1[ptr1--];
            }
            else {
                nums1[cur--] = nums2[ptr2--];
            }
        }
        while(ptr2>=0)
            nums1[cur--] = nums2[ptr2--];
    }
}
