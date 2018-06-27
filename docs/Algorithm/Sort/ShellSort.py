# coding: utf8

from __future__ import print_function
def insert_sort(l, start, increment):
    for i in range(start+increment, len(l), increment):
        for j in range(start, len(l[:i]), increment):
            if l[i] < l[j]:
                l[i], l[j] = l[j], l[i]
    print(increment, '--',l)
    return l

def shell_sort(l, increment):
    # 依次进行分层
    while increment:
        # 每一层，都进行n次插入排序
        for i in range(0, increment):
            insert_sort(l, i, increment)
        increment -= 1
    return l

if __name__ == "__main__":
    l = [5, 2, 9, 8, 1, 10, 3, 4, 7]
    increment = len(l)/3+1 if len(l)%3 else len(l)/3
    print("开始", l)
    l = shell_sort(l, increment)
    print("结束", l)