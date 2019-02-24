# 11. container with most water

**<font color=red>难度:Medium</font>**

## 刷题内容

> 原题连接

*https://leetcode.com/problems/container-with-most-water/
* 
> 内容描述

```
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
```

## 解题方案

> 思路
******- 时间复杂度: O(N)******- 空间复杂度: O(1)******

这道题刚开始很容易想到用暴力的方法去解，但是时间复杂度为 O(n^2) 测试之后发现是 TLE，那么我们就要对算法进行优化，这里我们用双指针法，定义两个指针，一个指向头，另一个指向尾部，比较两个指针指向的数的大小，若头部的大，则指向头部的指针向后移动一位，反之，则指向尾部的指针向前移动一位。


```cpp
class Solution {
public:
    int maxArea(vector<int>& height) {
        int i = 0,j = height.size() - 1,ans = INT_MIN;
		while(i < j)
		{
			int t = min(height[i],height[j]);
			ans = max(ans,t * (j - i));
			height[i] < height[j] ? i++ : j--;
		}
		return ans;
    }
};
```
