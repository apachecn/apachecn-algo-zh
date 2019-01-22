#88. merge sorted array

**<font color=red>难度:Easy</font>**

## 刷题内容

> 原题连接

*https://leetcode.com/problems/merge-sorted-array/
* 
> 内容描述

```
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
```

## 解题方案

> 思路
******- 时间复杂度: O(NlgN)******- 空间复杂度: O(N)******


这题其实就是用分治思想实现的归并排序，只是注意下数组的范围


```cpp
class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int i = 0,j = 0;
        while((i < m) && (j < n))
        {
            if(nums1[i] < nums2[j])
                i++;
            else
            {
                nums1.insert(nums1.begin() + i,nums2[j++]);
                i++;
                m++;
            }
        }
        if(j < n)
        {
            nums1.erase(nums1.begin() + m,nums1.end());
            nums1.insert(nums1.end(),nums2.begin() + j,nums2.begin() + n);
        }
        else
            nums1.erase(nums1.begin() + m,nums1.end());
    }
};
```