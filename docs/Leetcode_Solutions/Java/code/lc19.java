package code;
/*
 * 19. Remove Nth Node From End of List
 * 题意：删除链表中倒数第n个节点
 * 难度：Medium
 * 分类：Linked List, Two Pointers
 * 思路：快慢指针，快指针达到链表尾部时，满指针所在位置即为操作的节点
 * 注意：看清题意，是倒数第n个，且复杂度为n
 */
public class lc19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode low = new ListNode(0);
        ListNode fast = new ListNode(0);
        ListNode res = low;
        low.next = head;
        fast.next = head;
        while(n>0){
            fast = fast.next;
            n--;
        }
        while(fast.next!=null){
            low = low.next;
            fast = fast.next;
        }
        ListNode temp = low.next.next;
        low.next = temp;
        return res.next;
    }

     public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
