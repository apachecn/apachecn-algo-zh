




```python
import heapq
cache = {}
def power_number(index):
    if index in cache:
        return cache[index]
    tmp = set()
    for i in range(2, index+3):
        for j in range(2, 27):
            tmp.add(pow(i, j))
    gene = heapsort(tmp)
    tmp_index = 0
    for i in range(index+1):
        if tmp_index not in cache:
            cache[tmp_index] = next(gene)
        else:
            next(gene)
        if tmp_index == index:
            return cache[tmp_index]
        tmp_index += 1


def heapsort(iterable):
    h = []
    for value in iterable:
        heapq.heappush(h, value)
    for i in range(len(h)):
        yield heapq.heappop(h)

print(power_number(6500))
```
