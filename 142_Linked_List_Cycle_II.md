### 141. Linked List Cycle

题目:

<https://leetcode.com/problems/linked-list-cycle/>


难度:

Medium

思路：
稍微改了一下[141]()，这里稍微注意一下```while-else clause```就行


```python
class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                break
        else:
            return None
        while head != slow:
            slow = slow.next
            head = head.next
        return head
```


