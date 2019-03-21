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



@小白二号

- 在一个有序的数组中寻找某个值

```c++
int bsearch(int* A, int n, int k) {
    int left = -1, right = n;
    while (right - left > 1) {
        int mid = (left + right) / 2;
        if (A[mid] == k) {
            return mid;
        } else if (A[mid] < k) {
            left = mid;
        } else {
            right = mid;
        }
    }
    return -1;
}
```

- 满足judge(x)=true的最大值

```c++
bool judge(int x) {}
int bsearch(int min, int max) {
    int left = min, right = max;
    //这里为什么要right++呢，因为我们求的是上界，二分区间中，left要满足f(x)，并且尽可能大
    //需要要保证left在[min, max]遍历到
    //终止条件是right - left > 1，所以right需要+1确保left能取到min
    right++;
    while (right - left > 1) {
        int mid = (left + right) / 2;
        if (judge(mid)) {
            left = mid;
        } else {
            right = mid;
        }
    }
    return left;
}
```

- 满足judge(x)=true的最小值

```c++
bool judge(int x) {}
int bsearch(int min, int max) {
    int left = min, right = max;
    //这里为什么要left--呢，因为我们求的是下界，二分区间中，right要满足f(x)，并且尽可能小
    //需要要保证right在[min, max]遍历到
    //终止条件是right - left > 1，所以left需要-1确保right能取到max
    left--;
    while (right - left > 1) {
        int mid = (left + right) / 2;
        if (judge(mid)) {
            right = mid;
        } else {
            left = mid;
        }
    }
    return right;
}
```

- 浮点数，求f(x)在[min,max]的零点

```c++
const double EPS = 1e-8;
double cal(double x) {} //假定是单调增
//这里需要保证区间有零点
double bsearch(double min, double max) {
    double left = min, right = max;
    while (right - left > EPS) {
        double mid = (left + right) / 2;
        if (A[mid] == 0) {
            return mid;
        } else if (cal(mid) < 0) {
            left = mid;
        } else {
            right = mid;
        }
    }
    return (left + right) / 2;
}
```