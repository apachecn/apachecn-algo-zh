#!/usr/bin/python
# coding:utf8
'''
迭代使用的是循环结构。
递归使用的是选择结构。
'''
from __future__ import print_function

# 递归求解
def calculate(l):
    if len(l) <= 1:
        return l[0]
    value = calculate(l[1:])
    return 10**(len(l) - 1) * l[0] + value


# 迭代求解
def calculate2(l):
    result = 0
    while len(l) >= 1:
        result += 10 ** (len(l)-1) * l[0]
        l = l[1:]
    return result


l1 = [1, 2, 3]
l2 = [4, 5]
sum = 0
result = calculate(l1) + calculate(l2)
# result = calculate2(l1) + calculate2(l2)
print(result)
