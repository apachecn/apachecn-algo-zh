package code;
/*
 * 2. Add Two Numbers
 * 题意：两个链表，节点上的数逆序组成一个数字，求和，返回链表
 * 难度：Medium
 * 分类：Linked List, Math
 * 算法：两个链表一起遍历，按位加，注意进位
 * Tips：不要遍历完一个链表保存为变量，求变量和再转化为链表。因为链表可能很长，变量无法保存下来；
 *       注意考虑两个链表长度不一致的问题
 */
public class lc2 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while(l1!=null || l2!=null){
            if(l1!=null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2!=null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(sum%10);
            cur = cur.next;
            sum = sum/10;
        }
        if(sum==1) {
            cur.next = new ListNode(1);
        }
        return result.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
