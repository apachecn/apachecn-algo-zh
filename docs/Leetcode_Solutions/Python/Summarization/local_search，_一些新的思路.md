# Local Search， 一些新的思路

当一个问题我们只关心解法，而不是其达到解的顺序，那么考虑使用local search，比如八皇后问题，我们只关心哪个皇后放哪，根本不关心加入皇后的顺序。

local search还能用来解一类问题，求最优。



> A complete local search algorithm always finds a goal if one exists; an optimal algorithm always finds a global minimum/maximum.


一个解八皇后的新思路是我们根本就random来放皇后，然后如果state 合法，就get解答一枚，否则可以Move only to neighboring states，当然，选之剑attack数量最少的state.

这种方法叫 hill - climbing，很多问题，可能被卡，然后random restart