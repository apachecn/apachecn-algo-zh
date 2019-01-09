# -*- coding:utf-8 -*-
class Solution:
    def FindGreatestSumOfSubArray(self, array):
        # write code here
        if not array:
            return 0
        
        cur_sum = 0
        max_sum = array[0]
        
        for i in range(len(array)):
            if cur_sum <= 0:
                cur_sum = array[i]
            else:
                cur_sum += array[i]
                
            if cur_sum > max_sum:
                max_sum = cur_sum
                
        return max_sum