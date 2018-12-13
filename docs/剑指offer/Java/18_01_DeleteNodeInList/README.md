## 在O(1)时间内删除链表节点

### 题目描述
给定单向链表的头指针和一个节点指针，定义一个函数在 O(1) 时间内删除该节点。

### 解法
判断要删除的节点是否是尾节点，若是，直接删除；若不是，把要删除节点的下一个节点赋给要删除的节点即可。

```java
/**
 * @author bingo
 * @since 2018/11/20
 */

public class Solution {

    class ListNode {
        int val;
        ListNode next;
    }

    /**
     * 删除链表的节点
     * @param head 链表头节点
     * @param tobeDelete 要删除的节点
     */
    public void deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null || tobeDelete == null) {
            return;
        }

        // 说明要删除的是最后一个节点
        if (tobeDelete.next == null) {
            ListNode cur = head;
            while (cur.next != tobeDelete) {
                cur = cur.next;
            }
            cur.next = null;
        } else {
            // 非尾节点，直接把该节点的下一个节点赋给当前节点
            tobeDelete.val = tobeDelete.next.val;
            tobeDelete.next = tobeDelete.next.next;
        }
    }
}
```

### 测试用例
1. 功能测试（从有多个节点的链表的中间/头部/尾部删除一个节点；从只有一个节点的链表中删除唯一的节点）；
2. 特殊输入测试（指向链表头节点的为空指针；指向要删除节点的为空指针）。