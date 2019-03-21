```python

"""第一题"""
n = int(input())
nums = []
for i in range(n):
    nums.append(int(input()))

max_sum, max_end = nums[0], nums[0]
for i in range(1, len(nums)):
    max_end = max(max_end + nums[i], nums[i])
    max_sum = max(max_sum, max_end)
print(max_sum)


"""问答题

Let's say the egg1 and egg2

Firstly, use egg1 from 2nd floor and drop it, if egg1 break, then use egg2 to check 1th floor, if egg2 doesn't break, then the highest floor we need is 1th, otherwise 2nd floor is what we want. If from neither floor two eggs don't break, we can do this from 4th and 3rd, 6th and 5th, 8th and 7th,,,,,,100th and 99th.

From this method, we can easily get this problem reduced by 2 and totally time complexity will be O(lgn) if in programming.

"""

```
