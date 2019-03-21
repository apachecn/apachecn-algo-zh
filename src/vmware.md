```python
"""第一题： 线段数和三角形数"""
n = int(input())

if n == 1:
    print(0, 0)
elif n == 2:
    print(1, 0)
elif n == 3:
    print(3, 1)
else:
    # print(int(6+(n-4)/2*(2+(n-4)*2)), int(6+(n-4)/2*(2+(n-4)*2))-2)
    print((n-3)*3+3, (n-3)*3+1)



"""第二题：最小交换次数"""
n = int(input())
tmp = input().split()
nums = [int(i) for i in tmp]
length = len(nums)
def sort1(nums):
    res = 0
    for i in range(length):
        swapped = False
        for j in range(length-1):
            if nums[j] > nums[j+1]:
                swapped = True
                nums[j], nums[j+1] = nums[j+1], nums[j]
                res += 1
        if not swapped:
            break
    return res
def sort2(nums):
    res = 0
    for i in range(length):
        swapped = False
        for j in range(length-1):
            if nums[j] < nums[j+1]:
                swapped = True
                nums[j], nums[j+1] = nums[j+1], nums[j]
                res += 1
        if not swapped:
            break
    return res

print(min(sort1(nums), sort2(nums)))




"""第三题： 搬家"""
tmp = input().split()
N, W = int(tmp[0]), int(tmp[1])
sums = 0
for i in range(N):
    sums += int(input())
if sums == 0:
    print(0)
else:
    if sums <= W:
        print(1)
    elif sums == N * W:
        print(N)
    else:
        print(sums//W + 1)
```
