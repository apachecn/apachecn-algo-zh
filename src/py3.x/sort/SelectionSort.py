# coding:utf8
"""
选择排序和冒泡排序的区别在于：

选择排序的前提是：找到最大值的位置，最后才进行1次交换
而冒泡排序：相邻的值进行交换，一共进行n次交换
"""
from __future__ import print_function


def selection_sort(l):
    length = len(l) - 1

    while length:
        index = length
        # 第一个数字，和后面每一个数字进行对比，找出最大值，放到最后！！
        for j in range(length):
            if l[j] > l[index]:
                index = j
        l[length], l[index] = l[index], l[length]
        print(len(l) - length, l)
        length -= 1


if __name__ == "__main__":
    l = [5, 1, 9, 3, 2, 7]
    print(l)
    selection_sort(l)
    print("result: " + str(l))