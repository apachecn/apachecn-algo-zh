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
     * 
     * @param head       链表头节点
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