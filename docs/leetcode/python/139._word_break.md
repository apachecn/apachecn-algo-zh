### 139. Word Break

**<font color=yellow>难度: Medium</font>**

## 刷题内容

> 原题连接

* https://leetcode.com/problems/word-break
* https://leetcode-cn.com/problems/word-break


> 内容描述

```
给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：
拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。

示例 1：
输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。

示例 2：
输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。

示例 3：
输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
```


## 解题方案

> 思路 1:

```
ok[0] = True

catsandog => s[0:1] = c
ok[0] + s[0: 1] => False  表示 0 这个位置不可以拼接得到

catsandog => s[0:2] = ca
ok[0] + s[0: 2] => False  表示 0～1 这个位置不可以拼接得到
ok[1] + s[1: 2] => False  表示 1～1 这个位置不可以拼接得到

catsandog => s[0:3] = cat
ok[0] + s[0: 3] => True   表示 0～2 这个位置可以拼接得到
ok[1] + s[1: 3] => False  表示 1～2 这个位置不可以拼接得到
ok[2] + s[2: 3] => False  表示 2～2 这个位置不可以拼接得到

catsandog => s[0:4] = cats
ok[0] + s[0: 4] => True   表示 0～3 这个位置可以拼接得到
ok[1] + s[1: 4] => False  表示 1～3 这个位置不可以拼接得到
ok[2] + s[2: 4] => False  表示 2～3 这个位置不可以拼接得到
ok[3] + s[3: 4] => False  表示 3～3 这个位置不可以拼接得到
```

```python
class Solution(object)::
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        ok = [True]
        for i in range(1, len(s)+1):
            ok += [any(ok[j] and s[j:i] in wordDict for j in range(i))]
        return ok[-1]
```
