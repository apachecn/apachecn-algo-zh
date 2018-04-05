## 1. delete and earn
```python
class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        dp = [0] * 10001
        for num in nums:
            dp[num] += num
        for i in range(2, 10001):
            dp[i] = max(dp[i]+dp[i-2], dp[i-1])
        return dp[-1]
```

## 2. movie ratings

```python

cache = {}
class Solution(object):
    def movierating(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0] if nums[0] > 0 else 0
        if (1, len(nums)+1) not in cache:
            cache[(1, len(nums)+1)] = self.movierating(nums[1:])
            a = self.movierating(nums[1:])
        else:
            a = self.movierating(nums[1:])
        if (2, len(nums)+2) not in cache:
            cache[(2, len(nums)+2)] = self.movierating(nums[2:])
            b = self.movierating(nums[2:])
        else:
            b = self.movierating(nums[2:])
        return max(nums[0]+a, nums[1]+b)



a = Solution()
res = a.movierating([-1,-2,-3,-4,-5])

print(res)

```

## 3. roman names
```python
class Solution(object):
    def roman2Int(self, s):
        lookup = {
            'M': 1000,
            'D': 500,
            'C': 100,
            'L': 50,
            'X': 10,
            'V': 5,
            'I': 1
        }
        res = 0
        for i in range(len(s)):
            if i > 0 and lookup[s[i]] > lookup[s[i-1]]:
                res = res + lookup[s[i]] - 2 * lookup[s[i-1]]
            else:
                res += lookup[s[i]]
        return res

    def royalNames(self, names):
        """
        :type nums: List[int]
        :rtype: int
        """
        for x in range(1, len(names)):
            for i in range(len(names)-x):
                if names[i].split(' ')[0] > names[i+1].split(' ')[0]:
                    names[i], names[i+1] = names[i+1], names[i]
                elif names[i].split(' ')[0] == names[i+1].split(' ')[0]:
                    if self.roman2Int(names[i].split(' ')[1]) > self.roman2Int(names[i+1].split(' ')[1]):
                        names[i], names[i + 1] = names[i + 1], names[i]
        return names

a = Solution()
res = a.royalNames(['Akk IX', 'Ak VIII', 'Louis IX', 'Louis VIII'])
print(res)
```


## 4. wealthy sam time
```python
class Solution(object):
    def minMoves(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = 0
        minVal = min(nums)
        for num in nums:
        	res += num -minVal
        return res
```

## 5. design












