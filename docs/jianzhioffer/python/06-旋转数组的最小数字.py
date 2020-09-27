# -*- coding:utf-8 -*-
class Solution:
    def minNumberInRotateArray(self, rotateArray):
        # write code here
        if len(rotateArray) == 0:
            return 0
        front = 0
        rear = len(rotateArray) - 1
        minVal = rotateArray[0]
        
        if rotateArray[front] < rotateArray[rear]:
            return rotateArray[front]
        else:
            while (rear - front) > 1: 
                mid = (front + rear) // 2
                if rotateArray[front] == rotateArray[rear] == rotateArray[mid]:
                    for i in range(1, len(rotateArray)):
                        if rotateArray[i] < minVal:
                            minVal = rotateArray[i]
                            rear = i
                elif rotateArray[mid] >= rotateArray[front]:
                    front = mid
                elif rotateArray[mid] <= rotateArray[rear]:
                    rear = mid
            minVal = rotateArray[rear]
            return minVal
