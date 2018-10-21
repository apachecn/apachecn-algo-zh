
<http://stackoverflow.com/questions/4098179/anyone-know-this-python-data-structure>


看一下deque + rotate：


```python 
import collections
a = collections.deque()
a.append(2)
a.append(5)
a.append(7)
a.append(9)  #a  deque([2, 5, 7, 9])

import bisect
idx = bisect.bisect_left(a,3) #1
a.rotate(-idx) #deque([5, 7, 9, 2])

a.appendleft(3) #deque([3, 5, 7, 9, 2])

a.rotate(idx) # deque([2, 3, 5, 7, 9])
```

这个rotate -是往左边rotate，看官网的介绍.

>Rotate the deque n steps to the right. If n is negative, rotate to the left. Rotating one step to the right is equivalent to: d.appendleft(d.pop()).

所以这样造成可以🐂的数据结构

用这个微调之后的fasttable来解决问题


```python
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
        if obj in self.__deque:
            return
        index = bisect.bisect_left(self.__deque, obj)
        self.__deque.rotate(-index)
        self.__deque.appendleft(obj)
        self.__deque.rotate(index)
```


可以用来实现动态插入元素，只是记录一下，我个人觉得这个还没直接insert(idx, num)快呢
