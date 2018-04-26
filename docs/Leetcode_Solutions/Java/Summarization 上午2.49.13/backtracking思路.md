## backtracking 全集

### 回溯是啥
用爬山来比喻回溯，好比从山脚下找一条爬上山顶的路,起初有好几条道可走,当选择一条道走到某处时,又有几条岔道可供选择,只能选择其中一条道往前走,若能这样子顺利爬上山顶则罢了,否则走到一条绝路上时,只好返回到最近的一个路口,重新选择另一条没走过的道往前走。如果该路口的所有路都走不通,只得从该路口继续回返。照此规则走下去,要么找到一条到达山顶的路,要么最终试过所有可能的道,无法到达山顶。
回溯是一种穷举，但与brute force有一些区别，回溯带了两点脑子的，并不多，brute force一点也没带。
第一点脑子是回溯知道回头；相反如果是brute force,发现走不通立刻跳下山摔死，换第二条命从头换一条路走。
第二点脑子是回溯知道剪枝；如果有一条岔路上放了一坨屎，那这条路我们不走，就可以少走很多不必要走的路。

还有一些爱混淆的概念：递归，回溯，DFS。
回溯是一种找路方法，搜索的时候走不通就回头换路接着走，直到走通了或者发现此山根本不通。
DFS是一种开路策略，就是一条道先走到头，再往回走一步换一条路走到头，这也是回溯用到的策略。在树和图上回溯时人们叫它DFS。
递归是一种行为，回溯和递归如出一辙，都是一言不合就回到来时的路，所以一般回溯用递归实现；当然也可以不用，用栈。
以下以回溯统称，因为这个词听上去很文雅。

### 识别回溯
判断回溯很简单，拿到一个问题，你感觉如果不穷举一下就没法知道答案，那就可以开始回溯了。
一般回溯的问题有三种：

1. Find a path to success 有没有解
2. Find all paths to success 求所有解
	- 2.1 求所有解的个数，
	- 2.2 求所有解的具体信息
3. Find the best path to success 求最优解

理解回溯：给一堆选择, 必须从里面选一个. 选完之后我又有了新的一组选择. ```This procedure is repeated over and over until you reach a final state. If you made a good sequence of choices, your final state is a goal state; if you didn't, it isn't.```

回溯可以抽象为一棵树，我们的目标可以是找这个树有没有good leaf，也可以是问有多少个good leaf，也可以是找这些good leaf都在哪，也可以问哪个good leaf最好，分别对应上面所说回溯的问题分类。
good leaf都在leaf上。good leaf是我们的goal state，leaf node是final state，是解空间的边界。

对于第一类问题(问有没有解)，基本都是长着个样子的，理解了它，其他类别迎刃而解：
```java
boolean solve(Node n) {
    if n is a leaf node {
        if the leaf is a goal node, return true
        else return false
    } else {
        for each child c of n {
            if solve(c) succeeds, return true
        }
        return false
    }
}
```
请读以下这段话以加深理解：
```Notice that the algorithm is expressed as a boolean function. This is essential to understanding the algorithm. If solve(n) is true, that means node n is part of a solution--that is, node n is one of the nodes on a path from the root to some goal node. We say that n is solvable. If solve(n) is false, then there is no path that includes n to any goal node.```

