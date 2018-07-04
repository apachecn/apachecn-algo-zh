# coding:utf-8


# 冒泡排序
# 1. 外层循环负责设置冒泡排序进行的次数
# 2. 内层循环负责前后两两比较，求最大值放到最后
def bubble_sort(nums):
    for i in range(len(nums)-1):
        for j in range(len(nums)-i-1):  # ｊ为列表下标
            if nums[j] > nums[j+1]:
                nums[j], nums[j+1] = nums[j+1], nums[j]
    return nums


if __name__ == "__main__":
    nums = [5, 1, 9, 3, 2, 7]
    bubble_sort(nums)
    print(nums)
