# 611. Valid Triangle Number 有效三角形的个数

**<font color=red>难度: 中等</font>**

## 刷题内容

> 原题连接

* https://leetcode.com/problems/valid-triangle-number
* https://leetcode-cn.com/problems/valid-triangle-number

> 内容描述

```
给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。

示例 1:

输入: [2,2,3,4]
输出: 3
解释:
有效的组合是: 
2,3,4 (使用第一个 2)
2,3,4 (使用第二个 2)
2,2,3
注意:

数组长度不超过1000。
数组里整数的范围为 [0, 1000]。
```

## 解题方案

> 思路 1

明确一点，三角形三边为a, b, c，那么何时满足可以组成一个三角形呢？
要同时满足以下3点：
1. a + b > c
2. a + c > b
3. b + c > a

首先对数组逆向排序，固定第一个数字，我们发现```nums[i] >= nums[j] >= nums[k]```, 
所以我们现在只需要保证```nums[j] + nums[k] > nums[i]```即可，
因为```nums[i] + nums[j] > nums[k]```和```nums[i] + nums[k] > nums[j]```是肯定的

后面开始二分，分两种情况：
- 如果```nums[j] + nums[k] > nums[i]```，那么我们只需要将```j += 1```使得比较式前面变小继续判断，
并且```res += k - j```，因为组合```i, j, [j+1...k]```都可以满足比较式，我们需要全部加起来，后面不会再次判断了
- 如果```nums[j] + nums[k] <= nums[i]```，那么我们只需要将```k -= 1```使得比较式前面变大继续判断是否满足比较式


```python
class Solution(object):
    def triangleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = sorted(nums)[::-1]
        res = 0
        for i in range(len(nums)-2):
            j, k = i + 1, len(nums) - 1
            while j < k:
                if nums[k] + nums[j] > nums[i]:
                    res += k - j
                    j += 1                
                else:
                    k -= 1
        return res
```
这里真的我遇到了两次坑，首先如果我们排序用的是正向排序的话，那么我们需要做的是固定最后一个数，否则会出现（假如固定第一个数）：
- 等式满足，我们将```j -= 1``，那么就有可能漏掉了一种情况，就是原本组合```i, j, [j+1...k-1]```可以满足，但是我们这里没有加上
- 等式满足，我们将```k += 1``，那么就有可能漏掉了一种情况，就是原本组合```i, [j+1...k-1], k```可以满足，但是我们这里没有加上

所以二分法真的没有那么简单，我们需要充分根据实际场景去改变我们的固定位置和前后更新方向

这里也给出正向排序的代码：


```python
class Solution(object):
    def triangleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        res = 0
        for k in range(len(nums)-1, 1, -1):
            i, j = 0, k - 1
            while i < j:
                if nums[i] + nums[j] > nums[k]:
                    res += j - i
                    j -= 1
                         
                else:
                    i += 1
        return res
```



