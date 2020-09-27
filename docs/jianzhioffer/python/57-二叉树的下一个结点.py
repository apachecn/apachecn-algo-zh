# -*- coding:utf-8 -*-
# class TreeLinkNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#         self.next = None
class Solution:
    def GetNext(self, pNode):
        # write code here
        if pNode is None:
            return 
        pNext = None
        if pNode.right:
            pNode = pNode.right
            while pNode.left:
                pNode = pNode.left
            pNext = pNode
            
        else:
            if pNode.next and pNode.next.left == pNode:
                pNext = pNode.next
            elif pNode.next and pNode.next.right == pNode:
                pNode = pNode.next
                while pNode.next and pNode.next.right == pNode:
                    pNode = pNode.next
                # 遍历终止时当前节点有父节点, 说明当前节点是父节点的左子节点, 输入节点的下一个结点为当前节点的父节点
                # 反之终止时当前节点没有父节点, 说明当前节点在位于根节点的右子树, 没有下一个结点    
                if pNode.next:
                    pNext = pNode.next
                    
        return pNext