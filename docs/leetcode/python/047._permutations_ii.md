### 47. Permutations II

题目:
<https://leetcode.com/problems/permutations-ii/>


难度:

Medium 

跟第46题一样，就是最后append的时候不一样，只有没有结果里面没有的才加入


```python
class Solution(object):
    def permuteUnique(self, nums):
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
            for j in self.permuteUnique(rest):
                if [prefix]+j not in res:
                    res.append([prefix]+j)
        return res
```


