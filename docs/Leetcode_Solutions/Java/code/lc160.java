package code;
/*
 * 160. Intersection of Two Linked Lists
 * 题意：求两个链表的交叉点
 * 难度：Easy
 * 分类：LinkedList
 * 思路：两种方法：1.找出两个链表的长度差x，长的先走x步； 2.走完一个链表，走另一个链表，两个cur都走了两个链表长度的和步
 * Tips：两种方法的本质是一样的其实，都是找到了步数差，都遍历了两遍
 */
public class lc160 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)
            return null;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            if(curA == null)
                curA = headB;
            if(curB == null)
                curB = headA;
            if(curA==curB)
                return curA;    //别忘了判断一下是否相等
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}
