package code;
/*
 * 142. Linked List Cycle II
 * 题意：求链表环的起始节点
 * 难度：Medium
 * 分类：Linked List, Two Pointers
 * 思路：lc141进一步问题。快慢指针相遇后走了a+b步，head 走a步后到起始点，则 a+b+n=2a+2b -> a+b=n 所以相遇点再走a步到起始点。相遇以后再设一个指针从head开始走，慢指针接着走，则相遇点为环的入口点。
 * Tips：
 */
public class lc142 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode slow2 = head;
        while( fast.next!=null && fast.next.next!=null ){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                while(slow2!=slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow2;
            }
        }
        return null;
    }
}
