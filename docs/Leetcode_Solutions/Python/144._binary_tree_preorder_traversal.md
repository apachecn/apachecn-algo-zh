#  144. Binary Tree Preorder Traversal
**<font color=red>难度: 中等</font>**

## 刷题内容

> 原题连接

* https://leetcode.com/problems/binary-tree-preorder-traversal/description/

> 内容描述

```
Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
Follow up: Recursive solution is trivial, could you do it iteratively?
```

## 解题方案

> 思路 1

Recursive递归,瞬秒


```python
class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []
        if not root:
            return res
        res.append(root.val)
        if root.left: 
            res.extend(self.preorderTraversal(root.left))
        if root.right:
            res.extend(self.preorderTraversal(root.right))
        return res
```

> 思路 2

或者我们可以先写一下先序遍历的函数，然后一个一个贴上去

```python
class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root == None:
            return []
        res = []
        self.preorder(root,res)
        return res
        
        
    def preorder(self,root,res):
        if root == None:
            return
        res.append(root.val)
        self.preorder(root.left,res)
        self.preorder(root.right,res)
```


Iterative, 迭代


```python
class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []
        if not root:  
            return res  
        stack = []  
        stack.append(root)  
          
        while(len(stack) > 0):  
            node = stack.pop()  
            res.append(node.val)  
            if node.right:  
                stack.append(node.right)  
            if node.left:  
                stack.append(node.left)  
        return res
```
