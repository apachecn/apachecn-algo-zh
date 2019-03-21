class Solution:
    def NumberOf1Between1AndN_Solution(self, n):
        # write code here
        count=0
        for i in range(1,n+1):
            while i:
                if i%10==1:
                    count+=1
                i=i/10
        return count
    
# 数学规律
# -*- coding:utf-8 -*-
class Solution:
    def NumberOf1Between1AndN_Solution(self, n):
        # write code here
        count, m =0, 1
        while m <= n:
            count += (n // m + 8) // 10 * m + (n // m % 10 == 1) * (n % m + 1)
            m*=10
        return count