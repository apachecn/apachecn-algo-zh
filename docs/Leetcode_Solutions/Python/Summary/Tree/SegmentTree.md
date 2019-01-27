Let us consider the following problem to understand Segment Trees.

We have an array arr[0 . . . n-1]. We should be able to
1. Find the sum of elements from index l to r where 0 <= l <= r <= n-1
2. Change value of a specified element of the array to a new value x. We need to do arr[i] = x where 0 <= i <= n-1.

A simple solution is to run a loop from l to r and calculate sum of elements in given range. To update a value, simply do arr[i] = x. 
The first operation takes O(n) time and second operation takes O(1) time.

Another solution is to create another array and store sum from start to i at the ith index in this array. 
Sum of a given range can now be calculated in O(1) time, but update operation takes O(n) time now. 
This works well if the number of query operations are large and very few updates.

What if the number of query and updates are equal? 
Can we perform both the operations in O(log n) time once given the array? 
We can use a Segment Tree to do both operations in O(Logn) time.

Representation of Segment trees
1. Leaf Nodes are the elements of the input array.
2. Each internal node represents some merging of the leaf nodes. 
The merging may be different for different problems. For this problem, merging is sum of leaves under a node.

详细见[Segment Tree | Set 1 (Sum of given range)](https://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/)

还可以看看[这里的solution3介绍](https://leetcode.com/problems/range-sum-query-mutable/solution/)

下面是我的python实现，可以作为模版

```python
class SegmentTree(object):
    def __init__(self, nums): # O(N)
        """
        :type nums: List[int]
        """
        self.n = len(nums)
        self.tree = [0] * (2 * self.n)

        def buildTree(nums):
            self.tree[self.n:] = nums[:]
            for i in range(self.n - 1, 0, -1):
                self.tree[i] = self.tree[2 * i] + self.tree[2 * i + 1]

        buildTree(nums)

    def update(self, i, val): # O(lgN)
        """
        :type i: int
        :type val: int
        :rtype: void
        """
        i += self.n
        self.tree[i] = val
        while i > 0:
            self.tree[i // 2] = self.tree[i // 2 * 2] + self.tree[i // 2 * 2 + 1]
            i //= 2

    def sumRange(self, i, j): # O(lgN)
        """
        :type i: int
        :type j: int
        :rtype: int
        """
        i, j = i + self.n, j + self.n
        sums = 0
        while i <= j:
            if i % 2 == 1:  # 左边多出一个不能成对的
                sums += self.tree[i]
                i += 1
            if j % 2 == 0:  # 右边多出一个不能成对的
                sums += self.tree[j]
                j -= 1
            i //= 2
            j //= 2
        return sums


nums = [1, 3, 5, 7, 9, 11]
s = SegmentTree(nums)
print("Sum of values in given range = ", s.sumRange(1, 3))
s.update(1, 9)
print("Updated sum of values in given range = ", s.sumRange(1, 3))



Sum of values in given range =  15
Updated sum of values in given range =  21

```
