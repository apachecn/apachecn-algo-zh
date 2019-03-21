# coding:utf8
"""
插入排序和冒泡排序的区别在于：

插入排序的前提是：左边是有序的数列
而冒泡排序：相邻的值进行交换，一共进行n次交换
"""
from __future__ import print_function


def insertionSort(nums):
    if not nums or len(nums) < 2:
        return nums

    for i in range(1, len(nums)):
        for j in range(i):
            if nums[i] < nums[j]:
                nums[i], nums[j] = nums[j], nums[i]
    return nums


if __name__ == "__main__":
    nums = [5, 1, 9, 3, 2, 7]
    print('input: ', nums)
    nums = insertionSort(nums)
    print("result: ", nums)
