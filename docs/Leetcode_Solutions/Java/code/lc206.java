package code;
/*
 * 206. Reverse Linked List
 * 题意：链表反转
 * 难度：Easy
 * 分类：Linked List
 * 思路：2中方法：设置一个快走一步的快指针，注意赋值操作顺序。还有一种递归的方法。
 * Tips：递归的方法有点绕，多看下
 */
public class lc206 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;    //头节点变成尾节点，最后要指向null
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {   //递归
        return reverseListInt(head, null);
    }
    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);  //尾递归，操作已经完成，最后返回最后结果罢了
    }
}
