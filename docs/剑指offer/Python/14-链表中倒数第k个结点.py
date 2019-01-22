# -*- coding:utf-8 -*-
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def FindKthToTail(self, head, k):
        # write code here
        if head == None or k <= 0:
            return None
        
        pAhead = head
        pBhead = None
        
        for i in range(k-1):
            if pAhead.next != None:
                pAhead = pAhead.next
            else:
                return None
            
        pBhead = head
        while pAhead.next != None:
            pAhead = pAhead.next
            pBhead = pBhead.next
        return pBhead