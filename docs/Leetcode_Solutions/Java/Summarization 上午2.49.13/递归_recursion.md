#递归 Recursion

### 递归

递归绝对是一个非常重要的概念。比如安利？ 不断的delegate，本来想要完成1000个人的销售，找10个人，每人完成100人的，这10个人每人再去找10个人，每人完成10人的销售，这样就完成了1000人的销售（不懂安利是否这样，拿来举例）。


递归之所以重要，这里面存在的概念太多了，首先上面这个例子里面就有divide and conquer的意思，把task divide小，然后来解决它。


同样有趣的例子 → 吃完一个bowl of chips：

- for loop，知道多少薯片，然后从0开始吃到最后
- while， while 碗里还有薯片，就吃
- 递归，吃一片，然后继续吃剩下的 N - 1 片，直到碗里的薯片数量只剩下0片了


典型的例子：

- pow(x,n)
- isPalindrome
- TowerofHanoi
- binarySearch



### 链表， 树， 图

链表（linked list） 是数据结构的基础，而链表本身就是具有递归特性的,看C++中对于linked list node的定义, next指向本身这样的结构，就是再这个node定义还未完成之时，我们已经指向自己。


```
struct node{
    int data;
    node* next;
};
```

binary tree定义就是靠递归来实现的。
