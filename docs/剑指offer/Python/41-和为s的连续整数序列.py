# -*- coding:utf-8 -*-
class Solution:
    def FindContinuousSequence(self, tsum):
        # write code here
        small, big,res = 1, 2, []
        csum = small + big
        while small < big:
            if csum > tsum:
                csum -= small
                small += 1
            else:
                if csum == tsum:
                    res.append([i for i in range(small,big+1)])
                big += 1
                csum += big
        return res