# -*- coding:utf-8 -*-
class Solution:
    # 这里要特别注意~找到任意重复的一个值并赋值到duplication[0]
    # 函数返回True/False
    def duplicate(self, numbers, duplication):
        # write code here
        if not numbers or len(numbers) < 0:
            return False
        for i in numbers:
            if i < 0 or i > len(numbers) - 1:
                return False
        for i in range(len(numbers)):
            while numbers[i] != i:
                if numbers[i] == numbers[numbers[i]]:
                    duplication[0] = numbers[i]
                    return True
                else:
                    idx = numbers[i]
                    numbers[i],numbers[idx] = numbers[idx],numbers[i]
        return False