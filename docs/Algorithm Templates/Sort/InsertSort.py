# coding:utf8
"""
插入排序和冒泡排序的区别在于：

插入排序的前提是：左边是有序的数列
而冒泡排序：相邻的值进行交换，一共进行n次交换
"""


def insert_sort(l):
    # 循环  除第一个数字组成的有序数组 以外的数字
    for i in range(1, len(l)):
        # 每一个数字，依次和有序数组进行比较
        print l[:i]
        for j in range(len(l[:i])):
            if l[i] < l[j]:
                l[i], l[j] = l[j], l[i]


if __name__ == "__main__":
    l = [5, 1, 9, 3, 2, 7]
    print l
    insert_sort(l)
    print("result: " + str(l))
