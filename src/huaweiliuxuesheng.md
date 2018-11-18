"""ip 地址转换"""
```python
db_num = int(input())
def dec2addr(dec):
    res = []
    for i in range(3, -1, -1):
        if dec // (256 ** i) > 256 ** (4-i):
            return '0.0.0.0'
        res.append(str(dec // (256 ** i) % 256))
    return '.'.join(res)

print(dec2addr(db_num))
```



"""页码问题"""
```python
def pageCount(n):
    res = [0] * 10
    for i in range(10):
        page, base, cnt = n, 0, 0
        while (page // (10 ** (base)) > 0):
            tmp = (page % (10 ** (base + 1))) // (10 ** base)
            left = page // (10 ** (base + 1))
            right = page % (10 ** (base))
            if (i == 0):
                left -= 1
            if (i > tmp):
                cnt += left * (10 ** base)
            elif (i < tmp):
                cnt += (left + 1) * (10 ** base)
            else:
                cnt += (left * (10 ** base) + right + 1)
            base += 1
        res[i] = cnt
    return ' '.join(str(i) for i in res[::-1])


n = int(input())
if 1 <= n <= 10 ** 9:
    print(pageCount(n))
else:
    print(-1)
```


"""约瑟夫问题"""
```python
n, m = map(int, input().split(','))

def joseph(people, cnt):
    queue = list(range(1, people + 1))
    death = (cnt - 1) % len(queue)
    for i in range(people - 1):
        del queue[death]
        death = (death + cnt - 1) % len(queue)
    return queue[0]

print(joseph(n, m))
```
