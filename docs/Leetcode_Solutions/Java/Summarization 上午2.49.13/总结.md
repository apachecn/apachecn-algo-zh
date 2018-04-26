# 1
```solution```下自定义函数```func(self, fargs, *args, **kwargs)```, 调用时使用```self.func()```的格式

# 2
```not fargs``` 和 ```fargs == None```不一样，前者```fargs```可能为[], '', 0, etc

# 3
递归问题
Any problem can be solved using dp. Solving using a greedy strategy is harder though, since you need to prove that greedy will work for that problem. There are some tell-tale signs of a problem where greedy may be applicable, but isn’t immediately apparent. Example:

- Choice of an element depends only on its immediate neighbours (wiggle sort).
- Answer is monotonically non-decreasing or non-increasing (sorting). This is also applicable for LIS for example.
- Anything that requires lexicographically largest or smallest of something.
- Anything where processing the input in sorted order will help.
- Anything where processing the input in forward or reverse (as given) will help.
- Anything which requires you to track the minimum or maximum of something (think of sliding window problems).

There’s matroid theory which deal with greedy algorithms, but I don’t really understand it. If someone does, I’ll be super grateful to them to explain it to me in simple language!

In general, try to see if for a problem, the solution doesn’t depend on a lot of history about the solution itself, but the next part of the solution is somewhat independent from the rest of the solution. These are all indicative of the fact that a greedy strategy could be applicable.

# 4
[Counter.elements()](https://docs.python.org/2/library/collections.html)

# 5
测试案例写法

```python
import unittest
class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        m, n = len(s), len(p)
        dp = [ [0 for i in range(n+1)] for j in range(m+1)]

        dp[0][0] = 1

        # init the first line
        for i in range(2,n+1):
            if p[i-1] == '*':
                dp[0][i] = dp[0][i-2]

        for i in range(1,m+1):
            for j in range(1,n+1):
                if p[j-1] == '*':
                    if p[j-2] != s[i-1] and p[j-2] != '.':
                        dp[i][j] = dp[i][j-2]
                    elif p[j-2] == s[i-1] or p[j-2] == '.':
                        dp[i][j] = dp[i-1][j] or dp[i][j-2]

                elif s[i-1] == p[j-1] or p[j-1] == '.':
                    dp[i][j] = dp[i-1][j-1]

        return dp[m][n] == 1


class TestSolution(unittest.TestCase):
    def test_none_0(self):
        s = ""
        p = ""
        self.assertTrue(Solution().isMatch(s, p))

    def test_none_1(self):
        s = ""
        p = "a"
        self.assertFalse(Solution().isMatch(s, p))

    def test_no_symbol_equal(self):
        s = "abcd"
        p = "abcd"
        self.assertTrue(Solution().isMatch(s, p))

    def test_no_symbol_not_equal_0(self):
        s = "abcd"
        p = "efgh"
        self.assertFalse(Solution().isMatch(s, p))

    def test_no_symbol_not_equal_1(self):
        s = "ab"
        p = "abb"
        self.assertFalse(Solution().isMatch(s, p))

    def test_symbol_0(self):
        s = ""
        p = "a*"
        self.assertTrue(Solution().isMatch(s, p))

    def test_symbol_1(self):
        s = "a"
        p = "ab*"
        self.assertTrue(Solution().isMatch(s, p))

    def test_symbol_2(self):
        # E.g.
        #   s a b b
        # p 1 0 0 0
        # a 0 1 0 0
        # b 0 0 1 0
        # * 0 1 1 1
        s = "abb"
        p = "ab*"
        self.assertTrue(Solution().isMatch(s, p))


if __name__ == "__main__":
    unittest.main()
    
    

输出：
........

Ran 8 tests in 0.001s

OK
```
