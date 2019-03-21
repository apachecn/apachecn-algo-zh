```python
一晚上做了好几家的，头疼，这些捞b公司贼烦

我自己没有参加笔试，就是纯粹A着玩，纯属娱乐

"""百词斩第一题"""

"""自我实现版本"""
def get_time_diff(time1, time2):
    res = 0
    res += (int(time2[:2]) - int(time1[:2])) * 3600
    res += (int(time2[3:5]) - int(time1[3:5])) * 60
    res += int(time2[-2:]) - int(time1[-2:])
    return res

time1 = input()
time2 = input()

sec = get_time_diff(time1, time2)
print(int(30*sec//3600))
print(int(6*sec//60))
print(int(sec*6))


"""工业版本
可惜笔试不支持
"""

from dateutil.parser import parse

def get_time_diff(time1, time2):
    time1 = parse(time1)
    time2 = parse(time2)
    return (time2-time1).total_seconds()
time1 = '2018-09-20/' + input()
time2 = '2018-09-20/' + input()

sec = get_time_diff(time1, time2)
print(int(30*sec//3600))
print(int(6*sec//60))
print(int(sec*6))


"""
14:52:11
21:41:14

00:00:00
18:00:00
"""

"""百词斩第二题"""

"""百词斩第二题"""

n = int(input())
nums = [int(i) for i in input().split()]
res = ''
# tmp = nums[0]
i = 0
start = 0
while i <= n-1:
    i += 1
    tmp = 0
    while i <= n-1 and nums[i] == nums[i-1]+1:
        i += 1
        tmp += 1
    # print(tmp, i)
    if tmp >= 2:
        # print(111)
        res += str(nums[start]) + '-' + str(nums[i-1]) + ' '
        # start = i
    elif tmp == 0:
        # print(222)
        res += str(nums[start]) + ' '
    else:
        # print(333)
        # print(nums[start:i+1])
        res += ' '.join([str(i) for i in nums[start:i]]) + ' '
    start = i
    # tmp = 0
print(res[:-1])



"""
6
1 2 3 4 6 7
6
1 2 4 5 6 7
"""


"""不知道谁的题目"""

lookup = {}
inputs = []
flag = True
while True:
    user_input = input()

    if user_input == 'END':
        break
    inputs.append(user_input)
    user_input = user_input.split('#')

    n, m = user_input[0], user_input[1]
    num = int(m, int(n))
    lookup[num] = lookup.get(num, 0) + 1

res = []
for i in range(len(inputs)):
    tmp = inputs[i].split('#')
    n, m = tmp[0], tmp[1]
    num = int(m, int(n))
    if lookup[num] == 1:
        res.append(inputs[i])

if not res:
    print('None')
else:
    for i in res:
        print(i)
print(int('33', 4))
"""
10#15
4#32
4#33
8#17
END
"""


“”“不知道谁的题目
三种颜色的球
”“”

class Solution(object):
    res = 0
    def cal_next(self, p, q, r, prev):
        tmp = [p, q, r]
        cur_max = max(tmp)
        # 此时前面排好了且都满足，想要不相邻，数量最多的球中间的所有空格
        # 必须小于或等于另外两个球的数量，否则说明此时排列不合法直接return
        if cur_max - 1 > sum(tmp) - cur_max:  
            return
        if p == q == r == 0:
            self.res += 1
            return
        if p > 0 and prev != 'p':
            self.cal_next(p-1, q, r, 'p')
        if q > 0 and prev != 'q':
            self.cal_next(p, q-1, r, 'q')
        if r > 0 and prev != 'r':
            self.cal_next(p, q, r-1, 'r')

s = Solution()
p, q, r = [int(i) for i in input().split()]
s.cal_next(p, q, r, '')
print(s.res)


```
