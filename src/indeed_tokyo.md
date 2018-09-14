```python
"""第一题"""
tmp = input().split()
n, q = int(tmp[0]), int(tmp[1])
nums = [int(i) for i in input().split()]
idx_ms = []
for i in range(q):
    tmp = input().split()
    idx, m = int(tmp[0]), int(tmp[1])
    idx_ms.append([idx, m])
sums = sum([i for i in nums if i & 1 == 0])
res = [sums] * (q+1)
for i in range(q):
    flag = nums[idx_ms[i][0]-1] & 1 == 0

    if flag and idx_ms[i][1] + nums[idx_ms[i][0]-1] & 1 == 0:
        res[i+1] = res[i] + idx_ms[i][1]
    elif flag and idx_ms[i][1] + nums[idx_ms[i][0]-1] & 1 != 0:
        res[i+1] = res[i] - nums[idx_ms[i][0] - 1]
    elif not flag and idx_ms[i][1] + nums[idx_ms[i][0]-1] & 1 == 0:
        res[i + 1] = res[i] + idx_ms[i][1] + nums[idx_ms[i][0] - 1]

    else:
        res[i+1] = res[i]

    nums[idx_ms[i][0] - 1] += idx_ms[i][1]

# print(res[1:])

for i in range(q):
    print(res[i+1])





"""第二题"""
import sys
N = int(input())
nums = [-sys.maxsize] + [int(i) for i in input().split()]
res = 0
flag = 1
for i in range(len(nums)):
    if nums[i] >= nums[i-1]:
        continue
    elif nums[i] <= 0 and -nums[i] >= nums[i-1]:
        res += 1
        nums[i] = -nums[i]
    elif nums[i] <= 0 and -nums[i] < nums[i-1]:
        flag = 0
        print(-1)
        break
    elif nums[i] < nums[i-1] and nums[i] > 0:
        flag = 0
        print(-1)
        break
if flag:
    print(res)
    
    
    

"""第三题"""
class Solution():
    def __init__(self):
        self.res = 0
        self.lst = []
    def sol(self):
        tmp = input().split()
        row, col = int(tmp[0]), int(tmp[1])

        grid = []
        for i in range(row):
            grid.append([i for i in input()])
        def bfs_paths(grid, start, goal):
            if start[0] == goal[0] and start[1] == goal[1]:
                self.res += 1
            if start[0] == row-1 and start[1] == col-1:
                return
            # print(start, goal)
            if 0 <= start[0] + 1 < row and grid[start[0]+1][start[1]] == '.':
                bfs_paths(grid, [start[0]+1,start[1]], goal)
            if 0 <= start[1] + 1 < col and grid[start[0]][start[1]+1] == '.':
                bfs_paths(grid, [start[0],start[1]+1], goal)
            # return res
        n = int(input())
        for i in range(n):
            tmp = input().split()
            goal1, goal2 = int(tmp[0]), int(tmp[1])
            # print(goal1, goal2)


            bfs_paths(grid, [0,0], [goal1-1,goal2-1])
            # print([goal1-1,goal2-1])
            self.lst.append(self.res % (pow(10, 9) + 7))
            self.res = 0


s = Solution()
s.sol()
for i in s.lst:
    print(i)
    
    

"""第四题"""
tmp = input().split()
n, m = int(tmp[0]), int(tmp[1])
requi = []
for i in range(m):
    nums = [int(i) for i in input().split()]
    requi.append(nums)

keys =set([1])
rooms = set([1])
# flag = True
while True:
    flag1 = False
    for i in requi:

        if i[0] in rooms and i[1] not in rooms:
            if i[2] in keys:
                flag1 = True
                rooms.add(i[1])
                keys.add(i[1])
    if not flag1:
        break

print(len(rooms))
```
