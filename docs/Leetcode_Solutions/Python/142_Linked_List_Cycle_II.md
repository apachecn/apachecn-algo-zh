# 142. Linked List Cycle II

**<font color=red>难度: Medium</font>**

## 刷题内容

> 原题连接

* https://leetcode.com/problems/linked-list-cycle-ii/description/

> 内容描述

```
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
```

## 解题方案

> 思路 1
******- 时间复杂度: O(N^2)******- 空间复杂度: O(1)******

直接快慢指针，跟141一样，。这里稍微注意一下***```while-else clause```***就行


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


