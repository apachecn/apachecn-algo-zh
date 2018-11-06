### 1. 最长回文子序列（见516题思路6）

******- 时间复杂度: O(N^2)******- 空间复杂度: O(N^2)******

```python
class Solution:
    def longestPalindromeSubseq(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s or len(s) == 0:
            return 0
        if s == s[::-1]:
            return len(s)
        dp = [[0] * len(s) for i in range(len(s))]
        for i in range(len(s)):
            dp[i][i] = 1
        for i in range(len(s)-1):
            if s[i] == s[i+1]:
                dp[i][i+1] = 2
            else:
                dp[i][i+1] = 1

        for gap in range(2, len(s)):
            for i in range(len(s)-gap):
                j = i + gap
                if s[i] == s[j]:
                    dp[i][j] = dp[i+1][j-1] + 2
                else:
                    dp[i][j] = max(dp[i+1][j], dp[i][j-1])
        return dp[0][-1]

solu = Solution()
s = "bbbab"
print(solu.longestPalindromeSubseq(s))  # 4 {'bbbb'}
```

### 2. 回文子串的个数

******- 时间复杂度: O(N^2)******- 空间复杂度: O(N^2)******

```python
class Solution:
    def numberOfLongestPalindromeSubString(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s or len(s) == 0:
            return 0
        res = 0
        dp = [[False] * len(s) for i in range(len(s))]
        for i in range(len(s)):
            dp[i][i] = True
            res += 1
        for i in range(len(s)-1):
            if s[i] == s[i+1]:
                dp[i][i+1] = True
                res += 1

        for gap in range(2, len(s)):
            for i in range(len(s)-gap):
                j = i + gap
                if s[i] == s[j] and dp[i+1][j-1]:
                    dp[i][j] = True
                    res += 1
        return res

solu = Solution()
s = 'aaa'
print(solu.numberOfLongestPalindromeSubString(s))  # 6 {'a', 'a', 'a', 'aa', 'aa', 'aaa'}
```

### References:
1. [A typical way to solve *palindrome* problems](https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99118/A-typical-way-to-solve-*palindrome*-problems)
