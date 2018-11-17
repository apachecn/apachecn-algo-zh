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
