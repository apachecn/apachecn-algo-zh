## 并查集（参考leetcode323题）

### 应用场景：

动态联通性

- 网络连接判断：
如果每个pair中的两个整数用来表示这两个节点是需要连通的，那么为所有的pairs建立了动态连通图后，就能够尽可能少的减少布线的需要，
因为已经连通的两个节点会被直接忽略掉。例如[1,2]代表节点1和节点2是联通的，如果再次出现[2,1]我们就不需要再连接他们了，因为已经连接过一次了。

- 变量名等同性(类似于指针的概念)：
在程序中，可以声明多个引用来指向同一对象，这个时候就可以通过为程序中声明的引用和实际对象建立动态连通图来判断哪些引用实际上是指向同一对象。

### 对问题建模：

在对问题进行建模的时候，我们应该尽量想清楚需要解决的问题是什么。因为模型中选择的数据结构和算法显然会根据问题的不同而不同，
就动态连通性这个场景而言，我们需要解决的问题可能是：

1. 给出两个节点，判断它们是否连通，如果连通，不需要给出具体的路径
2. 给出两个节点，判断它们是否连通，如果连通，需要给出具体的路径

就上面两种问题而言，虽然只有是否能够给出具体路径的区别，但是这个区别导致了选择算法的不同

### 建模思路：

最简单而直观的假设是，对于连通的所有节点，我们可以认为它们属于一个组，因此不连通的节点必然就属于不同的组。
随着Pair的输入，我们需要首先判断输入的两个节点是否连通。如何判断呢？按照上面的假设，我们可以通过判断它们属于的组，然后看看这两个组是否相同。
如果相同，那么这两个节点连通，反之不连通。为简单起见，我们将所有的节点以整数表示，即对N个节点使用0到N-1的整数表示。
而在处理输入的Pair之前，每个节点必然都是孤立的，即他们分属于不同的组，可以使用数组来表示这一层关系。
数组的index是节点的整数表示，而相应的值就是该节点的组号了。该数组可以初始化为：```uf = [i for i in range(n)]```

初始化完毕之后，对该动态连通图有几种可能的操作：

1. 查询节点属于的组

数组对应位置的值即为组号

2. 判断两个节点是否属于同一个组

分别得到两个节点的组号，然后判断组号是否相等

3. 连接两个节点，使之属于同一个组

分别得到两个节点的组号，组号相同时操作结束，不同时，将其中的一个节点的组号换成另一个节点的组号

4. 获取组的数目

初始化为节点的数目，然后每次成功连接两个节点之后，递减1

### API：

我们可以设置对应的API
```python
def uf(n)   # 初始化uf数组和组数目
def union(x, y) # 连接两个节点
def find(x) # 判断节点所属于的组
def connected(x, y) # 判断两个节点是否联通
def count(x) # 返回所有组的数目
```

注意其中使用整数来表示节点，如果需要使用其他的数据类型表示节点，比如使用字符串，那么可以用哈希表来进行映射，即将String映射成这里需要的Integer类型。

分析以上的API，方法connected和union都依赖于find，connected对两个参数调用两次find方法，而union在真正执行union之前也需要判断是否连通，
这又是两次调用find方法。因此我们需要把find方法的实现设计的尽可能的高效。所以就有了下面的Quick-Find实现。

### Quick-Find实现

```
class Solution(object):
    uf = []    # access to component id (site indexed)
    count = 0  # number of components

    def uf(n):  # 初始化uf数组和组数目
        self.count = n
        self.uf = [i for i in range(n)]    
        
    def find(self, x):  # 判断节点所属于的组
        return uf[x]

    def union(self, x, y):  # 连接两个节点
        x_root = find(x)
        y_root = find(y)
        if x_root == y_root:
            return
        for i in range(len(self.uf)):
            if uf[i] == x_root:
                uf[i] = y_root
        count -= 1
    
    def connected(self, x, y):  # 判断两个节点是否联通
        return find(x) == find(y)
    
    def count(x):  # 返回所有组的数目
        return count               
```

