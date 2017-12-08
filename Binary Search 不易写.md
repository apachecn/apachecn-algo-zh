### Binary Search 不易写



坊间一直有binary search不容易写对的传言，一写还真是|||

值得注意的是这里的u位置上的元素搜索是不包括的

先献上递归版本伪码:

```
function Binary_Search(x, A, l, u)
	if u < l then 
		No found error
	else
		m ← l + [ ( u - l ) / 2 ] 	 //避免溢出
		if A[m] = x then
			return m
		if x < A[m] then
			return Binary-Search(x, A, l, m - 1)
		else
			return Binary-Search(x, A, m + 1, u)
```



迭代版本伪码：



```
function Binary_Search(x, A, l, u)
	while l < u do
		m ← l + [ ( u - l ) / 2 ]
		if A[m] = x then 
			return m
		if x < A[m] then
			u ← m - 1
		else
			l ← m + 1
	return NIL
        
```





或者这样，正确代码

```python
def binarySearch(nums, target):
    l, r = 0, len(nums) -1
    while l <= r:
        mid = l + ((r-l) >> 2)
        if nums[mid] > target:
            r = mid - 1
        elif nums[mid] < target:
            l = mid + 1
	else: 
	    return mid
    return -1
```





这样就不对

```
def binarySearch(nums, target):
    l, r = 0, len(nums)
    while l < r:
        mid = (l+r) / 2
        if nums[mid] == target:
            return mid
        elif nums[mid] > target:
            r = mid - 1
        else:
            l = mid + 1
    return -1

print binarySearch([1,2,3,4,5,6],1)
// → -1
```



之所以binary Search很容易不对，是因为边界状况，所以觉得一上来应当检查边界状况

