package code;
/*
 * 141. Linked List Cycle
 * 题意：链表是否有环
 * 难度：Easy
 * 分类：Linked List, Two Pointers
 * 思路：快慢指针
 */
public class lc141 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        ListNode faster = head;
        ListNode slow = head;
        while( faster.next!=null && faster.next.next!=null){    //注意判断条件，slow一定不等于null，不用判断了
            slow = slow.next;
            faster = faster.next.next;
            if(slow==faster)
                return true;
        }
        return false;
    }
}
