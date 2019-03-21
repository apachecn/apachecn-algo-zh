# -*- coding:utf-8 -*-
class Solution:
    def GetLeastNumbers_Solution(self, tinput, k):
        # write code here
        if not tinput or k > len(tinput):
            return []
        tinput = self.quick_sort(tinput)
        return tinput[:k]
    
    def quick_sort(self,lst):
        if not lst:
            return []
        pivot = lst[0]
        left = self.quick_sort([x for x in lst[1: ] if x < pivot])
        right = self.quick_sort([x for x in lst[1: ] if x >= pivot])
        
        return left + [pivot] + right