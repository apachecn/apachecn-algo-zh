# -*- coding:utf-8 -*-
class Solution:
    def VerifySquenceOfBST(self, sequence):
        # write code here
        if sequence == []:
            return False
        
        length = len(sequence)
        root = sequence[-1]
        
        for i in range(length):
            if sequence[i] > root:
                break
        
        for j in range(i, length):
            if sequence[j] < root:
                return False
            
        left = True
        if i > 0:
            left = self.VerifySquenceOfBST(sequence[:i])
        right = True
        if j < length - 1:
            right = self.VerifySquenceOfBST(sequence[i:length-1])
            
        return left and right