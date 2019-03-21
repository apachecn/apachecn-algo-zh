```python
"""第一题"""
N = int(input())


def gcd(big, small):
    if big < small:
        small, big = big, small
    remainder = big % small
    if remainder == 0:
        return small
    else:
         return gcd(small,remainder)

res = 0
from math import sqrt
for c in range(1, N+1):
    for a in range(1, c):
        for b in range(max(c-a+1,a), c):
            if a * a + b * b == c * c:
                if gcd(a, b) == 1 and gcd(b, c) == 1 and gcd(a, c) == 1:
                    res += 1
                    # print(a,b,c)

print(res)


"""第二题"""
tmp = input().split()
positive, negative = int(tmp[0]), int(tmp[1])
# print(positive, negative)

idx = 0
for i in range(6, -1, -1):
    if i*positive+(7-i)*negative < 0:
        idx = i
        break
# print(idx)


res = (negative*(7-idx)+positive*idx) * 2
# print(res)
if idx >= 3:
    res += 3 * positive
else:
    res += idx * positive + (3 - idx) * negative

print(res)
```
