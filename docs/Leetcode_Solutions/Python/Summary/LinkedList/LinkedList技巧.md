# LinkedList

结点定义如下：

	class ListNode(object):
	    def __init__(self, x):
	        self.val = x
	        self.next = None


可以使用的技巧包括:


## Dummy head

有的时候因为边界条件，需要判定是否是list的head，因为处理起来会有些不同，而创造一个dummy head则可以极大的解决一些问题。

```
	dummy = ListNode(-1)
        dummy.next = head
```

## 双指针

- 19. Remove Nth Node From End of List

两个指针p,q， q先走n步，然后p和q一起走，直到q走到结点，删除p.next解决。

理解： 先走了n步，q始终在p前方n个，这样q走到末尾，p的下一个则是距离尾端n个的，画个图还是容易理解。


- 160. Intersection of Two Linked Lists

如果两个linkedlist有intersection的话，可以看到，其实如果一开始我们就走到b2的话，那么我们就可以两个pointer一个一个的对比，到哪一个地址一样，接下来就是intersection部分。

就一开始把长的那条list走掉多余部分。
还有这里保证了是无环的状况



```
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
```


## 快慢指针

- 141. Linked List Cycle

用两个指针，一个每次走两步，一个每次走一步，如果慢的最终和快的相遇，那么说明有环，否则没有环，直观的理解是如果两个跑的速度不一的人进操场跑步，那么最终慢的会追上快的.



## Reverse Linked List

- 206. Reverse Linked List

loop版本用prev, cur ,nxt 三个指针过一遍，recursion版本如下，可以再消化消化

```
class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        return self.doReverse(head, None)
        
        
    def doReverse(self, head, newHead):
        if head == None:
            return newHead
        nxt = head.next
        head.next = newHead
        return self.doReverse(nxt, head)
```


## 寻找LinkedList中间项

依旧使用双指针，快慢指针：快指针每次走两步，慢指针每次走一步，快指针如果到头了，那么慢指针也会在中间了，这个中间可以考量，如果是奇数的话必然是中间。

如果是偶数则是偏前面的中间一项

```
1 -> 2 -> 3 -> 4: 2 
1 -> 2 -> 3 -> 4 -> 5 -> 6 : 3
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 : 4

```

算法：

```

def findMid(head):
    if head == None or head.next == None:
        return head

    slow = head
    fast = head

    while fast.next and fast.next.next:
        slow = slow.next
        fast = fast.next.next
        
    return slow
```






