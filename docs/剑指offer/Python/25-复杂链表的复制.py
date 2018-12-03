# -*- coding:utf-8 -*-
# class RandomListNode:
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None
class Solution:
    # 返回 RandomListNode
    def Clone(self, pHead):
        # write code here
        if not pHead:
            return None
        pNode = pHead
        
        while pNode:
            pClone = RandomListNode(pNode.label)
            pClone.next = pNode.next
            pNode.next = pClone
            pNode = pClone.next
        
        pNode = pHead
        
        while pNode:
            pClone = pNode.next
            if pNode.random != None:
                pClone.random = pNode.random.next
            pNode = pClone.next
            
        pNode = pHead
        pCloneHead = pCloneNode = pNode.next
        pNode.next = pCloneHead.next
        pNode = pNode.next
        
        while pNode:
            pCloneNode.next = pNode.next
            pCloneNode = pCloneNode.next
            pNode.next = pCloneNode.next
            pNode = pNode.next
            
        return pCloneHead