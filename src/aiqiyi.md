```python
"""第一题"""
id = input()

first, second = sum(int(i) for i in id[:3]), sum(int(i) for i in id[3:])


diff = second-first
if diff == 0:
    print(0)
else:
    nums = [int(i) for i in id]

    res = 0
    if diff > 0:
        tmp = [9-i for i in nums[:3]] + [i for i in nums[3:]]
        while diff > 0:
            res += 1
            diff -= max(tmp)
            tmp[tmp.index(max(tmp))] = 0
        print(res)
    else:
        tmp = [9-i for i in nums[3:]] + [i for i in nums[:3]]
        while diff < 0:
            res += 1
            diff += max(tmp)
            tmp[tmp.index(max(tmp))] = 0
        print(res)



"""第二题"""
tmp = input().split()
N, M, P = int(tmp[0]), int(tmp[1]), int(tmp[2])


tmp = input().split()
foods = [int(i) for i in tmp]
# N, M, P = int(tmp[0]), int(tmp[1]), int(tmp[2])
for i in range(M):
    tmp = input().split()
    if tmp[0] == 'B':
        foods[int(tmp[1])-1] -= 1
    else:
        foods[int(tmp[1])-1] += 1

# print(foods)
back_foods = sorted(foods)[::-1]

# print(foods[P-1])
print(back_foods.index(foods[P-1])+1)
```
