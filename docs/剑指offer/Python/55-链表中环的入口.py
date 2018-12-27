# -*- coding:utf-8 -*-
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:
    def EntryNodeOfLoop(self, pHead):
        # write code here
        meetNode = self.MeetNode(pHead)
        if not meetNode:
            return None
        loop = 1
        flag = meetNode
        while flag.next != meetNode:
            loop += 1
            flag = flag.next
            
        fast = pHead
        for i in range(loop):
            fast = fast.next
        slow = pHead
        while fast != slow:
            fast = fast.next
            slow = slow.next
        return fast
    
    def MeetNode(self, head):
        if not head:
            return None
        slow = head.next
        if slow == None:
            return None
        fast = slow.next
        while fast:
            if slow == fast:
                return slow
            slow = slow.next
            fast = fast.next.next
            
                
                