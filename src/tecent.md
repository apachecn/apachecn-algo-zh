```python



# k = int(input())
# a = input()
# b = input()
# set_a = set()
# for i in range(0, len(a)-k+1):
#     set_a.add(a[i:i+k])
# res = 0
# for i in range(0, len(b)-k+1):
#     if b[i:i+k] in set_a:
#         res += 1
# print(res)
"""
2
abab
ababab
"""

"""
7 14
"""

from math import sqrt
nums = [int(i) for i in input().split()]
x, y = nums[0], nums[1]

# n = 1
# while (n+1)*n/2 != sum(nums):
#     n += 1

n = int((sqrt(8*sum(nums)+1)-1)/2)

permu = [i+1 for i in range(n)]

res = []
def exist(permu, x, path):
    if not permu and x != 0:
        return (False, -1)

    if x == 0 or x in permu:
        res.append(path+1)
        return (True, path + 1)
    if exist(permu[1:], x-permu[0], path+1)[0]:
        res.append(exist(permu[1:], x-permu[0], path+1)[1])
        return (True, exist(permu[1:], x-permu[0], path+1)[1])
    if exist(permu[1:], x, path+1)[0]:
        res.append(exist(permu[1:], x, path+1)[1])
        return (True, exist(permu[1:], x, path+1)[1])

exist(permu, x, 0)
print(res)
print(min(res) if res else -1)

"""
2 3 3
"""
# res = 0
# def tri(a, b, c):
#     if a + b > c and a + c > b and b + c > a:
#         return True
#     return False
#
# nums = [int(i) for i in input().split()]
# res = 0
# for i in range(1, nums[0]+1):
#     for j in range(i+1, nums[1]+1):
#         for k in range(j, nums[2]+1):
#             if tri(i, j, k):
#                 res += 3
#
# print(res)
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
# from math import sqrt
# nums = [int(i) for i in input().split()]
# x, y = nums[0], nums[1]
#
# n = 1
# while (n+1)*n/2 != sum(nums):
#     n += 1
#
# n = int((sqrt(8*sum(nums)+1)-1)/2)
#
# permu = [i+1 for i in range(n)]
# res = 0
# while x > 0:
#     x -= permu[-1]
#     permu = permu[:-1]
#     res += 1
# print(res)
```
