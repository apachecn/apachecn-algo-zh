# -*- coding:utf-8 -*-
class Solution:
    def __init__(self):
        self.left = []
        self.right = []
        self.count = 0
    def Insert(self, num):
        if self.count & 1 == 0:
            self.left.append(num)
        else:
            self.right.append(num)
        self.count += 1

    def GetMedian(self, x):
        if self.count == 1:
            return self.left[0]
        self.MaxHeap(self.left)
        self.MinHeap(self.right)
        if self.left[0] > self.right[0]:
            self.left[0], self.right[0] = self.right[0], self.left[0]
        self.MaxHeap(self.left)
        self.MinHeap(self.right)
        if self.count & 1 == 0:
            return (self.left[0] + self.right[0])/2.0
        else:
            return self.left[0]

    def MaxHeap(self, alist):
        length = len(alist)
        if alist == None or length <= 0:
            return
        if length == 1:
            return alist
        for i in range(length//2-1, -1, -1):
            k = i; temp = alist[k]; heap = False
            while not heap and 2*k < length-1:
                index = 2*k+1
                if index < length - 1:
                    if alist[index] < alist[index + 1]: index += 1
                if temp >= alist[index]: heap = True
                else:
                    alist[k] = alist[index]
                    k = index
            alist[k] = temp

    def MinHeap(self, alist):
        length = len(alist)
        if alist == None or length <= 0:
            return
        if length == 1:
            return alist
        for i in range(length//2-1, -1, -1):
            k = i; temp = alist[k]; heap = False
            while not heap and 2 * k < length - 1:
                index = 2 * k+1
                if index < length - 1:
                    if alist[index] > alist[index + 1]: index += 1
                if temp <= alist[index]:
                    heap = True
                else:
                    alist[k] = alist[index]
                    k = index
            alist[k] = temp