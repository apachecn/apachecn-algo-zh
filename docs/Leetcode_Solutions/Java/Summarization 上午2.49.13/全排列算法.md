### 全排列算法


#### 46. Permutations


Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:

	[
	  [1,2,3],
	  [1,3,2],
	  [2,1,3],
	  [2,3,1],
	  [3,1,2],
	  [3,2,1]
	]
	
	
#####从空开始加

先跳离开这道题，来看类似的'ABC',我们要求它的全排列


```
def recPermute(sofar, rest):
	if rest == '':
		print sofar
	else:
		for i in range(len(rest)):
			nxt = sofar + rest[i]
			remaining = rest[:i] + rest[i+1:]
			recPermute(nxt, remaining)

// "wrapper" function
def listPermute(s):
	recPermute('',s)
```

会正确输出`ABC ACB BAC BCA CAB CBA`,题目依靠的是每次我们从余下的字母中选一个，如果画图则会是这样:


```
		A				B				C
	B		C		A		C		A		B
	C		B		C		A		B		A
```

时间复杂度应该是O(n!)

- n choose 1
- n-1 choose 1
- ...



#####另一种市面上常见思路是交换：

思路是这样的,同样看上面的图:

- n个元素的全排列 = （n-1）个元素的全排列 + 另一个元素作为前缀
- 如果只有一个元素，那么这个元素本身就是它的全排列
- 不断将每个元素放作第一个元素，然后将这个元素作为前缀，并将其余元素继续全排列，等到出口，出口出去后还需要还原数组


这个用数组来测试更容易写代码和直观：


```
def recPermute(nums,begin):
    n = len(nums)
    if begin == n:
    	print nums,
    
    for i in range(begin,n):
        nums[begin], nums[i] = nums[i],nums[begin]
        recPermute(nums,begin+1)
        nums[begin],nums[i] = nums[i],nums[begin]

recPermute(['A','B','C'],0)

```

这样的写法更容易理解：


```python
class Solution:
    # @param num, a list of integer
    # @return a list of lists of integers
    def permute(self, num):
        if len(num) == 0: return []
        if len(num) == 1: return [num]
        res = []
        for i in range(len(num)):
            x  = num[i]
            xs = num[:i] + num[i+1:]             
            for j in self.permute(xs):
                res.append([x] + j)
        return res
```

每次用一个没有用过的头元素，然后加上全排列产生的结果.

如果分析复杂度，应该也是O(n!)


#### 47. Permutations II


最简单的想法：

- 排序
- 如果碰到重复的就继续处理下一个

```
class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if len(nums) == 0: return []
        if len(nums) == 1: return [nums]
        res = []
        nums.sort()
        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i-1]: continue
            for j in self.permuteUnique(nums[:i] + nums[i+1:]):
                res.append([nums[i]] + j)
        return res

```




#### 31. Next Permutation

实际上这个题目也就是Generation in lexicographic order,

wikipedia 和 [这里](https://www.nayuki.io/page/next-lexicographical-permutation-algorithm) 有很好，很精妙的算法，也有点two pointer的意思


```
1. Find the highest index i such that s[i] < s[i+1]. If no such index exists, the permutation is the last permutation.
2. Find the highest index j > i such that s[j] > s[i]. Such a j must exist, since i+1 is such an index.
3. Swap s[i] with s[j].
4. Reverse the order of all of the elements after index i till the last element.
```


看例子：

125430


- 从末尾开始，找到decreasing subsequence，5430，因为来调5330无论怎么调，都不可能有比它更小的，数也被自然的分成两部分(1,2) 和 （5，4，3，0)
- 下一步是找这个sequence里面第一个比前面部分，比2大的，3，也很容易理解，因为下一个必定是(1,3)打头
- 交换 3和2 ，变成 (1,3,5,4,2,0),再把后面的部分reverse，得到后面部分可得到的最小的

这个时候，得到下一个sequence 130245



```
class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        m, n = 0, 0
        for i in range(len(nums) - 2, 0 , -1):
        	if nums[i] < nums[i+1]:
        		m = i 
        		break

        for i in range(len(nums) - 1, 0 , -1):
        	if nums[i] > nums[m]:
        		n = i
        		break

        if m < n :
        	nums[m], nums[n] = nums[n], nums[m]
        	nums[m+1:] = nums[len(nums):m:-1]
        else:
        	nums = nums.reverse()
```


所以可以用这个next permutation来解46/47也可以，然后我兴奋了一下，这个算法很快的！然后我又冷静了，因为permutation的个数是O(n!)个啊|||,所以也不可能有啥大的提升吧
