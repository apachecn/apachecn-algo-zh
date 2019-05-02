# 题目

给定一个整数的数组nums，返回相加为target的两个数字的索引值。

假设每次输入都只有一个答案，并且不会使用同一个元素两次。

**举例：**

``` stylus
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

# 思路

最初，我的解题思路是最简单的遍历，如果数组nums的元素a小于target，那么就在数组中寻找另外一个b，使a+b=target。

``` python
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        result = []
        for i, each in enumerate(nums):
            if abs(target-each) >=0 and i not in result:
                try:
                    tmp = nums.index(target - each)
                    if tmp != i:
                        result.append(i)
                        result.append(tmp)
                except:
                    continue
        return result
```

运行通过，但是运行速度特别慢！Beats才20%+。list的index操作时间复杂度为O(1)，list的append操作时间复杂度也为O(1)。list的not in时间复杂度为O(n)，在算上循环，总共时间复杂度为O(n^2)？所以才这么慢吧....

继续想一些更高级的解决办法。

使用哈希表，也就是散列表，在Python就是字典。使用方法很巧妙，直接看代码吧！

``` python
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if len(nums) <= 1:
            return False
        buff_dict = {}
        for i in range(len(nums)):
            if nums[i] in buff_dict:
                return [buff_dict[nums[i]], i]
            else:
                buff_dict[target - nums[i]] = i
```

Beats 90%+。


