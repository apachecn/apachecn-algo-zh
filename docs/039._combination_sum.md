### 39. Combination Sum

题目:

<https://leetcode.com/problems/combination-sum/>


难度:

Medium


最初的思路：


```
res = []    
def combSum(candidates, target, valueList):
    if target == 0:
        res.append(valueList)
    for candidate in candidates:
        if candidate > target:
            return
        combSum(candidates, target - candidate, valueList + [candidate] )
                
```


问题在于，有重复：

```
combSum([2,3,6,7],7,[])

res
Out[9]: [[2, 2, 3], [2, 3, 2], [3, 2, 2], [7]]
```

然后看了hint，除[2, 2, 3] 和 [2, 3, 2]这种重复的方式是， 把candidates先sort，然后用index的方式来处理。


所以最终的除重大法如下，根据hint做出：

```python
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        def dfs(remain, combo, index):
            if remain == 0:
                res.append(combo)
                return
            for i in range(index, len(candidates)):
                if candidates[i] > remain:
                    break          
                dfs(remain - candidates[i], combo + [candidates[i]], i)
        candidates = list(set(candidates))
        candidates.sort()
        res = []
        dfs(target, [], 0)
        return res
```
