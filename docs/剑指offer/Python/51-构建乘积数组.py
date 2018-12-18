# -*- coding:utf-8 -*-
class Solution:
    def multiply(self, A):
        # write code here
        if not A or len(A) <= 0:
            return
        length = len(A)
        lis = [1] * length
        for i in range(1,length):
            lis[i] = lis[i-1] * A[i-1]
        temp = 1
        for i in range(length-2,-1,-1):
            temp = temp * A[i+1]
            lis[i] *= temp
        return lis