还不懂的话请通读全文吧：[Backtracking - David Matuszek](https://www.cis.upenn.edu/~matuszek/cit594-2012/Pages/backtracking.html)

关于回溯的三种问题，模板略有不同，
第一种，返回值是true/false。
第二种，求个数，设全局counter，返回值是void；求所有解信息，设result，返回值void。
第三种，设个全局变量best，返回值是void。

第一种：
```java
boolean solve(Node n) {
    if n is a leaf node {
        if the leaf is a goal node, return true
        else return false
    } else {
        for each child c of n {
            if solve(c) succeeds, return true
        }
        return false
    }
}
```
第二种：
```java
void solve(Node n) {
    if n is a leaf node {
        if the leaf is a goal node, count++, return;
        else return
    } else {
        for each child c of n {
            solve(c)
        }
    }
}
```
第三种：
```java
void solve(Node n) {
    if n is a leaf node {
        if the leaf is a goal node, update best result, return;
        else return
    } else {
        for each child c of n {
            solve(c)
        }
    }
}
```
题目

八皇后 N-Queens

问题

1. 给个n，问有没有解；
2. 给个n，有几种解；(Leetcode N-Queens II)
3. 给个n，给出所有解；(Leetcode N-Queens I)

解答

1.有没有解

怎么做：一行一行的放queen，每行尝试n个可能，有一个可达，返回true；都不可达，返回false.

边界条件leaf:放完第n行 或者 该放第n+1行(出界，返回)

目标条件goal:n行放满且isValid，即目标一定在leaf上

helper函数：
boolean solve(int i, int[][] matrix)
在进来的一瞬间，满足property：第i行还没有被放置，前i-1行放置完毕且valid
solve要在给定的matrix上试图给第i行每个位置放queen。
```java
public static boolean solve1(int i, List<Integer> matrix, int n) {
    if (i == n) {
        if (isValid(matrix))
            return true;
        return false;
    } else {
        for (int j = 0; j < n; j++) {
            matrix.add(j);
            if (isValid(matrix)) {    //剪枝
                if (solve1(i + 1, matrix, n)) 
                    return true;
            }
            matrix.remove(matrix.size() - 1);
        }
        return false;
    }
}
```
2.求解的个数

怎么做：一行一行的放queen，每行尝试n个可能。这回因为要找所有，返回值就没有了意义，用void即可。在搜索时，如果有一个可达，仍要继续尝试；每个子选项都试完了，返回.

边界条件leaf:放完第n行 或者 该放第n+1行(出界，返回)

目标条件goal:n行放满且isValid，即目标一定在leaf上

helper函数：
void solve(int i, int[][] matrix)
在进来的一瞬间，满足property：第i行还没有被放置，前i-1行放置完毕且valid
solve要在给定的matrix上试图给第i行每个位置放queen。
这里为了记录解的个数，设置一个全局变量(static)int是比较efficient的做法。
```java
public static void solve2(int i, List<Integer> matrix, int n) {
    if (i == n) {
        if (isValid(matrix))
            count++;
        return;
    } else {
        for (int j = 0; j < n; j++) {
            matrix.add(j);
            if (isValid(matrix)) {    //剪枝
                solve2(i + 1, matrix, n); 
            }
            matrix.remove(matrix.size() - 1);
        }
    }
}
```
3.求所有解的具体信息

怎么做：一行一行的放queen，每行尝试n个可能。返回值同样用void即可。在搜索时，如果有一个可达，仍要继续尝试；每个子选项都试完了，返回.

边界条件leaf:放完第n行 或者 该放第n+1行(出界，返回)

目标条件goal:n行放满且isValid，即目标一定在leaf上

helper函数：
void solve(int i, int[][] matrix)
在进来的一瞬间，满足property：第i行还没有被放置，前i-1行放置完毕且valid
solve要在给定的matrix上试图给第i行每个位置放queen。
这里为了记录解的具体情况，设置一个全局变量(static)集合是比较efficient的做法。
当然也可以把结果集合作为参数传来传去。
```java
public static void solve3(int i, List<Integer> matrix, int n) {
    if (i == n) {
        if (isValid(matrix))
            result.add(new ArrayList<Integer>(matrix));
        return;
    } else {
        for (int j = 0; j < n; j++) {
            matrix.add(j);
            if (isValid(matrix)) {    //剪枝
                solve3(i + 1, matrix, n); 
            }
            matrix.remove(matrix.size() - 1);
        }
    }
}
```
优化

上面的例子用了省空间的方法。
由于每行只能放一个，一共n行的话，用一个大小为n的数组，数组的第i个元素表示第i行放在了第几列上。

Utility(给一个list判断他的最后一行是否和前面冲突):
```java
public static boolean isValid(List<Integer> list){
    int row = list.size() - 1;
    int col = list.get(row);
    for (int i = 0; i <= row - 1; i++) {
        int row1 = i;
        int col1 = list.get(i);
        if (col == col1)
            return false;
        if (row1 - row == col1 - col)
            return false;
        if (row1 - row == col - col1)
            return false;
    }
    return true;
    
}
```

参考[Backtracking回溯法(又称DFS,递归)全解](https://segmentfault.com/a/1190000006121957) 
以及 [Python Patterns - Implementing Graphs](https://www.python.org/doc/essays/graphs/)



## 以Generate Parentheses为例，backtrack的题到底该怎么去思考？


所谓Backtracking都是这样的思路：在当前局面下，你有若干种选择。那么尝试每一种选择。如果已经发现某种选择肯定不行（因为违反了某些限定条件），就返回；如果某种选择试到最后发现是正确解，就将其加入解集

所以你思考递归题时，只要明确三点就行：选择 (Options)，限制 (Restraints)，结束条件 (Termination)。即“ORT原则”（这个是我自己编的）




对于这道题，在任何时刻，你都有两种选择：
1. 加左括号。
2. 加右括号。

同时有以下限制：
1. 如果左括号已经用完了，则不能再加左括号了。
2. 如果已经出现的右括号和左括号一样多，则不能再加右括号了。因为那样的话新加入的右括号一定无法匹配。

结束条件是：
左右括号都已经用完。

结束后的正确性：
左右括号用完以后，一定是正确解。因为1. 左右括号一样多，2. 每个右括号都一定有与之配对的左括号。因此一旦结束就可以加入解集（有时也可能出现结束以后不一定是正确解的情况，这时要多一步判断）。

递归函数传入参数：
限制和结束条件中有“用完”和“一样多”字样，因此你需要知道左右括号的数目。
当然你还需要知道当前局面sublist和解集res。

因此，把上面的思路拼起来就是代码：

	if (左右括号都已用完) {
	  加入解集，返回
	}
	//否则开始试各种选择
	if (还有左括号可以用) {
	  加一个左括号，继续递归
	}
	if (右括号小于左括号) {
	  加一个右括号，继续递归
	}
	
	
	
你帖的那段代码逻辑中加了一条限制：“3. 是否还有右括号剩余。如有才加右括号”。这是合理的。不过对于这道题，如果满足限制1、2时，3一定自动满足，所以可以不判断3。

这题其实是最好的backtracking初学练习之一，因为ORT三者都非常简单明显。你不妨按上述思路再梳理一遍，还有问题的话再说。



以上文字来自 1point3arces的牛人解答



Backtracking 伪码


```
Pick a starting point.
while(Problem is not solved)
	For each path from the starting point.
		check if selected path is safe, if yes select it
                and make recursive call to rest of the problem
		If recursive calls returns true, then return true.
		else undo the current move and return false.
	End For
	If none of the move works out, return false, NO SOLUTON.

```
