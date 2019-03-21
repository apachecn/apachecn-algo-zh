Fibonacci 的DP版本

对于DP的不同理解造成不同的写法	
Memoization will usually add on your time-complexity to your space-complexity (e.g. with tabulation you have more liberty to throw away calculations, like using tabulation with Fib lets you use O(1) space, but memoization with Fib uses O(N) stack space).
详看

[Dynamic programming and memoization: bottom-up vs top-down approaches](https://awjin.me/algos-js/dp/tab-memo.html)

[Tabulation vs Memoizatation](http://www.geeksforgeeks.org/tabulation-vs-memoizatation/)
-  top-down(memorize)

```
def memorize_fib(n): # n为第几个Fibonacci数
    memo = {1:1, 2:1}
    if n in memo:
        return memo[n]
    else:
        memo[n] = memorize_fib(n-1) + memorize_fib(n-2)
        return memo[n]

print(memorize_fib(4)) # 输出3
```



- bottom up(tabulation)

```
def tabulation_fib(n):  # n为第几个Fibonacci数
    fib = [1, 1, 2]
    if n < 4:
        return fib[n-1]
    for k in range(3, n+1):
        fib[2] = fib[0] + fib[1]
        fib[0], fib[1] = fib[1], fib[2]
    return fib[2]

print(tabulation_fib(4)) # 输出3
```


这里memo用dict，用array也一样。当然用bottom up还有一点，可以只存每次最后两个数，可以save space.，这样就只用到constant space.


还直接直接借用工具

```python
import functools


@functools.lru_cache(maxsize=None)
def fib(n):
    if n <= 2:
        return 1
    else:
        return fib(n - 1) + fib(n - 2)


print(fib(10)) # 55
```












