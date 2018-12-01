```python
"""第一题"""

mat = [[0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1],
       [0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1],
       [0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1],
       [0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1]]


def maxOne(mat):
    if not mat or len(mat) == 0:
        return []

    row = len(mat)
    col = len(mat[0]) if row else 0
    i, j = -1, -1
    for idx in range(row):
        if mat[idx][-1] == 1:
            i, j = idx, col - 1
            break
    if i == -1:
        return []
    fin_max = 0
    while j >= 0 and mat[i][j] == 1:
        j -= 1
        fin_max += 1
    res = [[i+1, fin_max]]
    tmp_j = j + 1
    while i + 1 < row:
        i += 1
        j = tmp_j
        if mat[i][j] == 1:
            cur_max = fin_max - 1
            while j >= 0 and mat[i][j] == 1:
                j -= 1
                cur_max += 1
            if cur_max > fin_max:
                res = [[i+1, cur_max]]
                fin_max = cur_max
            elif cur_max == fin_max:
                res.append([i+1, cur_max])
    return res

print(maxOne(mat))


"""第三题"""

class Solution(object):
    def __init__(self):
        self.stack = []
        self.res = 0
    def dfs(self, arr, x, y, c):
        m = len(arr)
        n = len(arr[0]) if m else 0
        if x - 1 >= 0 and y >= 0 and arr[x-1][y] == 'x':
            self.stack.append((x-1)*100+y)
            arr[x-1][y] = '#'
            self.res += 1
        if x + 1 < m and y >= 0 and arr[x+1][y] == 'x':
            self.stack.append((x+1)*100+y)
            arr[x+1][y] = '#'
            self.res += 1
        if x >= 0 and y - 1 >= 0 and arr[x][y-1] == 'x':
            self.stack.append(x*100+y-1)
            arr[x][y-1] = '#'
            self.res += 1
        if x >= 0 and y + 1 < n and arr[x][y+1] == 'x':
            self.stack.append(x*100+y+1)
            arr[x][y+1] = '#'
            self.res += 1
        while self.stack:
            tmp = self.stack.pop()
            self.dfs(arr, tmp //100, tmp % 100, 'x')
        return self.res

if __name__ == '__main__':
    s = Solution()
    arr = [['x',' ',' ', ' ',' '],['x','x','x',' ','x'],['x','x','x','x','x']]
    print(s.dfs(arr, 0, 0, 'x'))



"""第四题"""


import heapq
import sys
def solution(nums):
    iters = [iter(l) for l in nums]
    heap = [(next(it), i) for i, it in enumerate(iters)]
    heapq.heapify(heap)

    lo, hi = 0, sys.maxsize
    r = max(heap)[0]
    while True:
        l, i = heap[0]
        if r - l < hi - lo:
            lo, hi = l, r
        nxt = next(iters[i], None)
        if nxt is None:
            return [lo, hi]
        r = max(r, nxt)
        heapq.heappushpop(heap, (nxt, i))

nums = [[1,3,5],[4,8],[2,5]]
print(solution(nums))

```
