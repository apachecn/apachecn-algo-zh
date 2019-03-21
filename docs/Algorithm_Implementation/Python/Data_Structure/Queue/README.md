## Queue Implementation

### Queue using Linked List
```python
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Queue(object):
    def __init__(self):
        self.head = None
        self.tail = None
        self.size = 0

    def __str__(self):
        '''print Queue'''
        res = ''
        cur = self.head
        while cur:
            res += str(cur.val)
            res += ' '
            cur = cur.next
        return res

    def push(self, val):
        node = ListNode(val)
        if not self.head:
            self.head = self.tail = node
        else:
            self.tail.next = node
            self.tail = node
        self.size += 1

    def popleft(self):
        if not self.head:
            return None
        pop_val = self.head.val
        self.head = self.head.next
        if self.head == None:
            self.tail = None
        self.size -= 1
        return pop_val

    def peekleft(self):
        if self.head:
            return self.head.val
        return None

    def get_size(self):
        return self.size

    def is_empty(self):
        return self.size == 0
```
