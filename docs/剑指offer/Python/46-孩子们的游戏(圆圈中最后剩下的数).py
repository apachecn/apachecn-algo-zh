# -*- coding:utf-8 -*-
class Solution:
    def LastRemaining_Solution(self, n, m):
        # write code here 
        if n < 1 or m < 1:
            return -1
        con = range(n)
        start = 0
        end = -1
        while con:
            k = (start + m - 1) % n
            end = con.pop(k)
            n -= 1
            start = k
        return end
    
# -*- coding:utf-8 -*-
class Solution:
    def LastRemaining_Solution(self, n, m):
        # write code here 
        if n < 1 or m < 1:
            return -1
        idx = 0
        for i in range(1,n+1):
            idx = (idx + m ) % i
        return idx