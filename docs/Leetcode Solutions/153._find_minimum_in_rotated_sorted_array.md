###153. Find Minimum in Rotated Sorted Array


题目:
<https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/>


难度:

Medium



思路一：

O(N) 就不说了

思路二：

想的是分治，两段分别找出最小值，然后取最小值,但是依旧没有利用题目特性，并且也是O(N).

> We can do it in O(logn) using Binary Search. If we take a closer look at above examples, we can easily figure out following pattern: The minimum element is the only element whose previous element is greater than it. If there is no such element, then there is no rotation and first element is the minimum element. 


上面提到了一个特性，就是minimum element唯一一个它之前的element比它大的，如果不存在这个element，那么就没有rotation.



思路其实是判断前半部分或者后半部分是否有序，然后来剔除，这里需要注意有比较多的边界case，因为如果就两个，那么会有特殊case 0 ,1 mid = 0,所以可以看一下，它这个处理，最后一个elif 是来比较mid 和 end





```
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        def findRotatedMin(nums, start, end):
            if end < start:
                return nums[0]
            if start == end:
                return nums[start]
            mid = (start + end) / 2
            if mid > start and nums[mid] < nums[mid-1]:
                return nums[mid]
            elif mid < end and nums[mid+1] < nums[mid]:
                return nums[mid+1]
            elif nums[mid] < nums[end]:
                return findRotatedMin(nums,start, mid -1)
            return findRotatedMin(nums, mid+1, end)


        return findRotatedMin(nums,0,len(nums)-1)

```

非递归

```
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l,r = 0, len(nums) - 1
        while l < r:
            mid = (l+r) / 2
            if mid > l and nums[mid] < nums[mid-1]:
                return nums[mid]
            elif mid < r and nums[mid] > nums[mid+1]:
                return nums[mid+1]
            elif nums[mid] < nums[r]:
                r = mid -1
            else:
                l = mid +1
        return nums[0]

```


