package code;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * 23. Merge k Sorted Lists
 * 题意：K个有序链表合并
 * 难度：Hard
 * 分类：Linked List, Divide and Conquer, Heap
 * 思路：优先队列或分治方法
 * 注意：优先队列如何定义比较方法
 *      lc378, lc264
 */
public class lc23 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;
        PriorityQueue<ListNode> pr = new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });
        for (ListNode l:lists) {
            if (l!=null)
                pr.add(l);
        }
        ListNode head = new ListNode(0);
        ListNode ln = head;
        while(pr.size()!=0){
            ln.next = pr.remove();
            ln = ln.next;
            if(ln.next!=null)
                pr.add(ln.next);
        }
        return head.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;
        return Partition(lists,0,lists.length-1);
    }

    public ListNode Partition(ListNode[] lists, int start, int end){
        if(end-start==0)
            return lists[end];
        else{
            int mid = (start+end)/2;
            ListNode l1 = Partition(lists,start,mid);
            ListNode l2 = Partition(lists,mid+1,end);
            return Merge2List(l1,l2);
        }
    }

    public ListNode Merge2List(ListNode ln1, ListNode ln2){
        ListNode res = new ListNode(0);
        ListNode head = res;
        while(ln1!=null && ln2!=null){
            if(ln1.val<ln2.val){
                head.next = ln1;
                head = head.next;
                ln1 = ln1.next;
            }else {
                head.next = ln2;
                head = head.next;
                ln2 = ln2.next;
            }
        }
        if(ln1!=null){
            head.next = ln1;
        }
        if(ln2!=null){
            head.next = ln2;
        }
        return res.next;
    }

}
