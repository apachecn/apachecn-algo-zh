#Python的各种Pass

感觉最近对于pass by reference 和 pass by value又有了一点/一些认识


1. python不允许程序员选择采用传值还是传引用。Python参数传递采用的肯定是“传对象引用”的方式。实际上，这种方式相当于传值和传引用的一种综合。如果函数收到的是一个可变对象（比如字典或者列表）的引用，就能修改对象的原始值——相当于通过“传引用”来传递对象。如果函数收到的是一个不可变对象（比如数字、字符或者元组）的引用，就不能直接修改原始对象——相当于通过“传值'来传递对象。
2. 当人们复制列表或字典时，就复制了对象列表的引用同，如果改变引用的值，则修改了原始的参数。
3. 为了简化内存管理，Python通过引用计数机制实现自动垃圾回收功能，Python中的每个对象都有一个引用计数，用来计数该对象在不同场所分别被引用了多少次。每当引用一次Python对象，相应的引用计数就增1，每当消毁一次Python对象，则相应的引用就减1，只有当引用计数为零时，才真正从内存中删除Python对象。


##### Linked List的例子



```
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
  
```



来改变head

```
def testWithPointers1(head):
    head.next = None   
```



运行 testWithPointers1(node1)

然后node1.next 为None了  

// 可以理解，因为传进去的是head这个可变对象。



```
def testWithPointers2(head):
    cur = head
    cur.next = None
```



运行 testWithPointers2(node1)
// node1.next 同样为None了   

Python的object，list都是pass by reference，所以是改变的

看另外一个例子：

```
def printLinkedList(head):
	while head:
		print(head)
		head = head.next
```


输出

```
  printLinkedList(head)

<__main__.ListNode object at 0x1044c0e10>

1

<__main__.ListNode object at 0x1044c0fd0>

2

<__main__.ListNode object at 0x1044c0c88>

3

<__main__.ListNode object at 0x1044c0be0>

4

<__main__.ListNode object at 0x1044c0780>

5

head

Out[39]: <__main__.ListNode at 0x1044c0e10>

```

其实这里的head为什么没有改变有点疑惑



##### String看一下


    a  = "abc"
    
    def changeA(s):
    	s = ""
    changeA(a)


a 并不会改变，依旧为'abc'

 