package code;
/*
 * 4. Median of Two Sorted Arrays
 * 题意：两个有序数组，找出中位数，要求复杂度O(logN)
 * 难度：Hard
 * 分类：Array, Binary Search, Divide and Conquer
 * 注意：两个数组长度可能不一样；边际问题
 *      复杂度是 O(log(min(m,n))  ，在短的数组上二分查找即可
 */
public class lc4 {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        if(size1>size2)
            return findMedianSortedArrays(nums2,nums1);

        int low = 0;
        int high = nums1.length;

        while(low<=high){// <=别忘了=
            int i = (low+high)/2;
            int j = (size1+size2+1)/2-i;    // 注意+1
            if(i>0 && nums1[i-1]>nums2[j]){  //注意判断i是否越界
                //need reduce i
                high = i-1;
            }else if(i<size1 && nums2[j-1]>nums1[i]){ //注意判断i是否越界
                //need increase i
                low = i+1;
            }else{
                //find correct i
                int l,r;
                if(i==0) {
                    //nums1 没有 l
                    l = nums2[j-1];
                }else if(j==0){
                    //nums2 没有l，两个数组可能相等
                    l = nums1[i-1];
                } else{
                    l = Math.max(nums1[i-1],nums2[j-1]);
                }

                if((size1+size2)%2==1)
                    return l;

                if(i==size1){
                    //nums1 没有 r
                    r = nums2[j];
                }else if(j==size2){
                    //nums2 没有 r
                    r = nums1[i];
                }else{
                    r = Math.min(nums1[i],nums2[j]);
                }
                return (l+r)*1.0/2;
            }
        }
        return -1;
    }
}
