### 258. Add Digits

题目:
<https://leetcode.com/problems/add-digits/>


难度:

Easy


思路

这就简单的一p了。。


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


