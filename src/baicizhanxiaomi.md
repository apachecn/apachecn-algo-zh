```python
"""百词斩第一题"""

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
"""

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







```
