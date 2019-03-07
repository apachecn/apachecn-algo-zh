package code;
/*
 * 328. Odd Even Linked List
 * 题意：奇数的node都在偶数node的后面，第一个节点index为0
 * 难度：Medium
 * 分类：Linked List
 * 思路：while的条件很不好想，记住：这种跳两次的迭代，都判断后边那个节点的 next!=null 为终止条件
 * Tips：lc318
 */
public class lc328 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode even = head;
        ListNode odd_head = head.next;
        ListNode odd = head.next;
        while( odd!=null && odd.next!=null ){   //这个条件很难想通
            even.next = even.next.next;
            odd.next = odd.next.next;
            even = even.next;
            odd = odd.next;
        }
        even.next = odd_head;
        return head;
    }
}
