package code;
/*
 * 138. Copy List with Random Pointer
 * 题意：链表除了next指针外，还有一个random指针。拷贝这个链表
 * 难度：Medium
 * 分类：Hash Table, LinkedList
 * 思路：一种用HashTable，把源节点和复制的节点对应起来，空间复杂度为O(n)
 *      把要复制的节点直接连接在该节点之后，操作完以后再分开
 * Tips：因为需要每步骤返回值，所以递归的方法在这题更合适
 */
public class lc138 {
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        RandomListNode node = head;
        while(node!=null){
            RandomListNode temp = new RandomListNode(node.label);
            temp.next = node.next;
            node.next = temp;
            node = temp.next;
        }
        node = head;
        while(node!=null){
            if(node.random!=null) node.next.random = node.random.next;  //注意判断是否为空
            node = node.next.next;
        }
        node = head;
        RandomListNode res = head.next;
        RandomListNode temp = head.next;
        while(temp!=null&&temp.next!=null){
            node.next = temp.next;
            temp.next = node.next.next;
            node = node.next;
            temp = temp.next;
        }
        node.next = null;   //别忘了最后一个节点连接给null
        return res;
    }
}
