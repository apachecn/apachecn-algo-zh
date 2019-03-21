```python
"""第一题"""

lookup1 = set('qwertasdfgzxcv')
lookup2 = set('yuiophjklbnm')

def minDistance(word1, word2):
    if len(word1) == 0 or len(word2) == 0:
        return max(len(word1), len(word2))
    dp = [[0 for j in range(len(word2)+1)] for i in range(len(word1)+1)]
    for i in range(1, len(word1)+1):
        for j in range(1, len(word2)+1):
            tmp_dist = 0
            if word1[i-1] == word2[j-1]:
                tmp_dist == 0
            elif (word1[i-1] in lookup1 and word2[j-1] in lookup1) or (word1[i-1] in lookup2 and word2[j-1] in lookup2):
                tmp_dist = 1
            else:
                tmp_dist = 2
            dp[i][j] = min(dp[i-1][j]+3, dp[i][j-1]+3, dp[i-1][j-1]+tmp_dist)
    # print(dp)
    return dp[-1][-1]

"""
slep slap sleep step shoe shop snap slep
"""

strs = input().split(' ')
# print(strs)
dists = [0]
for i in range(1, len(strs)):
    dists.append((minDistance(strs[0], strs[i])))
# print(dists)
tmp = [0] * len(dists)
for i in range(1, len(dists)):
    tmp[i] = [dists[i], strs[i]]
tmp = tmp[1:]

tmp = sorted(tmp, key=lambda x:x[0])
# print(tmp)
res = tmp[0][1]+' ' + tmp[1][1]+' '+tmp[2][1]
print(res)



"""第二题""" PS: 这题感谢算法群里的kkk大佬指点我

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
题目图片见下方：
### 第一题
![](https://github.com/apachecn/awesome-leetcode/blob/master/src/51CFCB8475F4ED5B1CAD5F23CF96887A.jpg)
![](https://github.com/apachecn/awesome-leetcode/blob/master/src/B9A582497F833DDE4E93FA5BAA0BA4EB.jpg)
### 第二题
![](https://github.com/apachecn/awesome-leetcode/blob/master/src/5C3A0153C03FD214FE68B002903E2135.jpg)

