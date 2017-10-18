### Python刷题技巧笔记

备份自己的帖子

有的时候


**用Python解题经常可以作弊，Python 处理string非常方便， python内置模块非常多，比如排列组合啥的各种....**


有的时候


**Python大法好，就是偶尔慢**




Python也是可以追求运行速度的，除了算法方面的提升，也有些常见函数之间的区别


还有我刷的Python 2 和 3 已经迷茫了，如果有说错的地方敬请指出




===========初级技巧=================




-  排序


用lst.sort() 而不是nlst = sorted(lst)


区别在于lst.sort()是 in-place sort，改变lst, sorted会创建新list，成本比较高。




- 用xrange 


xrangge 和 range的区别是在于 range会产生list存在memory中，xrange更像是生成器，generate on demand


所以有的时候xrange会更快


-  三目运算符


python 的三目运算符是这么写的 x if y else z


考虑这种list of list: matrix = [ [1,2,3] , [4,5,6] ]


```row  = len(matrix)```,
```col = len(matrix[0]) if row else 0 ```


这样写通用的原因是， 当matrix = [], row = 0, col =0


- list 填 0


lst = [0 for i in range(3)] # lst = [0,0,0]


lst  = [[0 for i in range(3)] for j in range(2)]  # lst =  [[0, 0, 0], [0, 0, 0]]




下面这种写法危险：


lst1 = [ 0, 0, 0 ]
lst2  = [lst1] * 2  # lst2 = [ [0,0,0] , [0,0,0] ]
lst2\[0]\[0]  = 1  # lst2 = [ [1,0,0], [1,0,0]]


因为lst1是object，这样写会踩坑




- D.get(key, default)


如果这个key 没有在dict里面，给它一个默认值：


D = {}
if 1 in D:
  val = D[1]
else :
  val = 0


等同于这样写：


val = D.get(1, 0)




- reverse list


lst = [1,2,3]


print lst[::-1] #[3,2,1]


lst 也有reverse函数


这也也适用于str, str可是没有reverse 函数的，str[::-1] 可用 √




=================进阶一下=====================


Python 也是有自己的数据结构的！！！！


- deque
    还在用list来做queue么？ deque，当求快queue的时候，你值得拥有


- Counter
    Counter做啥就顾名思义了


- yield
    用yield不用return （ 我也还在学习阶段








import collections就可以用了，参见  [collections — High-performance container datatypes](https://docs.python.org/2/library/collections.html)






===============举个当时我就震惊了的例子===============




看到在stackoverflow上看到有人求这样一个数据结构：


[Anyone know this Python data structure?](http://stackoverflow.com/questions/4098179/anyone-know-this-python-data-structure)





Close to **O(1) performance** for as many of the following four operations.
Maintaining **sorted order while inserting** an object into the container.
Ability to **peek at last value** (the largest value) contained in the object.
Allowing for **pops on both sides** (getting the smallest or largest values).
Capability of **getting the total size** or number of objects being stored.
Being a **ready made solution** like the code in Python's standard library.





然后真的可以implement出来

import collections
import bisect

class FastTable:

    def __init__(self):
        self.__deque = collections.deque()

    def __len__(self):
        return len(self.__deque)

    def head(self):
        return self.__deque.popleft()

    def tail(self):
        return self.__deque.pop()

    def peek(self):
        return self.__deque[-1]

    def insert(self, obj):
        index = bisect.bisect_left(self.__deque, obj)
        self.__deque.rotate(-index)
        self.__deque.appendleft(obj)
        self.__deque.rotate(index)

复制代码
对此我只想表示牛，并且我硬生生的用它来解过人家不是要这种思路的题目。




**补充内容 (2016-10-28 00:40):**
Python有built-inheap,是min heap.  heapq，如何来用它实现max heap呢，看到过一个有意思的方法是把key取负，比如把100变成-100，5变成-5。






