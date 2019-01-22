# -*- coding:utf-8 -*-
class Solution:
    def LeftRotateString(self, s, n):
        # write code here
        if len(s) <= 0 or n < 0 or len(s) < n:
            return ''
        lis = list(s)
        self.Reverse(lis)
        length = len(s)
        pivot = length - n
        frontlist = self.Reverse(lis[:pivot])
        behindlist = self.Reverse(lis[pivot:])
        res = ''.join(frontlist) + ''.join(behindlist)
        return res
        
    def Reverse(self,lis):
        if not lis or len(lis) <= 0:
            return ''
        start = 0
        end = len(lis) - 1
        while start < end:
            lis[start], lis[end] = lis[end], lis[start]
            start += 1
            end -= 1
            
        return lis