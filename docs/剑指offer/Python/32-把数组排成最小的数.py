# -*- coding:utf-8 -*-
class Solution:
    def PrintMinNumber(self, numbers):
        # write code here
        if not numbers:
            return ''
        
        str_num = [str(m) for m in numbers]
        for i in range(len(numbers)-1):
            for j in range(i+1,len(numbers)):
                if str_num[i] + str_num[j] > str_num[j] + str_num[i]:
                    str_num[i],str_num[j] = str_num[j] ,str_num[i]
                    
        return ''.join(str_num)