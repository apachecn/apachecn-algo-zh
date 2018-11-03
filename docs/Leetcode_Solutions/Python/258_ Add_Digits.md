# 258. Add Digits

**<font color=red>难度: Easy</font>**

## 刷题内容

> 原题连接

* https://leetcode.com/problems/add-digits/description/

> 内容描述

```
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:

Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.
Follow up:
Could you do it without any loop/recursion in O(1) runtime?
```

## 解题方案

> 思路 1
******- 时间复杂度: O(1)******- 空间复杂度: O(1)******

用循环这就简单的一p了。。

beats 99.88%

```python
class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        while num / 10 >= 1:
            tmp = 0
            while num / 10 >= 1:
                tmp += num % 10
                num /= 10
            tmp += num % 10
            num = tmp
        return num
```

> 思路 2
******- 时间复杂度: O(1)******- 空间复杂度: O(1)******

另一种实现

```python
class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        while num >= 10:
            num = sum([int(c) for c in str(num)])
        return num
```

## Follow up:
Could you do it without any loop/recursion in O(1) runtime?

> 思路 1
******- 时间复杂度: O(1)******- 空间复杂度: O(1)******

数学证明：

this method depends on the truth:

- N=(a[0] * 1 + a[1] * 10 + ...a[n] * 10 ^n),and a[0]...a[n] are all between [0,9]
- we set M = a[0] + a[1] + ..a[n]

and another truth is that:
```
1 % 9 = 1

10 % 9 = 1

100 % 9 = 1
```

- so N % 9 = a[0] + a[1] + ..a[n]
- means N % 9 = M
- so N % 9 = M (% 9)

as 9 % 9 = 0, 18 % 9 == 0,,,,etc. so we can make (n - 1) % 9 + 1 to help us solve the problem when n is 9.

as N is 9, ( 9 - 1) % 9 + 1 = 9


beats 99.88%

```python
class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        if num == 0: 
            return 0
        return (num - 1) % 9 + 1
```



