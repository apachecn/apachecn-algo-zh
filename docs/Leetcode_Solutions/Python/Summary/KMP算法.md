参考
1. [KMP Algorithm for Pattern Searching](https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/)
2. [从头到尾彻底理解KMP（2014年8月22日版）](https://blog.csdn.net/v_july_v/article/details/7041827)


### 1. 找到text中第一次匹配上模式串的idx

```python
class FindFirstMatchIndex(object):
    def findFirstMatchIndex(self, text, pattern):
        if not pattern or len(pattern) == 0:
            return 0  # find at idx 0 anyway

        lps = self.findLPS(pattern)  # longest proper prefix which is also suffix
        i, j = 0, 0  # idx for text and pattern

        res = -1
        while i < len(text):
            if pattern[j] == text[i]:
                i += 1
                j += 1
            if j == len(pattern):
                # print("Found pattern at index " + str(i-j))
                res = i - j
                return res
            elif i < len(text) and pattern[j] != text[i]:  # mismatch after j matches
                if j != 0:  # Don't match lps[0..lps[j-1]] characters, they will match anyway
                    j = lps[j - 1]
                else:
                    i += 1
        return res  # return -1 if not find

    def findLPS(self, pattern):
        length, lps = 0, [0]
        for i in range(1, len(pattern)):
            while length > 0 and pattern[length] != pattern[i]:
                length = lps[length - 1]
            if pattern[length] == pattern[i]:
                length += 1
            lps.append(length)
        return lps


s = FindFirstMatchIndex()
print(s.findFirstMatchIndex('hello', 'l'))  # 2
print(s.findFirstMatchIndex('a', ''))  # 0
print(s.findFirstMatchIndex('aaaaa', 'bba'))  # -1
print(s.findFirstMatchIndex('aaa', 'a'))  # 0
```

### 2. 找到text中所有匹配上模式串的idxes

```python
class FindAllMatchIndexes(object):
    def findAllMatchIndexes(self, text, pattern):
        """
        :type haystack: str
        :type needle: str
        :rtype: [int]
        """
        if not pattern or len(pattern) == 0:
            return [0]  # assume find at idx 0 only

        lps = self.findLPS(pattern)  # longest proper prefix which is also suffix
        i, j = 0, 0  # idx for text and pattern

        res = []
        while i < len(text):
            if pattern[j] == text[i]:
                i += 1
                j += 1
            if j == len(pattern):
                # print("Found pattern at index " + str(i-j))
                res.append(i - j)
                j = lps[j - 1]
            elif i < len(text) and pattern[j] != text[i]:  # mismatch after j matches
                if j != 0:  # Don't match lps[0..lps[j-1]] characters, they will match anyway
                    j = lps[j - 1]
                else:
                    i += 1
        return res  # return [] if not find

    def findLPS(self, pattern):
        length, lps = 0, [0]
        for i in range(1, len(pattern)):
            while length > 0 and pattern[length] != pattern[i]:
                length = lps[length - 1]
            if pattern[length] == pattern[i]:
                length += 1
            lps.append(length)
        return lps


s = FindAllMatchIndexes()
print(s.findAllMatchIndexes('hello', 'l'))  # [2,3]
print(s.findAllMatchIndexes('a', ''))  # [0]
print(s.findAllMatchIndexes('aaaaa', 'bba'))  # []
print(s.findAllMatchIndexes('aaa', 'a'))  # [0,1,2]
```



### 3. 通过LPS来求一个字符串的最长回文前缀字符串(详见214题思路5)

```python
class LongestParlindromePrefixSubarray(object):
    def lpps(self, s):
        """
        :type s: str
        :rtype: str
        """
        pattern = s + '#' + s[::-1]
        lps = self.findLPS(pattern)
        return s[:lps[-1]]

    def findLPS(self, pattern):
        length, lps = 0, [0]
        for i in range(1, len(pattern)):
            while length > 0 and pattern[length] != pattern[i]:
                length = lps[length - 1]
            if pattern[length] == pattern[i]:
                length += 1
            lps.append(length)
        return lps

s = LongestParlindromePrefixSubarray()
print(s.lpps("aacecaaa"))  # aacecaa
print(s.lpps("abbacccc"))  # abba
print(s.lpps("abccba"))  # abccba
```


### 4. 上面的lps函数可以写成另外一种形式

```python
    def findLPS(self, pattern):
        length, lps = 0, [0] * len(pattern)  # length of the previous longest prefix suffix
        i = 1
        while i < len(pattern):
            if pattern[i] == pattern[length]:
                length += 1
                lps[i] = length
                i += 1
            else:
                # This is tricky. Consider the example.
                # AAACAAAA and i = 7. The idea is similar
                # to search step.
                if length != 0:
                    length = lps[length-1] # Also, note that we do not increment i here
                else:
                    lps[i] = 0
                    i += 1
        return lps
```

### 5. 几道例题

1. [leetcode 28](https://github.com/apachecn/awesome-algorithm/blob/master/docs/Leetcode_Solutions/Python/028._implement_strstr().md)
2. [leetcode 214](https://github.com/apachecn/awesome-algorithm/blob/master/docs/Leetcode_Solutions/Python/214._Shortest_Palindrome.md) 思路5

                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