上述代码的find方法十分高效，因为仅仅需要一次数组读取操作就能够找到该节点的组号。
但是问题随之而来，对于需要添加新路径的情况，就涉及到对于组号的修改，因为并不能确定哪些节点的组号需要被修改，
因此就必须对整个数组进行遍历，找到需要修改的节点，逐一修改，这一下每次添加新路径带来的复杂度就是线性关系了，
如果要添加的新路径的数量是M，节点数量是N，那么最后的时间复杂度就是MN，显然是一个平方阶的复杂度，对于大规模的数据而言，平方阶的算法是存在问题的，
这种情况下，每次添加新路径就是“牵一发而动全身”，想要解决这个问题，关键就是要提高union方法的效率，让它不再需要遍历整个数组。


### Quick-Union 算法：

考虑一下，为什么以上的解法会造成“牵一发而动全身”？因为每个节点所属的组号都是单独记录，各自为政的，没有将它们以更好的方式组织起来，
当涉及到修改的时候，除了逐一通知、修改，别无他法。所以现在的问题就变成了，如何将节点以更好的方式组织起来，组织的方式有很多种，
但是最直观的还是将组号相同的节点组织在一起，想想所学的数据结构，什么样子的数据结构能够将一些节点给组织起来？
常见的就是链表，图，树，什么的了。但是哪种结构对于查找和修改的效率最高？毫无疑问是树，因此考虑如何将节点和组的关系以树的形式表现出来。

如果不改变底层数据结构，即不改变使用数组的表示方法的话。可以采用parent-link的方式将节点组织起来，
举例而言，uf[p]的值就是p节点的父节点的序号，如果p是树根的话，uf[p]的值就是p，因此最后经过若干次查找，一个节点总是能够找到它的根节点，
即满足uf[root] = root的节点也就是组的根节点了，然后就可以使用根节点的序号来表示组号。所以在处理一个pair的时候，
将首先找到pair中每一个节点的组号(即它们所在树的根节点的序号)，如果属于不同的组的话，就将其中一个根节点的父节点设置为另外一个根节点，
相当于将一颗独立的树编程另一颗独立的树的子树。直观的过程如下图所示。但是这个时候又引入了问题。

树这种数据结构容易出现极端情况，因为在建树的过程中，树的最终形态严重依赖于输入数据本身的性质，比如数据是否排序，是否随机分布等等。
比如在输入数据是有序的情况下，构造的BST会退化成一个链表。在我们这个问题中，也是会出现的极端情况的。

```
class Solution(object):
    uf = []    # access to component id (site indexed)
    count = 0  # number of components

    def uf(n):  # 初始化uf数组和组数目
        self.count = n
        self.uf = [i for i in range(n)]    
        
    def find(self, x):  # 判断节点所属于的组
    # if uf[x] != x:      ## 这种方式也可以，但是递归次数多了容易出问题
    # 	uf[x] = find(uf[x])
        while x != uf[x]:
            x = uf[x]
        return uf[x]

    def union(self, x, y):  # 连接两个节点
        x_root = find(x)
        y_root = find(y)
        uf[x_root] = y_root
        count -= 1
    
    def connected(self, x, y):  # 判断两个节点是否联通
        return find(x) == find(y)
    
    def count(x):  # 返回所有组的数目
        return count        
```

为了克服这个问题，BST可以演变成为红黑树或者AVL树等等。

然而，在我们考虑的这个应用场景中，每对节点之间是不具备可比性的。因此需要想其它的办法。在没有什么思路的时候，多看看相应的代码可能会有一些启发，
考虑一下Quick-Union算法中的union方法实现：

```
def union(self, x, y):  # 连接两个节点
    x_root = find(x)
    y_root = find(y)
    uf[x_root] = y_root
    count -= 1
```

上面 id[pRoot] = qRoot 这行代码看上去似乎不太对劲。因为这也属于一种“硬编码”，这样实现是基于一个约定，即p所在的树总是会被作为q所在树的子树，
从而实现两颗独立的树的融合。那么这样的约定是不是总是合理的呢？显然不是，比如p所在的树的规模比q所在的树的规模大的多时，
p和q结合之后形成的树就是十分不和谐的一头轻一头重的”畸形树“了。

所以我们应该考虑树的大小，然后再来决定到底是调用 uf[x_root] = y_root 或者是 uf[y_root] = x_root

