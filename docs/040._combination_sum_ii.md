### 40. Combination Sum II

题目:

<https://leetcode.com/problems/combination-sum-ii/>


难度:

Medium


Combination Sum 已经AC，做了minor change.
- 现在不需要```set```化```candidates```了
- 但是递归的时候```index```要从```i+1```开始了
- 要判断```combo not in res```才```append```到```res```中去

```python
class Solution(object):
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        def dfs(remain, combo, index):
            if remain == 0 and combo not in res:
                res.append(combo)
                return
            for i in range(index, len(candidates)):
                if candidates[i] > remain:
                    break          
                dfs(remain - candidates[i], combo + [candidates[i]], i+1)
        candidates.sort()
        res = []
        dfs(target, [], 0)
        return res
        
```
