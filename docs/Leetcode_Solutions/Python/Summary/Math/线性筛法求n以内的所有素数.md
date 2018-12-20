### 线性筛法求n以内的所有素数(包括n)

对于每一个数i，乘上```小于等于```i的最小素因数的素数，就得到以i为最大因数的合数。

设有一个数t，只要将所有以比t小的数为最大因数的合数筛去，那么比t小的数里剩下的就只有素数了。这就是线性筛法求素数的方法。

```python
class LinearSievePrimes():
    def __init__(self, n):  # 求n以内的所有素数(包括n在内)
        self.n = n
        self.isPrime = [True] * (n+1)  # 先将所有数看做素数，然后开始筛选
        self.primes = [0] * (n+1)  # 所有的素数按从小到大排列
        self.prime_cnt = 0  # 素数的个数, 初始化没有素数

    def calPrimes(self):
        for i in range(2, self.n+1):  # 遍历筛去所有最大因数是i的合数
            if self.isPrime[i]:  # 如果i是素数，把它记录下来
                self.primes[self.prime_cnt] = i
                self.prime_cnt += 1
            j = 0
            # 遍历已知素数表中比i的最小素因数小的素数，并筛去合数
            while j < self.prime_cnt and self.primes[j] * i <= self.n:
                self.isPrime[self.primes[j] * i] = False
                if i % self.primes[j] == 0:  # 此时self.primes[j]就是i的最小素因数
                    break
                j += 1

s= LinearSievePrimes(23)
s.calPrimes()
print(s.primes)




output:
[2, 3, 5, 7, 11, 13, 17, 19, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

```

## Reference
1. [线性筛法求素数的原理与实现](https://blog.csdn.net/bjrxyz/article/details/8125913)
2. [线性筛法求素数](https://www.cnblogs.com/grubbyskyer/p/3852421.html)
