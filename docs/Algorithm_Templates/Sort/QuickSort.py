#!/usr/bin/python
# coding:utf8


def quick_sort(l, start, end):
    i = start
    j = end
    # 结束排序
    if i >= j:
        return
    # 保存首个数值
    key = l[i]
    # 一次排序，i和j的值不断的靠拢，然后最终停止，结束一次排序
    while i < j:
        # 和最右边的比较，如果>=key,然后j-1，慢慢的和前一个值比较;如果值<key，那么就交换位置
        while i < j and key <= l[j]:
            print key, l[j], '*' * 30
            j -= 1
        l[i] = l[j]
        # 交换位置后，然后在和最左边的值开始比较，如果<=key,然后i+1，慢慢的和后一个值比较;如果值>key，那么就交换位置
        while i < j and key >= l[i]:
            print key, l[i], '*' * 30
            i += 1
        l[j] = l[i]
    l[i] = key
    # 左边排序
    quick_sort(l, start, j-1)
    # 右边排序
    quick_sort(l, i+1, end)


if __name__ == "__main__":
    l = [5, 1, 9, 3, 2, 7]
    quick_sort(l, 0, len(l) - 1)
    print l
