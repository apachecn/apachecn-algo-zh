# 64. Minimum Path Sum 最小路径和

**<font color=red>难度: Medium</font>**

## 刷题内容

> 原题连接

* https://leetcode.com/problems/minimum-path-sum
* https://leetcode-cn.com/problems/minimum-path-sum

> 内容描述

```
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
```

## 解题方案

> 思路 1

* 经典的动态规划问题，和：72. 编辑距离 类似

```python
class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if not grid or len(grid) == 0:
            return 0
        row = len(grid)
        col = len(grid[0]) if row else 0
        dp = [[0 for j in range(col)] for i in range(row)]
        for i in range(row):
            for j in range(col):
                if i > 0 and j > 0:
                    dp[i][j] = min(dp[i-1][j]+grid[i][j], dp[i][j-1]+grid[i][j])
                elif i > 0 and j == 0:
                    dp[i][j] = sum([grid[k][0] for k in range(i+1)])
                elif i == 0 and j > 0:
                    dp[i][j] = sum([grid[0][k] for k in range(j+1)])
                else:
                    dp[i][j] = grid[0][0]
        return dp[-1][-1]
```
