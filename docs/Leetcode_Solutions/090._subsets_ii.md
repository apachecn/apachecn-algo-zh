# 90. Subsets II

**<font color=red>难度: Medium</font>**

## 刷题内容

> 原题连接

* https://leetcode.com/problems/subsets-ii/description/

> 内容描述

```
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
```

## 解题方案

> 思路 1


```
[[],[1]] 是 [1] 的子集合
[[],[1],[2],[1,2]] 是 [1,2] 的子集合，实际上就是1的子集合们加了一个2
新来的2不能再从头开始加了，它需要从[ .., [2],[1,2] ]加 才是合理的

****当出现多个重复数字时，应该从 已经拥有了新数字所出现全部次数的list开始加才是合理的****
[[],[1]] 是 [1] 的子集合
[[],[1],[2],[1,2]] 是 [1,2] 的子集合，实际上就是1的子集合们加了一个2
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
] 是 [1,2,2] 的子集和，实际上也就是[1,2]的子集合加了一个2
新来的2不能再从头开始加了，它需要从[ .., [2,2],[1,2,2] ]加 才是合理的
例如：
```

自己的解法，这里最关键的就是先对nums进行了排序，保证了我们插入相同的数字时都是相邻的
```python
class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        res = [[]]
        for i in range(len(nums)):
            if any(nums[i] in tmp for tmp in res):
                res.extend([tmp+[nums[i]] for tmp in res if tmp.count(nums[i]) == i - nums.index(nums[i])])
            else:
                res.extend([tmp+[nums[i]] for tmp in res])
        return res
```

> 思路 2

参考别人的

现在来观察规律，与之前有不同之处是我们需要一个位置来mark，因为不再需要往之前出现过的地方再加了，看这个:
这里这个start是来记录了之前一次数组的长度，temp_size记住目前数组的长度，然后用这个来达到去重的目的，非常聪明

别人的解法，但是一个思路

```python
class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        res = [[]]
        tmp_size = 0
        for i in range(len(nums)):
            start = tmp_size if i >= 1 and nums[i] == nums[i-1] else 0
            tmp_size = len(res)
            for j in range(start, tmp_size):
                res.append([nums[i]]+res[j])
        return res
```

> 思路 3

跟[leetcode第78题](https://github.com/apachecn/LeetCode/blob/master/docs/Leetcode_Solutions/078._Subsets.md)一样，DFS, 只不过需要在dfs函数里加一个剪枝的条件，排除掉同样的子集。


```python
class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        res = []
        def dfs(depth, start, lst):
            if lst not in res: 
                res.append(lst)
            if depth == len(nums):
                return
            for i in range(start, len(nums)):
                dfs(depth+1, i+1, lst+[nums[i]])
        dfs(0, 0, [])
        return res
```



> 思路 4

跟[leetcode第78题](https://github.com/apachecn/LeetCode/blob/master/docs/Leetcode_Solutions/078._Subsets.md)一样，backtrack


```python
class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        res = []
        
        def search(cur_lst, idx):
            if idx == len(nums):
                if cur_lst not in res:
                    res.append(cur_lst)
                return
            search(cur_lst + [nums[idx]], idx + 1)
            search(cur_lst, idx + 1)
        
        search([], 0)
        return res

```

## References
[南郭子綦](https://www.cnblogs.com/zuoyuan/p/3758346.html)
