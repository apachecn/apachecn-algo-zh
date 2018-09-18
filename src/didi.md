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


```
