# -*- coding:utf-8 -*-
class Solution:
    def FirstNotRepeatingChar(self, s):
        # write code here
        if not s:
            return -1
        
        store = {}
        lis = list(s)
        
        for i in lis:
            if i not in store.keys():
                store[i] = 0
            store[i] += 1
            
        for i in lis:
            if store[i] == 1:
                return s.index(i)
            
        return -1