# -*- coding:utf-8 -*-
class Solution:
    def Fibonacci(self, n):
        # write code here
        tempArray = [0,1]
        if n >= 2:
            for i in range(2, n+1):
                tempArray[i%2] = tempArray[0] + tempArray[1]
        return tempArray[n%2]