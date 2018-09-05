### Binary Search 


```python
def binarySearch(nums, target):
    l, r = 0, len(nums) -1
    while l <= r:
        mid = l + ((r-l) >> 1)
        if nums[mid] > target:
            r = mid - 1
        elif nums[mid] < target:
            l = mid + 1
	else: 
	    return mid
    return -1
```


wisdompeak大佬说，

标准模板就两套：
```
while (left<right)
{
   mid = (right-left)/2+left;
   if (condition 1)
 left = mid+1
   else if (condition 2)
 right = mid
}


while (left<right)
{
   mid = right - (right-left)/2;
   if (condition 1)
 left = mid
   else if (condition 2)
 right = mid-1
}
酌情选用。
```
