# 3. Longest Substring Without Repeating Characters

**<font color=red>难度:Medium</font>**

## 刷题内容

> 原题连接

*https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
> 内容描述

```
给一个字符串，求这个字符串中不重复的子字符串
例如给定"abcabcbb"，答案为3
```

## 解题方案

> 思路1


用 map储存 key为字符，value 为这个字符的位置，我们可以维护一个子字符串(无重复字符)，记录它的起始位置，遍历 string s 当无法在map中找到字符或者小于子字符串的起始位置，就是没有在这个字符串中出现，反之则字符重复，不过 map查找为 O(lgn)，因此总的时间复杂度为O(NlgN)
```cpp
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
   map<int,int> m;
    int beg = 0,length = s.length(),ll = 0,ans = 0;
    for(int i = 0;i < length;++i)
    {
        if(m.find(s[i]) == m.end() || m[s[i]] < beg)
            ll++;
        else
        {
            int pos = m[s[i]];
            ans = max(ll,ans);
            ll = ll - (pos - beg);
            beg = pos + 1;
        }
        m[s[i]] = i;
    }
    ans = max(ans,ll);
    return ans;
    }
};
```
> 思路2

这个思路和上面差不多，用到了一个小窍门，因为储存的是字符，char为8位，因此能储存的最大数为256，这样时间复杂度就为O(N)
```cpp
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
         int m[256];
    for(int i = 0;i < 256;++i)
        m[i] = -1;
    int beg = 0,length = s.length(),ll = 0,ans = 0;
    for(int i = 0;i < length;++i)
    {
        if(m[s[i]] < beg)
            ll++;
        else
        {
            int pos = m[s[i]];
            ans = max(ll,ans);
            ll = ll - (pos - beg);
            beg = pos + 1;
        }
        m[s[i]] = i;
    }
    ans = max(ans,ll);
    return ans;
    }
};
```