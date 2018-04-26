# Tree Search， Graph Search， DFS, BFS


其实原本是根本不知道还有tree search的，只知道graph search，原来graph search就是一般我看到的dfs，bfs，有一个结构来记录visited node，这样在寻找邻居的时候，防止已经visit的node再被visit.


## Tree Search

general tree search pseudocode


```
function TREE_SEARCH(problem, strategy) returns a solution, or failure
	initialize the search tree using the initial state of problem
	loop do
		if there are no candidates for expansion then return failure
		choose a leaf node for expansion according to strategy
		if the node contains a goal state then return the corresponding solution
		else expand the node and add the resulting nodes to the search tree
	end
```


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
The implementation below uses the stack data-structure to build-up and return a set of vertices that are accessible within the subjects connected component. Using Python’s overloading of the subtraction operator to remove items from a set, we are able to add only the unvisited adjacent vertices.
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
The second implementation provides the same functionality as the first, however, this time we are using the more succinct recursive form. Due to a common Python gotcha with default parameter values being created only once, we are required to create a new visited set on each user invocation. Another Python language detail is that function variables are passed by reference, resulting in the visited mutable set not having to reassigned upon each recursive call.
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
We are able to tweak both of the previous implementations to return all possible paths between a start and goal vertex. The implementation below uses the stack data-structure again to iteratively solve the problem, yielding each possible path when we locate the goal. Using a generator allows the user to only compute the desired amount of alternative paths.
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
The implementation below uses the recursive approach calling the ‘yield from’ PEP380 addition to return the invoked located paths. Unfortunately the version of Pygments installed on the server at this time does not include the updated keyword combination.
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

Similar to the iterative DFS implementation the only alteration required is to remove the next item from the beginning of the list structure instead of the stacks last.
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
This implementation can again be altered slightly to instead return all possible paths between two vertices, the first of which being one of the shortest such path.
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
Knowing that the shortest path will be returned first from the BFS path generator method we can create a useful method which simply returns the shortest path found or ‘None’ if no path exists. As we are using a generator this in theory should provide similar performance results as just breaking out and returning the first matching path in the BFS implementation.
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



