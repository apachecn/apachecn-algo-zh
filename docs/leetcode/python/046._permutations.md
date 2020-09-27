### 46. Permutations

题目:
<https://leetcode.com/problems/permutations/>


难度:

Medium 


每次取一个作为prefix, 剩下的继续做permutation，然后连接起来加入res中

```python
class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if len(nums) == 0:
            return []
        if len(nums) == 1:
            return [nums]
        res = []
        for i in range(len(nums)):
            prefix = nums[i]
            rest = nums[:i] + nums[i+1:]
            for j in self.permute(rest):
                res.append([prefix]+j)
        return res
```

还有介绍的基本无memory使用的算法：


```
class Solution:
    def permute(self, num):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if len(num) == 0: yield []
        if len(num) == 1: yield [num]
        res = []
        for i in range(len(num)):
            x  = num[i]
            xs = num[:i] + num[i+1:]             
            for j in self.permute(xs):
                res.append([x] + j)
        yield res

```

但是这个yield只是生产generator，要看结果还是要用for in 来查看res的。
