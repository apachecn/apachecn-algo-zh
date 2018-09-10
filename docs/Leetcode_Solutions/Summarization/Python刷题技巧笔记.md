from __future__ import print_function

import heapq

# python有无数奇技淫巧和许多人不知道的秘密，这里用简洁的语言一条条表述出来，不断更新, 大家一起贡献！

# 1. python 排序
# 用lst.sort() 而不是nlst = sorted(lst)， 区别在于lst.sort()是 in-place sort，改变lst, sorted会创建新list，成本比较高。

# 2. xrange和range的区别
# range会产生list存在memory中，xrange更像是生成器，generate on demand所以有的时候xrange会更快

# 3. python处理矩阵
row = len(matrix)
col = len(matrix[0]) if row else 0
# 这样写通用的原因是， 当matrix = [], row = 0, col = 0

# 4. python列表生成式
lst = [0 for i in range(3)] # lst = [0,0,0]
lst = [[0 for i in range(3)] for j in range(2)]  # lst =  [[0, 0, 0], [0, 0, 0]]
# 下面这种写法危险：
# lst1 = [ 0, 0, 0 ]
# lst2  = [lst1] * 2  # lst2 = [ [0,0,0] , [0,0,0] ]
# lst2[0][0]  = 1  # lst2 = [ [1,0,0], [1,0,0]]
# 因为lst1是object，改一个相当于全改, 这样写会踩坑

# 5. D.get(key, default)
# 如果这个key 没有在dict里面，给它一个默认值：
D = {}
if 1 in D:
  val = D[1]
else :
  val = 0
# 等同于这样写：
val = D.get(1, 0)

# 6. 字典赋值
if key in D:
  D[key].append(1)
else :
  D[key] = []

# 7. 字符串反转
# python字符串没有reverse函数，只能str[::-1]
string[::-1]
# python的list可以直接reverse()，因此也可以借用这个特性
"".join([string].reverse())

# 8. 快速统计
import collections
lst = [1, 1, 1, 2, 3, 4, 5, 5]
collections.Counter(lst) # Counter({1: 3, 5: 2, 2: 1, 3: 1, 4: 1})

# 9. python自带小顶堆heapq
# Python有built-in heap, 默认min heap.
heapq.heappush(heap, item) # 把item添加到heap中（heap是一个列表）

heapq.heappop(heap) # 把堆顶元素弹出，返回的就是堆顶

heapq.heappushpop(heap, item) # 先把item加入到堆中，然后再pop，比heappush()再heappop()要快得多

heapq.heapreplace(heap, item) # 先pop，然后再把item加入到堆中，比heappop()再heappush()要快得多

heapq.heapify(x) # 将列表x进行堆调整，默认的是小顶堆

heapq.merge(*iterables) # 将多个列表合并，并进行堆调整，返回的是合并后的列表的迭代器

heapq.nlargest(n, iterable, key=None) # 返回最大的n个元素（Top-K问题）

heapq.nsmallest(n, iterable, key=None) # 返回最小的n个元素（Top-K问题）

# 如何来用它实现max heap呢，看到过一个有意思的方法是把key取负，比如把100变成-100，5变成-5

import heapq
mylist = [1, 2, 3, 4, 5, 10, 9, 8, 7, 6]
largest = heapq.nlargest(3, mylist) # [10, 9, 8]
smallest = heapq.nsmallest(3, mylist) # [1, 2, 3]

# 10. 双端队列deque [http://stackoverflow.com/questions/4098179/anyone-know-this-python-data-structure]
# 可以很简单的.popleft(), .popright(), .appendleft(), .appendright(),最关键的是时间是O(1), 而用list来模拟队列是O(n)的时间复杂度
# 还有很好用的rotate函数，
# 一个简单的跑马灯程序
import sys
import time
from collections import deque

fancy_loading = deque('>--------------------')

while True:
    print('\r%s' % ''.join(fancy_loading))
    fancy_loading.rotate(1)
    sys.stdout.flush()
    time.sleep(0.08)

# 11. 用yield 不用return，可以返回一个generator

# 12. 符号～的巧妙应用
for i in range(n):
  # 这里的```[~i]``` 意思就是 ```[n-1-i]```
  a[~i] = 1
