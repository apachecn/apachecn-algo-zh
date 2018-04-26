###子集合问题

####78. Subsets

子集合是全排列的好朋友,也是combination组合的好朋友，排列·组合·子集，他们三个都是好朋友.


#####从空开始加

同样先来看'ABC'

```
def recsubsets(sofar, rest):
	if rest == '':
		print sofar, 
	else:
		recsubsets(sofar, rest[1:])
		recsubsets(sofar + rest[0], rest[1:])

def listsubsets(s):
	recsubsets('',s)


listsubsets('ABC')
```

##### 市面流行思路

市面上流行的思路：

- [[],[1]] 是 [1] 的子集合
- [[],[1],[2],[1,2]] 是 [1,2] 的子集合，实际上就是1的子集合们加了一个2


所以用python写起来也很简单/精美

```
def subsets(nums):
    """
    :type nums: List[int]
    :rtype: List[List[int]]
    """
    results = [[]]
    for num in nums:
        results.extend([result + [num] for result in results])
    return results
```
我在这里犯过错，所以这一句

`results.extend([result + [num] for result in results])` 实际上等于：


```
tmp = []
for result in results:
    tmp.append(result + [num])
results.extend(tmp)
```

<http://stackoverflow.com/questions/38600315/python-power-set-cant-figure-out-my-error>



#### 90. Subsets II


要去重了,比如如果有 [1,2,2]，那么解答为：


	[
	  [2],
	  [1],
	  [1,2,2],
	  [2,2],
	  [1,2],
	  []
	]


现在来观察规律，与之前有不同之处是我们需要一个位置来mark，因为不再需要往之前出现过的地方再加了，看这个:


```
[[],[1]] 是 [1] 的子集合
[[],[1],[2],[1,2]] 是 [1,2] 的子集合，实际上就是1的子集合们加了一个2
新来的2不能再从头开始加了，它需要从[ .., [2],[1,2] ]加 才是合理的
```

所以看到非常精妙的代码


```
def subsets(nums):
    """
    :type nums: List[int]
    :rtype: List[List[int]]
    """
    nums.sort()
    result = [[]]
    temp_size = 0

    for i in range(len(nums)):
    	start = temp_size if i >= 1 and nums[i] == nums[i-1] else 0
    	temp_size = len(result)
    	#print start,temp_size,result
    	for j in range(start, temp_size):
    		result.append(result[j] + [nums[i]])
    print result

subsets([1,2,2])
```

这里这个start是来记录了之前一次数组的长度，temp_size记住目前数组的长度，然后用这个来达到去重的目的，非常聪明

