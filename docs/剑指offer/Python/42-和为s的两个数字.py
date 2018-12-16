# -*- coding:utf-8 -*-
class Solution:
    def FindNumbersWithSum(self, array, tsum):
        # write code here
        if not array or not tsum:
            return []
        start = 0
        end = len(array) - 1
        while start < end:
            csum = array[start] + array[end]
            
            if csum < tsum:
                start += 1
            elif csum > tsum:
                end -= 1
            else:
                return [array[start],array[end]]
            
        return []