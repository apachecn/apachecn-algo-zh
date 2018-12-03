# -*- coding:utf-8 -*-
class Solution:
    # array 二维列表
    def Find(self, target, array):
        # write code here
        if array == []:
            return False
        num_row = len(array)
        num_col = len(array[0])
        
        i = num_col - 1
        j = 0
        
        while i >= 0 and j < num_row:
            if array[j][i] > target:
                i -= 1
            elif array[j][i] < target:
                j += 1
            else:
                return True