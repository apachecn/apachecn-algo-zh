package code;
/*
 * 21. Merge Two Sorted Lists
 * 题意：合并两个链表
 * 难度：Easy
 * 分类：Linked List
 * Tips：可用递归的写法，代码更简洁
 */
public class lc21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode temp = res;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }else{
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
        }
        if(l1!=null)
            temp.next = l1;
        if(l2!=null)
            temp.next = l2;
        return res.next;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
