### 279. Perfect Squares

**<font color=yellow>难度: Medium</font>**

## 刷题内容

> 原题连接

* https://leetcode.com/problems/perfect-squares
* https://leetcode-cn.com/problems/perfect-squares

> 内容描述

```
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3 
解释: 12 = 4 + 4 + 4.
示例 2:

输入: n = 13
输出: 2
解释: 13 = 4 + 9.
```

## 解题方案

> 思路 1: 暴力破解

```
求某个数的最少平方加和的个数

1. diff集合(小到大排序) = n - 平方根的平方的集合
2. 每一层都在不断 - 平方根的平方
3. 直到出现 0 代表得到结果

当然，你可以提前: dp.append(count) => return count, 得到最小值

n = 15 的时候
    -9  -4  -1
>>> [6, 11, 14]
>>> [2, 5, 7, 10, 13]
>>> [1, 3, 4, 6, 9, 12]
>>> [0, 2, 3, 5, 8, 11]
>>> [1, 2, 4, 7, 10]
>>> [0, 1, 3, 6, 9]
>>> [0, 2, 5, 8]
>>> [1, 4, 7]
>>> [0, 3, 6]
>>> [2, 5]
>>> [1, 4]
>>> [0, 3]
>>> [2]
>>> [1]
>>> [0]
>>> []
4  ---  [4, 6, 7, 9, 12, 15]
```


```python
class Solution(object):
    def numSquares(self, n: int) -> int:
        result = []
        count = 1
        diff_list = [n]
        while len(diff_list):
            diff_list = sorted(list(set([diff-i**2 for diff in diff_list for i in range(1, diff+1) if diff>=i**2])))
            # print(">>> %s" % diff_list)
            if len(diff_list) < 1:
                break 
            elif 0 in diff_list:
                result.append(count)
            count += 1
        # print(min(result), " --- ", result)
        return min(result) if len(result)>0 else -1
```

> 思路 2: 动态规划

```
1. 初始化 inf 从0开始，所以数组长度 n+1 
2. 考虑到是平方，意味着他的间隔可能是跳跃性的，所以 
        n  =   (n-j*j)  + j*j
        dp[i] = dp[i-1] + 1
3. 那么 min 就是未来找到最小值而存在的，因为需要遍历很多个平方， dp[i] 用户存储最小值
4. 返回 dp[-1] 的结果，也就是最终 n 的值
```

```python
class Solution(object):
    def numSquares(self, n: int) -> int:
        square_nums = [i**2 for i in range(1, int(n**0.5)+1)]
        dp = [float('inf')] * (n+1)
        dp[0] = 0
        for i in range(1, n+1):
            for square in square_nums:
                if i < square:
                    break
                # print("%s --- %s结果需要一次 --- %s结果需要%s次" % (i, square, i-square, dp[i-square]))
                dp[i] = min(dp[i], dp[i-square] + 1)
        return dp[-1]
```


--- 

未测试 

> 思路三：

还是慢，有个数学方法, runtime beats 98.48%
```python
import math
class Solution(object):
    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """
        def isSquare(num):
            tmp = int(math.sqrt(num))
            return tmp * tmp == num
        while n & 3 == 0: # n % 4 == 0 
            n >>= 2
        if n & 7 == 7: # n % 8 == 7
            return 4
        if isSquare(n):
            return 1
        sqrt_n = int(math.sqrt(n))
        for i in range(1, sqrt_n + 1):
            if isSquare(n-i*i):
                return 2
        return 3
```
in order to understand, I suggest u read:

here is the [Lagrange's Four Square theorem](https://en.wikipedia.org/wiki/Lagrange%27s_four-square_theorem
) - Limit the result to <= 4:

And this [article](http://www.alpertron.com.ar/4SQUARES.HTM), in which you can also find the way to present a number as a sum of four squares:


