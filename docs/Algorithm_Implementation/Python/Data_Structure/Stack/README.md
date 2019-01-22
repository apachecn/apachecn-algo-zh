## Stack Implementation

### Stack using Linked List
```python
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Stack(object):
    def __init__(self):
        self.head = None
        self.size = 0

    def push(self, val):
        new_node = ListNode(val)
        new_node.next = self.head
        self.head = new_node
        self.size += 1

    def pop(self):
        if self.head == None:
            return None
        pop_val = self.head.val
        self.head = self.head.next
        self.size -= 1
        return pop_val

    def peek(self):
        return self.head.val

    def get_size(self):
        return self.size

    def is_empty(self):
        return self.size == 0
```
