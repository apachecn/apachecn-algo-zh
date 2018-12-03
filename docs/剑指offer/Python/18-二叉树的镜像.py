# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    # 返回镜像树的根节点
    def Mirror(self, root):
        # write code here
        if root == None:
            return
        if root.left == None and root.right == None:
            return root
        
        ptemp = root.left
        root.left = root.right
        root.right = ptemp
        
        self.Mirror(root.left)
        self.Mirror(root.right)