package code;
/*
 * 237. Delete Node in a Linked List
 * 题意：删除链表中的一个节点，给的是这个节点，不知道前边的节点
 * 难度：Easy
 * 分类：Linked List
 * 思路：剑指Offer上有，拷贝下一个节点的内容到该节点，倒数第二个节点置空
 * Tips：
 */
public class lc237 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public void deleteNode(ListNode node) {
        ListNode pre = new ListNode(-1);
        while(node.next!=null) {
            node.val = node.next.val;
            pre = node;
            node = node.next;
        }
        pre.next = null;
    }
}
