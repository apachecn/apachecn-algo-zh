```python
"""搜狐畅游第一题"""
nums = [int(i) for i in input().split()]
print(int(sum(nums) - (len(nums)-1)*(len(nums)-2)/2))


"""唯品会第一题"""
import heapq
[k, n] = [int(i) for i in input().split()]
topk = []
for i in range(n):
    nums = [int(i) for i in input().split()]
    for num in nums:
        heapq.heappush(topk, num)
res = 0
for i in range(k):
    res = heapq.heappop(topk)
print(res)


"""唯品会第二题"""
print(bin(sum([int(i, 2) for i in input().split()]))[2:])
```
