# 693. Binary Number with Alternating Bits 交替位二进制数

**<font color=red>难度: 中等</font>**

## 刷题内容

> 原题连接

* https://leetcode.com/problems/binary-number-with-alternating-bits
* https://leetcode-cn.com/problems/binary-number-with-alternating-bits

> 内容描述

```
给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。

示例 1:

输入: 5
输出: True
解释:
5的二进制数是: 101
示例 2:

输入: 7
输出: False
解释:
7的二进制数是: 111
示例 3:

输入: 11
输出: False
解释:
11的二进制数是: 1011
 示例 4:

输入: 10
输出: True
解释:
10的二进制数是: 1010
```

## 解题方案

> 思路 1

太简单了，可以一行秒，但是太难看了，还是多写几行吧

调用bin函数转换成二进制以后再转换成字符串，注意二进制前面2为是‘0b’,要记得去掉

```python
class Solution(object):
    def hasAlternatingBits(self, n):
        """
        :type n: int
        :rtype: bool
        """
        tmp = str(bin(n))[2:]
        res = [tmp[i] != tmp[i-1] for i in range(1, len(tmp))]
        return all(res)
```












