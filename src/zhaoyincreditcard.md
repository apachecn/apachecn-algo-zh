```python
"""第一题"""
gi = [int(i) for i in input().split()]
sj = [int(i) for i in input().split()]
res = 0
for i in sj:
    tmp = [j for j in gi if j <= i]
    if tmp:
        res += 1
        gi.remove(max(tmp))
print(res)


"""第二题"""
n = int(input())
if n == 1:
    print(1)
elif n == 2:
    print(2)
else:
    dp = [0] * n
    dp[0] = 1
    dp[1] = 2
    for i in range(2, n):
        dp[i] = dp[i-1] + dp[i-2]
    print(dp[-1])


"""第三题"""
invalid = ['3', '4', '7']
nochange = ['0', '1', '8']
def good(n):
    n = str(n)
    for i in invalid:
        if i in n:
            return False
    res = ''
    for i in n:
        if i in nochange:
            res += i
        if i == '2':
            res += '5'
        elif i == '5':
            res += '2'
        elif i == '6':
            res += '9'
        elif i == '9':
            res += '6'
    return res != n

n = int(input())
res = 0
for i in range(n+1):
    if good(i):
        res += 1
print(res)
```
