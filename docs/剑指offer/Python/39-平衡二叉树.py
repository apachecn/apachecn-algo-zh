# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    def __init__(self):
        self.flag = True
    
    def IsBalanced_Solution(self, pRoot):
        # write code here
        self.getDepth(pRoot)
        return self.flag
    
    def getDepth(self, root):
        if not root:
            return 0
        left = self.getDepth(root.left) + 1
        right = self.getDepth(root.right) + 1
        
        if abs(left - right) > 1:
            self.flag = False
            
        return left if left > right else right