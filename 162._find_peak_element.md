### 162. Find Peak Element

题目:
<https://leetcode.com/problems/find-peak-element/>


难度:
Medium


思路：


最直观的是O(N)解法

```python
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        for i in range(1, len(nums)):
            if nums[i] < nums[i-1]:
                return i-1
        return len(nums) - 1 
```

O(lgN) 解法

这是一个经典题目

- a[mid] < a[mid] only look at the left side
- a[mid] < a[mid] only look at the right side
- else peak found


证明就是用反证法，或者看peak，因为这里已经限制了num[i] ≠ num[i+1]，所以peak element 一定存在。然后a[mid] < a[mid-1],那么说明这里一定是下降的，说明之前一定有一个peak存在，否则我们可以用反证法证明.

写到这里，我非常相信就是binary search能写对其实不容易。


AC代码

```python 
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l, r = 0, len(nums) - 1
        while l <= r:
        	if l == r : return l
        	mid = l + ((r - l) >> 2)
        	if nums[mid] < nums[mid+1]:
        		l = mid + 1
        	else:
        		r = mid
```

