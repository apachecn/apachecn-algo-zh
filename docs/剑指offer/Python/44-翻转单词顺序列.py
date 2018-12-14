# -*- coding:utf-8 -*-
class Solution:
    def ReverseSentence(self, s):
        # write code here
        if not s or len(s) <= 0:
            return ''
        lis = list(s)
        lis = self.Reverse(lis)
        start = 0
        end = 0
        res = ''
        lisTmp = []
        
        while end < len(s):
            if end == len(s) - 1:
                lisTmp.append(self.Reverse(lis[start:]))
                break
            if lis[start] == ' ':
                start += 1
                end += 1
                lisTmp.append(' ')
            elif lis[end] == ' ':
                lisTmp.append(self.Reverse(lis[start:end]))
                start = end
            else:
                end += 1
        for i in lisTmp:
            res += ''.join(i)
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