```python
"""第一题"""


tmp = input().split()
numerator = int(tmp[0])
denominator = int(tmp[1])

def fractionToDecimal(numerator, denominator):
    if numerator == 0:
        return '0'
    res = ''
    if numerator * denominator < 0:
        res += '-'
    numerator, denominator = abs(numerator), abs(denominator)
    res += str(numerator // denominator)
    if numerator % denominator == 0:
        return res
    res += '.'
    r = numerator % denominator
    m = {}
    # print(res)
    while r:
        if r in m:
            res = res[:m[r]] + '(' + res[m[r]:] + ')'
            break
        m[r] = len(res)
        r *= 10
        res += str(r // denominator)
        r %= denominator

    return res


res = fractionToDecimal(numerator, denominator)
# print(res)
if '(' not in res:
    if '.' not in res:
        print(int(res))
    else:
        print(res)
else:
    print(res)







"""第二题"""


tmp = input().split(',')
if not tmp:
    print(0)
else:
    costs = [int(i) for i in tmp]

    if len(costs) == 1:
        print(costs[-1])
    elif len(costs) == 2:
        print(costs[-1])
    else:
        dp = [0] * len(costs)
        dp[0] = costs[0]
        dp[1] = costs[1]


        for i in range(2, len(dp)):
            dp[i] = min(dp[i-1], dp[i-2]) + costs[i]

        print(min(dp[-3], dp[-2]) + costs[-1])





"""第三题"""
def max_sub_array(nums):
    n = len(nums)
    maxSum = [nums[0] for i in range(n)]
    for i in range(1, n):
        maxSum[i] = max(maxSum[i - 1] + nums[i], nums[i])
    return (maxSum.index(max(maxSum)), max(maxSum))
def min_sub_array(nums):
    n = len(nums)
    minSum = [nums[0] for i in range(n)]
    for i in range(1, n):
        minSum[i] = min(minSum[i - 1] + nums[i], nums[i])
    return (minSum.index(min(minSum)), min(minSum))

tmp = input().split()
N, M = int(tmp[0]), int(tmp[1])
tmp = input().split(' ')
levels = [int(i) for i in tmp]
backup_levels = [i for i in levels]
idxes = []
res = 0
k = 0
for i in range(M):
    idx, cur_max = max_sub_array(levels)
    if cur_max >= 0:
        cur_sum = 0
        left_idx = 0
        for j in range(idx, -1, -1):
            cur_sum += levels[j]
            if cur_sum == cur_max:
                left_idx = j
                idxes.append([left_idx, idx])
                break
        levels = levels[:left_idx] + levels[idx+1:]
        # print(cur_max)
        res += cur_max
        # print(res)
    else:

        # tmp = min_sub_array(backup_levels[idxes[i][0]:idxes[i][1] + 1])[1]
        idx, cur_min = min_sub_array(backup_levels[idxes[k][0]:idxes[k][1] + 1])
        if cur_min <= 0:
            cur_sum = 0
            left_idx = 0
            for j in range(idx, -1, -1):
                cur_sum += backup_levels[j]
                if cur_sum == cur_max:
                    left_idx = j
                    # idxes.append([left_idx, idx])
                    break
            # print(left_idx, idx)
        k += 1
        res += -cur_min if cur_min <= 0 else 0

# print(res)
# print(backup_levels)
# print(idxes)


print(res)
# print()
# print(min_sub_array(backup_levels[0:5]))
```
