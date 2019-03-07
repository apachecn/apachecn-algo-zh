package code;
/*
 * 148. Sort List
 * 题意：链表排序
 * 难度：Medium
 * 分类：Linked List, Sort
 * 思路：快慢指针把链表分成两半，在merge两个链表
 * Tips：空间复杂度不是O(1)的，但是几个高票答案都是这样写的，面试给出这样的代码应该也够了
 */
public class lc148 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode sortList(ListNode head) {
        if( head==null || head.next == null ){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while( fast.next!=null && fast.next.next!=null ){   //把链表分成两半
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l2 = sortList(slow.next);
        slow.next = null;
        ListNode l1 = sortList(head);
        return mergeList(l1, l2);
    }

    public ListNode mergeList(ListNode l1, ListNode l2){
        ListNode res = new ListNode(0);
        ListNode head = res;
        while( l1!=null && l2!=null ){
            if(l1.val<l2.val){
                res.next = l1;
                l1 = l1.next;
                res = res.next;
            }else{
                res.next = l2;
                l2 = l2.next;
                res = res.next;
            }
        }
        if(l1!=null){
            res.next = l1;
        }
        if(l2!=null){
            res.next = l2;
        }
        return head.next;
    }
}
