### 142. Linked List Cycle II

题目:

<https://leetcode.com/problems/linked-list-cycle-ii/>


难度:

Medium

思路：
稍微改了一下[141](https://github.com/Lisanaaa/thinking_in_lc/blob/master/141._linked_list_cycle.md)，这里稍微注意一下```while-else clause```就行

Let’s say, the first node is node ```0```, the cycle starts at node ```L```, and the length of the cycle is ```C```;
Moreover, after ```t``` steps, ```fast``` catches ```slow```.

Now we know that fast totally traveled ```2t``` nodes, and slow traveled ```t``` nodes

Then we have:
```2t - t = nC``` (where ```n``` is an positive integer.)
i.e. ```t=nC```

Now, think about that, at step ```t```, if we travels ```L``` more steps, where are we?
i.e. if we travel ```L+t = L + nC``` steps in total, where are we?

Absolutely, at the start of the cycle, because we have covered the first ```L``` nodes once and the entire cycle ```n``` times.

So, if we travel ```L``` more steps at time ```t```, then we get the start of the cycle.

However, how can we travel exactly ```L``` step?
The answer is to use an other pointer to travel from node ```0```, and when they meet together, it is exactly ```L``` steps and both of them are at the start of the cycle.

参考[LostSummer233的解答](https://leetcode.com/problems/linked-list-cycle-ii/discuss/44833)
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


