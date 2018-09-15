```python
"""第一题千分位"""

n = input()[::-1]
if not n or len(n) == 0:
    print('')
else:
    if n[-1] == '-':
        n = n[:-1]
        tmp = []
        for i in range(0, len(n), 3):
            tmp.append(n[i:i+3])
        # print(tmp)
        print('-'+','.join(i[::-1] for i in tmp[::-1]))
    else:
        tmp = []
        for i in range(0, len(n), 3):
            tmp.append(n[i:i + 3])

        print(','.join(i[::-1] for i in tmp[::-1]))




"""第二题通配符"""
p = input()
s = input()


def isMatch(s, p):
    def helper(s, i, p, j):
        if j == -1:
            return i == -1
        if i == -1:
            if p[j] == '*' or p[j] == '#':
                return helper(s, i, p, j - 1)
            return False
        if p[j] == '*':
            return helper(s, i - 1, p, j) or helper(s, i, p, j-1)
        if p[j] == '#':
            return helper(s, i - 1, p, j-1) or helper(s, i, p, j - 1)
        if p[j] == '?' or p[j] == s[i]:
            return helper(s, i - 1, p, j - 1)
        return False

    return helper(s, len(s) - 1, p, len(p) - 1)
# print(1 if isMatch(s, p) else 0)


tmp = [['a?c', 'abc'], ['a?c', 'ac'], ['a#c', 'ac'], ['a#c', 'abc'], ['a#c', 'abbc'], ['a*c', 'ac'],
       ['a*c', 'abc'], ['a*c', 'abbc'], ['a*c', 'abd'], ['a?c#e*f', 'abcdef'], ['a?c#e*f', 'acdef']]
# for i in tmp:
#     p, s = i[0], i[1]
#     print(1 if isMatch(s, p) else 0)

print(1 if isMatch(s, p) else 0)
"""
输出应该为：
1
0
1
1
0
1
1
1
0
1
0
"""
```
