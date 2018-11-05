#### 递归

```python
def longestCommonSubsequence(s1, s2):  # O(2^n)
    if len(s1) == 0 or len(s2) == 0:
        return 0
    elif s1[-1] == s2[-1]:
        return 1 + longestCommonSubsequence(s1[:-1], s2[:-1])
    else:
        return max(longestCommonSubsequence(s1[:-1], s2), longestCommonSubsequence(s1, s2[:-1]))


s1 = "AGGTAB"
s2 = "GXTXAYB"
print("Length of LCS is ", longestCommonSubsequence(s1, s2))
```


#### DP

```python
def longestCommonSubsequence(s1, s2):  # O(mn)
    m, n = len(s1), len(s2)
    dp = [[0] * (n + 1) for i in range(m + 1)]
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if s1[i - 1] == s2[j - 1]:
                dp[i][j] = dp[i - 1][j - 1] + 1
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
    return dp[-1][-1]


s1 = "AGGTAB"
s2 = "GXTXAYB"
print("Length of LCS is ", longestCommonSubsequence(s1, s2))
```


参考[Longest Common Subsequence | DP-4](https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/)
