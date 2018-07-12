# coding: utf-8


def MergeSort(nums):
    if len(nums) <= 1:
        return nums
    num = int(len(nums)/2)
    # 从中间，进行数据的拆分, 递归的返回数据进行迭代排序
    left = MergeSort(nums[:num])
    right = MergeSort(nums[num:])
    print("left: ", left)
    print("right: ", right)
    print("-" * 20)
    return Merge(left, right)


def Merge(left, right):
    l, r = 0, 0
    result = []
    while l < len(left) and r < len(right):
        if left[l] < right[r]:
            result.append(left[l])
            l += 1
        else:
            result.append(right[r])
            r += 1
    result += left[l:]
    result += right[r:]
    return result


if __name__ == "__main__":
    nums = [2, 6, 8, 5, 1, 4, 9, 3, 7]
    nums = MergeSort(nums)
    print('result:', nums)