即总是size小的树作为子树和size大的树进行合并。这样就能够尽量的保持整棵树的平衡。

所以现在的问题就变成了：树的大小该如何确定？

我们回到最初的情形，即每个节点最一开始都是属于一个独立的组，通过下面的代码进行初始化：
```
tree_size = [1 for i in range(n)]
```

然后：

```
def union(self, x, y):  # 连接两个节点
    x_root = find(x)
    y_root = find(y)
	if tree_size[x_root] <= tree_size[y_root]:
    	uf[x_root] = y_root
		tree_size[y_root] += tree_size[x_root]
	else:
    	uf[y_root] = x_root
		tree_size[x_root] += tree_size[y_root]
    count -= 1
```

可以发现，通过tree_size数组决定如何对两棵树进行合并之后，最后得到的树的高度大幅度减小了。这是十分有意义的。
因为在Quick-Union算法中的任何操作，都不可避免的需要调用find方法，而该方法的执行效率依赖于树的高度。树的高度减小了，
find方法的效率就增加了，从而也就增加了整个Quick-Union算法的效率。

上面的论证其实还可以给我们一些启示，即对于Quick-Union算法而言，节点组织的理想情况应该是一颗十分扁平的树，所有的孩子节点应该都在height为1的地方，
即所有的孩子都直接连接到根节点。这样的组织结构能够保证find操作的最高效率。

那么如何构造这种理想结构呢？

在find方法的执行过程中，不是需要进行一个while循环找到根节点嘛？如果保存所有路过的中间节点到一个数组中，然后在while循环结束之后，
将这些中间节点的父节点指向根节点，不就行了么？但是这个方法也有问题，因为find操作的频繁性，会造成频繁生成中间节点数组，
相应的分配销毁的时间自然就上升了。那么有没有更好的方法呢？还是有的，即将节点的父节点指向该节点的爷爷节点，这一点很巧妙，
十分方便且有效，相当于在寻找根节点的同时，对路径进行了压缩，使整个树结构扁平化。相应的实现如下，实际上只需要添加一行代码：

```
def find(self, x):  # 判断节点所属于的组
	uf[x] = uf[uf[x]]
	return uf[x]
```
综上，我决定以后解决问题的时候用这个模版就行了：

```python
class Solution(object):
    uf = []    # access to component id (site indexed)
    count = 0  # number of components

    def uf(n):  # 初始化uf数组和组数目
        self.count = n
        self.uf = [i for i in range(n)]    
        
    def find(self, x):  # 判断节点所属于的组
        while x != uf[x]:
	    uf[x] = uf[uf[x]]
            x = uf[x]
        return uf[x]

    def union(self, x, y):  # 连接两个节点
        x_root = find(x)
        y_root = find(y)
        uf[x_root] = y_root
        count -= 1
    
    def connected(self, x, y):  # 判断两个节点是否联通
        return find(x) == find(y)
    
    def count(x):  # 返回所有组的数目
        return count        
```
至此，动态连通性相关的Union-Find算法基本上就介绍完了，从容易想到的Quick-Find到相对复杂但是更加高效的Quick-Union，然后到对Quick-Union的几项改进，
让我们的算法的效率不断的提高。

这几种算法的时间复杂度如下所示：
![](https://github.com/apachecn/LeetCode/blob/master/images/union_find8D76B4AFCB73CED67BE37B92B385A55C.jpg)

对大规模数据进行处理，使用平方阶的算法是不合适的，比如简单直观的Quick-Find算法，通过发现问题的更多特点，找到合适的数据结构，然后有针对性的进行改进，
得到了Quick-Union算法及其多种改进算法，最终使得算法的复杂度降低到了近乎线性复杂度。

如果需要的功能不仅仅是检测两个节点是否连通，还需要在连通时得到具体的路径，那么就需要用到别的算法了，比如DFS或者BFS。

并查集的应用，可以参考另外一篇文章[并查集应用举例](https://blog.csdn.net/dm_vincent/article/details/7769159)

## References

1. [并查集(Union-Find)算法介绍](https://blog.csdn.net/dm_vincent/article/details/7655764)


















