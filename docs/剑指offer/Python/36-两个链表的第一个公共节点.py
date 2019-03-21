# -*- coding:utf-8 -*-
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:
    def FindFirstCommonNode(self, pHead1, pHead2):
        # write code here
        if not pHead1 or not pHead2:
            return None
        
        p1,p2 = pHead1,pHead2
        len1 = len2 = 0
        while p1:
            len1 += 1
            p1 = p1.next
            
        while p2:
            len2 += 1
            p2 = p2.next
            
        if len1 > len2:
            while len1 - len2:
                pHead1 = pHead1.next
                len1 -= 1
        else:
            while len2 - len1:
                pHead2 = pHead2.next
                len2 -= 1
                
        while pHead1 and pHead2:
            if pHead1 is pHead2:
                return pHead1
            pHead1 = pHead1.next
            pHead2 = pHead2.next
            
        return None