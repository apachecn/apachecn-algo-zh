### 74. Search a 2D Matrix

题目:
<https://leetcode.com/problems/search-a-2d-matrix/>


难度:
Medium


思路：
想过将```2D matrix```看成一个大```sorted list```，代码如下：
```python
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        row = len(matrix)
        col = len(matrix[0]) if row else 0
        l, r = 0, row * col - 1
        while l <= r:
            mid = l + ((r - l) >> 2)
            if target > matrix[mid/col][mid%col]:
                l = mid + 1
            elif target < matrix[mid/col][mid%col]:
                r = mid - 1
            else:
                return True
        return False
```


但是后面觉得不行,
原因如下：
1. m * n may overflow for large m and n; 
2. it will use multiple expensive operations such as / and %






因此二分Search，``` binary search by row first, then binary search by column.```


```python
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix or not matrix[0]:
            return False
        row = len(matrix)
        col = len(matrix[0]) if row else 0
        l, r = 0, row - 1
        while l <= r:
            mid_row = l + ((r - l) >> 2)
            if matrix[mid_row][0] <= target <= matrix[mid_row][-1]:
                m, n = 0, col - 1
                while m <= n:
                    mid_col = m + ((n - m) >> 2)
                    if matrix[mid_row][mid_col] > target:
                        n = mid_col - 1
                    elif matrix[mid_row][mid_col] < target:
                        m = mid_col + 1
                    else:
                        return True
                return False
            elif target < matrix[mid_row][0]:
                r = mid_row - 1
            else:
                l = mid_row + 1
        return False
            
```
