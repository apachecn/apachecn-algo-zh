##Delete Node in a Linked List问题


This is a LeetCode question, I knew its solution, but wondering about why my code not work.


>Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

>Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function


At first glance, my intution is delete like an array:

shift all the node values one front, then delete the tail, here's my implementation and test case:

    
	
	class ListNode(object):
	    def __init__(self, x):
	        self.val = x
	        self.next = None
	        
	node1 = ListNode(1)
	node2 = ListNode(2)
	node3 = ListNode(3)
	node4 = ListNode(4)
	node5 = ListNode(5)
	
	node1.next = node2
	node2.next = node3
	node3.next = node4
	node4.next = node5
	
	
	    
	def deleteNode(node):
	    """
	    :type node: ListNode
	    :rtype: void Do not return anything, modify node in-place instead.
	    """
	    while node.next:
	        node.val = node.next.val
	        node = node.next
	    node = None
	    
	    
	deleteNode(node4)
	
But After deletion, it has two 5 value nodes, the tail was still kept, can anyone please explain to me what's wrong here?

	deleteNode(node4)
	
	node1.val
	Out[162]: 1
	
	node1.next.val
	Out[163]: 2
	
	node1.next.next.val
	Out[164]: 3
	
	node1.next.next.next.val
	Out[165]: 5
	
	node1.next.next.next.next.val
	Out[166]: 5


Really appreciate any help.