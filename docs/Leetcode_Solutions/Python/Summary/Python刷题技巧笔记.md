
### python有无数奇技淫巧和许多人不知道的秘密，这里用简洁的语言一条条表述出来，不断更新, 大家一起贡献！
```python
# 1. python 排序
# 用lst.sort() 而不是nlst = sorted(lst)， 区别在于lst.sort()是 in-place sort，改变lst, sorted会创建新list，成本比较高。
```
```python
# 2. xrange和range的区别
# range会产生list存在memory中，xrange更像是生成器，generate on demand所以有的时候xrange会更快
```
```python
# 3. python处理矩阵
row = len(matrix)
col = len(matrix[0]) if row else 0
# 这样写通用的原因是， 当matrix = [], row = 0, col = 0
```
```python
# 4. python列表生成式
lst = [0 for i in range(3)] # lst = [0,0,0]
lst = [[0 for i in range(3)] for j in range(2)]  # lst =  [[0, 0, 0], [0, 0, 0]]
# 下面这种写法危险：
# lst1 = [ 0, 0, 0 ]
# lst2  = [lst1] * 2  # lst2 = [ [0,0,0] , [0,0,0] ]
# lst2[0][0]  = 1  # lst2 = [ [1,0,0], [1,0,0]]
# 因为lst1是object，改一个相当于全改, 这样写会踩坑
```
```python
# 5. D.get(key, default)
# 如果这个key 没有在dict里面，给它一个默认值：
D = {}
if 1 in D:
  val = D[1]
else :
  val = 0
# 等同于这样写：
val = D.get(1, 0)
```
```python
# 6. 字典赋值
if key in D:
  D[key].append(1)
else :
  D[key] = []
```
```python
# 7. 字符串反转和列表反转
# python字符串没有reverse函数，只能str[::-1]
string[::-1]
# python的list可以直接reverse()，因此也可以借用这个特性
"".join([string].reverse())

测试了一下3种列表反转的速度
tmp = [i for i in range(100000)]

import datetime
starttime = datetime.datetime.now()

for i in range(100000):
    tmp = tmp[::-1]
endtime = datetime.datetime.now()
print((endtime - starttime))

starttime = datetime.datetime.now()
for i in range(100000):
    tmp = list(reversed(tmp))
endtime = datetime.datetime.now()
print((endtime - starttime))

starttime = datetime.datetime.now()
for i in range(100000):
    tmp.reverse()
endtime = datetime.datetime.now()
print((endtime - starttime))




输出：
0:00:33.486971
0:01:43.027222
0:00:03.958400

说明in-place反转最快，但是这样改变了原list，因此在不能改动原list的情况下，我们用分片会更好
```
```python
# 8. 快速统计
import collections
lst = [1, 1, 1, 2, 3, 4, 5, 5]
collections.Counter(lst) # Counter({1: 3, 5: 2, 2: 1, 3: 1, 4: 1})
```
```python
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
```
```python
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
```
```python
# 11. 用yield 不用return，可以返回一个generator
```
```python
# 12. 符号～的巧妙应用
for i in range(n):
  # 这里的```[~i]``` 意思就是 ```[n-1-i]```
  a[~i] = 1
```
```python
# 13. 位运算判断奇偶数
一般判断奇偶数是用 num % 2 == 0 来判断，如果为true则为偶数，为false则为奇数。 
偶数在二进制里面，最后一位为0，奇数则为1。所以可以通过与1做位与运算判断奇偶数。
if (num & 1) == 0:
  print('偶数')
else:
  print('奇数')
如果结果为true则为偶数，为false则为奇数。效率比取余运算高的多。

反正注意不要使用
if num % 2 == 1
来判断是否是奇数，因为如果是负奇数就不满足了

最起码也要用if num % 2 != 0
```


```python
# 14. pow(x, y)的时间复杂度为:

For y < 2^63, there's a loop of size ceil(log_2(y)),
but for larger y, the result is calculated using Exp(y * Log(x)).

sqrt()函数平常认为是O(lgn)的
但是追溯到最底层，sqrt()就是O(1)的，详细见
```
1. [求平方根sqrt()函数的底层算法效率问题](http://www.nowamagic.net/algorithm/algorithm_EfficacyOfFunctionSqrt.php)
2. [Time complexity of Math.Sqrt()?](https://stackoverflow.com/questions/34580158/time-complexity-of-math-sqrt)


```python
# 15. python deque用法

Operations on deque :

1. append() :- This function is used to insert the value in its argument to the right end of deque.
2. appendleft() :- This function is used to insert the value in its argument to the left end of deque.
3. pop() :- This function is used to delete an argument from the right end of deque.
4. popleft() :- This function is used to delete an argument from the left end of deque.
5. index(ele, beg, end) :- This function returns the first index of the value mentioned in arguments, starting searching from beg till end index.
6. insert(i, a) :- This function inserts the value mentioned in arguments(a) at index(i) specified in arguments.
7. remove() :- This function removes the first occurrence of value mentioned in arguments.
8. count() :- This function counts the number of occurrences of value mentioned in arguments.
9. extend(iterable) :- This function is used to add multiple values at the right end of deque. The argument passed is an iterable.
10. extendleft(iterable) :- This function is used to add multiple values at the left end of deque. The argument passed is an iterable. Order is reversed as a result of left appends.
11. reverse() :- This function is used to reverse order of deque elements.
12. rotate() :- This function rotates the deque by the number specified in arguments. If the number specified is negative, rotation occurs to left. Else rotation is to right.
```
[Deque in Python](https://www.geeksforgeeks.org/deque-in-python/)


```python
# 16. getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

# 这种是常规方法
idx = random.randint(0, self.length-1)
return self.lst[idx]
# 神奇函数
return random.choice(self.lst)
```



```python
# 17. while-else clause

python支持while-else 语句
```
详细请看[leetcode 142题](https://github.com/apachecn/awesome-algorithm/blob/master/docs/Leetcode_Solutions/Python/142_Linked_List_Cycle_II.md)，这里我用到了这个语句，贼爽！




