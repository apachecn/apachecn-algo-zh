# Graph Search，DFS, BFS



## DFS/BFS 

可以让stack/queue记录更多一些的东西，因为反正stack/queue更像通用结构

```
     A
   /    \
  C      B
  \     / \
   \    D E
    \    /
       F


graph = {'A': set(['B', 'C']),
         'B': set(['A', 'D', 'E']),
         'C': set(['A', 'F']),
         'D': set(['B']),
         'E': set(['B', 'F']),
         'F': set(['C', 'E'])}
```
### DFS

迭代版本
```python
def dfs(graph, start): # iterative
    visited, stack = [], [start]
    while stack:
        vertex = stack.pop()
        if vertex not in visited:
            visited.append(vertex)
            stack.extend(graph[vertex] - set(visited))
    return visited
print(dfs(graph, 'A')) # ['A', 'C', 'F', 'E', 'B', 'D'] 这只是其中一种答案 
```

递归版本
```python
def dfs(graph, start, visited=None): # recursive
    if visited is None:
        visited = []
    print('visiting', start)
    visited.append(start)
    for next in graph[start]:
        if next not in visited:
            dfs(graph, next, visited)
    return visited
print(dfs(graph, 'A')) # ['A', 'C', 'F', 'E', 'B', 'D'] 这只是其中一种答案 
```


迭代打印出从出发点到终点的路径
```python
def dfs_paths(graph, start, goal): # iterative
    stack = [(start, [start])]
    while stack:
        (vertex, path) = stack.pop()
        for next in graph[vertex] - set(path):
            if next == goal:
                yield path + [next]
            else:
                stack.append((next, path + [next]))
print(list(dfs_paths(graph, 'A', 'F'))) # [['A', 'C', 'F'], ['A', 'B', 'E', 'F']]
```

递归打印出从出发点到终点的路径
```python
def dfs_paths(graph, start, goal, path=None): # recursive
    if path is None:
        path = [start]
    if start == goal:
        yield path
    for next in graph[start] - set(path):
        yield from dfs_paths(graph, next, goal, path + [next])
print(list(dfs_paths(graph, 'C', 'F'))) # [['C', 'A', 'B', 'E', 'F'], ['C', 'F']]
```

### BFS

迭代版本，和DFS唯一的区别就是pop(0)而不是pop()
```python
def bfs(graph, start): # iterative
    visited, queue = [], [start]
    while queue:
        vertex = queue.pop(0)
        if vertex not in visited:
            visited.append(vertex)
            queue.extend(graph[vertex] - set(visited))
    return visited
print(bfs(graph, 'A')) # ['A', 'C', 'B', 'F', 'D', 'E']
```


返回两点之间的所有路径，第一个一定是最短的
```python
def bfs_paths(graph, start, goal):
    queue = [(start, [start])]
    while queue:
        (vertex, path) = queue.pop(0)
        for next in graph[vertex] - set(path):
            if next == goal:
                yield path + [next]
            else:
                queue.append((next, path + [next]))
print(list(bfs_paths(graph, 'A', 'F'))) # [['A', 'C', 'F'], ['A', 'B', 'E', 'F']]
```

知道了这个特性，最短路径就很好搞了
```python
def bfs_paths(graph, start, goal):
    queue = [(start, [start])]
    while queue:
        (vertex, path) = queue.pop(0)
        for next in graph[vertex] - set(path):
            if next == goal:
                yield path + [next]
            else:
                queue.append((next, path + [next]))
def shortest_path(graph, start, goal):
    try:
        return next(bfs_paths(graph, start, goal))
    except StopIteration:
        return None
print(shortest_path(graph, 'A', 'F'))  # ['A', 'C', 'F']
```

#### Improvement/Follow up

1. 一旦BFS/DFS与更具体的，更有特性的data structure结合起来，比如binary search tree，那么BFS/DFS会针对这个tree traversal显得更有特性。
2. it's worth mentioning that there is an optimized queue object in the collections module called [deque](https://docs.python.org/2/library/collections.html#collections.deque)) for which removing items from the beginning ( or popleft ) takes constant time as opposed to O(n) time for lists. 



### Resources

1. [Depth-and Breadth-First Search](https://jeremykun.com/2013/01/22/depth-and-breadth-first-search/)
2. [Edd Mann](http://eddmann.com/posts/depth-first-search-and-breadth-first-search-in-python/)
3. [graph - Depth-first search in Python](https://codereview.stackexchange.com/questions/78577/depth-first-search-in-python)



