## 如果一个图完全联通且没有环，那么它就是一棵树(思想来源于[261题](https://github.com/apachecn/awesome-algorithm/blob/master/docs/Leetcode_Solutions/Python/261._Graph_Valid_Tree.md))

### 方法1: union-find
******- 时间复杂度: O(V * E)******- 空间复杂度: O(V)******

```python
class Graph:
    def __init__(self, n, edges):
        self.edges = edges
        self.n = n
        self.uf = [i for i in range(n)]

    def find(self, x, uf):
        while x != uf[x]:
            uf[x] = uf[uf[x]]
            x = uf[x]
        return uf[x]

    def union(self, x, y, uf):
        x_root = self.find(x, uf)
        y_root = self.find(y, uf)
        uf[x_root] = y_root

    def hasCycle(self):
        for node1, node2 in self.edges:
            if self.find(node1, self.uf) == self.find(node2, self.uf):  # cycle exists
                return True
            else:
                self.union(node1, node2, self.uf)
        return False

    def fullyConnected(self):
        self.hasCycle()  # 必须先调用一下这段代码实现preprocess
        return len(set(self.find(i, self.uf) for i in self.uf)) == 1  # fully connected

n = 4
edges = [[0,1],[2,3]]
graph = Graph(n, edges)
print('Does graph has cycle? : ', graph.hasCycle())  # False
print('Does graph has fully connected? : ', graph.fullyConnected())  # False


n = 5
edges = [[0,1],[0,2],[0,3],[1,4]]
graph = Graph(n, edges)
print('Does graph has cycle? : ', graph.hasCycle())  # False
print('Does graph has fully connected? : ', graph.fullyConnected())  # True
```

### 方法2: DFS
******- 时间复杂度: O(V + E)******- 空间复杂度: O(V)******

```python
import collections


class Graph(object):
    def __init__(self, vertex_cnt, edges):
        self.vertex_cnt = vertex_cnt
        self.graph = collections.defaultdict(list)
        self.visited = [False] * self.vertex_cnt
        for node1, node2 in edges:
            self.addEdge(node1, node2)

    def addEdge(self, v1, v2):
        self.graph[v1].append(v2)
        self.graph[v2].append(v1)

    def hasCycleHelper(self, v, visited, prev_v):
        self.visited[v] = True
        for i in self.graph[v]:
            if not visited[i]:
                if self.hasCycleHelper(i, visited, v):
                    return True
            else:
                if i != prev_v:
                    return True
        return False

    def hasCycle(self):
        if self.hasCycleHelper(0, self.visited, -1):
            return True
        return False

    def fullyConnected(self):
        return all(self.visited)



n = 4
edges = [[0,1],[2,3]]
graph = Graph(n, edges)
print('Does graph has cycle? : ', graph.hasCycle())  # False
print('Does graph has fully connected? : ', graph.fullyConnected())  # False


n = 5
edges = [[0,1],[0,2],[0,3],[1,4]]
graph = Graph(n, edges)
print('Does graph has cycle? : ', graph.hasCycle())  # False
print('Does graph has fully connected? : ', graph.fullyConnected())  # True
```
