#  94. Binary Tree Inorder Traversal
**<font color=red>难度: 中等</font>**

## 刷题内容

> 原题连接

* https://leetcode.com/problems/binary-tree-inorder-traversal/description/

> 内容描述

```

Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
```

## 解题方案

> 思路 1


递归，瞬秒


```python
class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []
        if not root:
            return res
        if root.left: 
            res.extend(self.inorderTraversal(root.left))
        res.append(root.val)
        if root.right:
            res.extend(self.inorderTraversal(root.right))
        return res
```
> 思路 2

或者我们可以先写一下中序遍历的函数，然后一个一个贴上去

```python
class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root == None:
            return []
        res = []
        self.inorder(root,res)
        return res
        
        
    def inorder(self,root,res):
        if root == None:
            return
        self.inorder(root.left,res)
        res.append(root.val)
        self.inorder(root.right,res)               
```
> 思路 3

迭代

先一股脑把左边一条线全部push到底（即走到最左边），然后node最终为None了就开始pop stack了，然后因为pop出来的每一个node都是自己这棵树的root，所以看看它有没有右孩子，没有那肯定继续pop，有的话自然而然右孩子是下一个要被访问的节点。


```python
class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []
        if not root:
            return res
        
        stack = []
        node = root
        while node or (len(stack) > 0):
            if node:
                stack.append(node)
                node = node.left
            else:
                node = stack.pop()
                res.append(node.val)
                node = node.right
        return res
```
