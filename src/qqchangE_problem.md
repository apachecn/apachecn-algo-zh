```python
def canPartition(nums):
    def dfs(nums, target, num):
        n = len(nums)
        for i in range(n):
            B = nums[:i] + nums[i + 1:]
            if num + nums[i] == target:
                return True
            elif num + nums[i] < target:
                if dfs(B, target, num + nums[i]):
                    return True
            elif num == 0:  # 有一个数比sum/2还大，直接返回False
                return False
        return False

    total = sum(nums)

    if total % 2 != 0:
        return False

    target = total // 2

    nums.sort(reverse=True)  # 逆序排序，先从大的开始判断，速度会更快

    res = dfs(nums, target, 0)
    return res


print(canPartition([3, 3, 3, 4, 5]))
print(canPartition([1,1,2]))
print(canPartition([1,2,3,4]))
print(canPartition([2,3]))
print(canPartition([2,2,2,2,6]))
print(canPartition([1,2,2,2,2,7]))


output:
True
True
True
False
False
True
```
