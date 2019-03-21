# -*- coding:utf-8 -*-
class Solution:
    def Sum_Solution(self, n):
        # write code here
        return self.sumN(n)
        
    def sum0(self, n):
        return 0
    
    def sumN(self,n):
        fun = {False:self.sum0,True: self.sumN}
        return n + fun[not not n](n - 1)
    
# -*- coding:utf-8 -*-
class Solution:
    def Sum_Solution(self, n):
        # write code here
        return n and self.Sum_Solution(n - 1) + n