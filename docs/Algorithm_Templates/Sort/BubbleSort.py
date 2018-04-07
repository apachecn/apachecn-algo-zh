# coding:utf-8


# 冒泡排序
def bubble_sort(l):
    length = len(l)
    # 外层循环 length遍，内层循环少一遍
    while length:
        for j in range(length - 1):
            # 找出最大值，然后交换位置到最后
            if l[j] > l[length - 1]:
                l[j], l[length - 1] = l[length - 1], l[j]
        length -= 1


if __name__ == "__main__":
    l = [5, 1, 9, 3, 2, 7]
    bubble_sort(l)
    print l
