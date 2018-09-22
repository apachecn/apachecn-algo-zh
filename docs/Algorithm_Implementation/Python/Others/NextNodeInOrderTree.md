``` python
       8
      /
     5
    / \
   3   6
  / \   \
 1  4    7


class Node {
  Node parent, lc, rc;
  int val;
}
```

1. 首先判断其自有无右孩子，若有，则取其右子树的最左节点; 若无，则开始2


2. 它是其父亲节点的左孩子，则其父亲节点


2. 它是其父亲节点的右孩子，则从其父亲开始往上追溯到第一个向右的节点，如果没有这个节点或者说没有父亲节点，则无下一个节点，若有则取之
                                      

```python
def nextNode(node):
    def leftest(node):
        while node.lc:
            node = node.lc
        return node
    if node.rc:
        return leftest(node.rc)
    if not node.parent:
        return None
    if node == node.parent.lc:
        return node.parent
    elif node == node.parent.rc:
        while node.parent.parent:
            if node.parent != node.parent.parent.lc:
                node = node.parent
            else:
                return node.parent.parent
        return None
```
