# -*- coding:utf-8 -*-
class Solution:
    def jumpFloorII(self, number):
        # write code here
        ans = 1
        if number >= 2:
            for i in range(number-1):
                ans = ans * 2
        return ans