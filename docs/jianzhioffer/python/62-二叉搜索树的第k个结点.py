# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    # 返回对应节点TreeNode
    def KthNode(self, pRoot, k):
        # write code here
        if not pRoot or not k:
            return 
        res = []
        def traverse(node):
            if len(res) >= k or not node:
                return
            traverse(node.left)
            res.append(node)
            traverse(node.right)
        traverse(pRoot)
        if len(res) < k:
            return
        return res[k-1]
        