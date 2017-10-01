# Tree Search， Graph Search， DFS, BFS


其实原本是根本不知道还有tree search的，只知道graph search，原来graph search就是一般我看到的dfs，bfs，有一个结构来记录visited node，这样在寻找邻居的时候，防止已经visit的node再被visit.


### Tree Search

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




### Graph Search

very simple fix: never expand a state type twice

```
function GRAPH_SEARCH(problem, fringe) returns a solution, or failure
	closed <- an empty set
	fringe <- INSERT(MAKE-NODE(INITIAL-STATE[problem]),fringe)
	loop do
		if fringe is empty then return failure
		node <- REMOVE-FRONT(fringe)
		if GOAL-TEST(problem, STATE[node]) then return node
		if STATE[node] is not in closed then
			add STATE[node] to closed
			fringe <- INSERTALL(EXPAND(node, problem))
	end

```


重要的点：

- fringe
- strategy

然后没有查重的过程

####DFS 

递归伪码

```
1  procedure DFS(G,v):
2      label v as discovered
3      for all edges from v to w in G.adjacentEdges(v) do
4          if vertex w is not labeled as discovered then
5              recursively call DFS(G,w)
```

非递归伪码，其实递归在计算机内部就是用的stack，所以这里用stack可以解决问题

每次都expand deepest node

```
1  procedure DFS-iterative(G,v):
2      let S be a stack
3      S.push(v)
4      while S is not empty
5          v = S.pop()
6          for all edges from v to w in G.adjacentEdges(v) do
7              if w is not labeled as discovered:
8                  label w as discovered
9                  S.push(w)
```


#### BFS

伪码，这个伪码提供的信息有点多啊，把Unweighted shortest distance顺便也求出来了。

```
 1 Breadth-First-Search(Graph, root):
 2 
 3     for each node n in Graph:            
 4         n.distance = INFINITY        
 5         n.parent = NIL
 6 
 7     create empty queue Q      
 8 
 9     root.distance = 0
10     Q.enqueue(root)                      
11 
12     while Q is not empty:        
13     
14         current = Q.dequeue()
15     
16         for each node n that is adjacent to current:
17             if n.distance == INFINITY:
18                 n.distance = current.distance + 1
19                 n.parent = current
20                 Q.enqueue(n)
```

其实跟以上DFS的非递归写成一样也行

expand the shallowest node


```
1  procedure BFS-iterative(G,v):
2      let Q be a queue
3      Q.enqueue(v)
4      while Q is not empty
5          v = Q.dequeue()
6          for all edges from v to w in G.adjacentEdges(v) do
7              if w is not labeled as discovered:
8                  label w as discovered
9                  Q.enqueue(w)
```

BFS和DFS其实就是每次选下一个expand的node用的strategy不同.


#### DFS/BFS with Path

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




def dfs_paths(graph, start, goal):
    stack = [(start, [start])]
    visited = set()
    while stack:
        (vertex, path) = stack.pop()
        if vertex not in visited:
            if vertex == goal:
                return path
            visited.add(vertex)
            for neighbor in graph[vertex]:
                stack.append((neighbor, path + [neighbor]))

print (dfs_paths(graph, 'A', 'F'))   #['A', 'B', 'E', 'F']
```

一旦BFS/DFS与更具体的，更有特性的data structure结合起来，比如binary search tree，那么BFS/DFS会针对这个tree traversal显得更有特性。


#### UCS

expand the cheapest node first

Fringe is a priority queue

乃Dijkstra算法


#### Greedy

#### A*

