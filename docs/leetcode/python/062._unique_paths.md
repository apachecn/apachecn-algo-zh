# 62. unique paths 不同路径

**<font color=red>难度: 中等</font>**

## 刷题内容

> 原题连接

* https://leetcode.com/problems/unique-paths
* https://leetcode-cn.com/problems/unique-paths

> 内容描述

```
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？
```

![](https://leetcode-cn.com/img/problemset/robot_maze.png)

```
例如，上图是一个7 x 3 的网格。有多少可能的路径？

说明：m 和 n 的值均不超过 100。

> 示例 1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右

> 示例 2:

输入: m = 7, n = 3
输出: 28
```

## 解题方案

> 思路 1

| | | |
| - | - | - |
| 1 | 1 | 1 |
| 1 | 2 | 3 |
| 1 | 3 | 6 |
| 1 | 4 | 10 |
| 1 | 5 | 15 |
| 1 | 6 | 21 |
| 1 | 7 | 28 |

```python
class Solution:
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        if m < 1 or n < 1:
            return 0
        dp = [0] *n
        dp[0] = 1    
        for i in range(0,m):
            for j in range(1,n):
                dp[j] += dp[j-1]
        return dp[n-1]
```

> 思路 2

这道题我一看到就觉得这不就是排列组合吗，一共走m+n-2步, 其中m-1步是向右边走，所以不就是从m+n-2中选m-1个的问题吗，阶乘问题，so easy! 妈妈
再也不用担心我的学习！！这个方法```beats 99.97%```

```python
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        def factorial(num):
            res = 1
            for i in range(1, num+1):
                res *= i
            return res
        return factorial(m+n-2)/factorial(n-1)/factorial(m-1)
```
另外补充一句，我发现math模块里面自带factorial函数，只要import math之后调用即可，












