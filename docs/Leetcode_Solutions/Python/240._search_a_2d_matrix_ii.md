### 240. Search a 2D Matrix II



题目:
<https://leetcode.com/problems/search-a-2d-matrix-ii/>


难度:
Medium

思路：

每行，每列都是sorted

但是比较好的策略是从右上角开始搜索，比如这样：

```
matrix = [
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

m, n =  0, col - 1
更新策略：
 matrix[m][n] < target: 那么这一行到从左走到此都会小于target，row+1 ，往下走
 matrix[m][n] > target:  那么这一列往下走都会大于target，col - 1,往左走
 否则找到
```

时间复杂度O(max(M,N))，因为每次都会往下或者往左走


用的算法是Saddleback



```python
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix:
            return False
        row = len(matrix)
        col = len(matrix[0]) if row else 0 
        m, n = 0, col - 1
        while m < row and n >= 0:
            if matrix[m][n] < target:
                m += 1
            elif matrix[m][n] > target:
                n -= 1
            else:
                return True
        return False

```
