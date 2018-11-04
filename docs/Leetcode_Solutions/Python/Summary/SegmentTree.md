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


下面是我的python实现，可以作为模版

```python
class SegmentTree(object):
    def __init__(self, nums):
        self.nums = nums
        self.range_len = len(nums)
        power = math.ceil(math.log(self.range_len, 2)) if self.range_len else 0
        self.st = [0] * (2 ** (power + 1))
        self.constrcut(nums, 0, self.range_len - 1, 0)

    # A utility function to get the middle index from corner indexes.
    def getMid(self, start, end):
        return start + (end - start) // 2

    # A recursive function that constructs Segment Tree for array[start..end].
    # cur is the index of current node in segment tree self.st
    # Time Complexity for tree construction is O(n).
    # There are total 2n-1 nodes, and value of every node is calculated only once in tree construction.
    def constrcut(self, nums, start, end, cur):  # O(N)
        if start > end:
            return
        if start == end:
            self.st[cur] = nums[start]
            return nums[start]
        mid = self.getMid(start, end)
        self.st[cur] = self.constrcut(nums, start, mid, 2 * cur + 1) + \
                       self.constrcut(nums, mid + 1, end, 2 * cur + 2)
        return self.st[cur]

    def getSumHelper(self, start, end, query_start, query_end, cur):
        if query_start <= start and query_end >= end:
            return self.st[cur]
        if end < query_start or start > query_end:
            return 0
        mid = self.getMid(start, end)
        return self.getSumHelper(start, mid, query_start, query_end, 2 * cur + 1) + \
               self.getSumHelper(mid + 1, end, query_start, query_end, 2 * cur + 2)

    # Time complexity to query is O(Logn).
    # To query a sum, we process at most four nodes at every level and number of levels is O(Logn).
    def getSum(self, query_start, query_end):
        if query_start < 0 or query_end > self.range_len - 1 or query_start > query_end:
            print('Invalid Input')
            return -1
        return self.getSumHelper(0, self.range_len - 1, query_start, query_end, 0)

    # idx --> index of the element to be updated. This index is in input nums.
    def updateValueHelper(self, start, end, idx, diff, cur):
        if idx < start or idx > end:
            return
        self.st[cur] += diff
        if end != start:
            mid = self.getMid(start, end)
            self.updateValueHelper(start, mid, idx, diff, 2 * cur + 1)
            self.updateValueHelper(mid + 1, end, idx, diff, 2 * cur + 2)

    # The time complexity of update is also O(Logn).
    # To update a leaf value, we process one node at every level and number of levels is O(Logn).
    def updateValue(self, idx, new_val):  # O(lgN)
        if idx < 0 or idx > self.range_len - 1:
            print('Invalid Input')
            return
        diff = new_val - self.nums[idx]
        self.nums[idx] = new_val
        self.updateValueHelper(0, self.range_len - 1, idx, diff, 0)


nums = [1, 3, 5, 7, 9, 11]
s = SegmentTree(nums)
print("Sum of values in given range = ", s.getSum(1, 3))
s.updateValue(1, 9)
print("Updated sum of values in given range = ", s.getSum(1, 3))

```
