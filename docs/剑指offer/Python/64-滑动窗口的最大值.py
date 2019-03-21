# -*- coding:utf-8 -*-
class Solution:
    def maxInWindows(self, num, size):
        # write code here
        if not num or size <= 0:
            return []
        deque = []
        if len(num) >= size:
            index = []
            for i in range(size):
                while len(index) > 0 and num[i] > num[index[-1]]:
                    index.pop()
                index.append(i)
            
            for i in range(size, len(num)):
                deque.append(num[index[0]])
                while len(index) > 0 and num[i] >= num[index[-1]]:
                    index.pop()
                if len(index) > 0 and index[0] <= i - size:
                    index.pop(0)
                index.append(i)
                
            deque.append(num[index[0]])
        return deque