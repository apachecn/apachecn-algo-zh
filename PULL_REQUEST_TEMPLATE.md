# 1. Two Sum

**<font color=red>难度: Easy</font>**

## 刷题内容

> 原题连接

* https://leetcode.com/problems/two-sum

> 内容描述

```
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

## 解题方案

> 思路 1
******- 时间复杂度: O(N^2)******- 空间复杂度: O(1)******

暴力解法，两轮遍历

beats 27.6%
```python
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]
        return []
```


> 思路 2
******- 时间复杂度: O(N)******- 空间复杂度: O(N)******

上面的思路1太慢了，我们可以牺牲空间换取时间

```
          2        7        11    15
         不存在   存在之中
lookup   {2:0}    [0，1]
```

* 建立字典 lookup 存放第一个数字，并存放该数字的 index
* 判断 lookup 种是否存在： `target - 当前数字`， 则表面 当前值和 lookup中的值加和为 target.
* 如果存在，则返回：  `target - 当前数字` 的 index 和 当前值的 index

```python
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        look_up = {}
        for i, num in enumerate(nums):
            if target-num in look_up:
                return [look_up[target-num], i]
            look_up[num] = i
        return []
```
