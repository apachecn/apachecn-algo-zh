# coding:utf8

from __future__ import print_function
class Node():
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right

def midRecusion(node):
    if node is None:
        return
    midRecusion(node.left)
    print(node.value, end=' ')
    midRecusion(node.right)

def midIterator(node):
    stack = []
    while stack or node:
        if node is not None:
            stack.append(node)
            node = node.left
        else:
            node = stack.pop(-1)
            print(node.value, end=' ')
            node = node.right

if __name__ == "__main__":
    node = Node("D", Node("B", Node("A"), Node("C")), Node("E", right=Node("G", left=Node("F"))))

    print('\n中序遍历<递归>：')
    midRecusion(node)

    print('\n中序遍历<迭代>：')
    midIterator(node)