# -*- coding:utf-8 -*-
class Solution:
    # init
    def __init__(self):
        self.dic = {}
        self.lis = []
    # 返回对应char
    def FirstAppearingOnce(self):
        # write code here
        while len(self.lis) > 0 and self.dic[self.lis[0]] == 2:
            self.lis.pop(0)
        if len(self.lis) == 0:
            return '#'
        else:
            return self.lis[0]
        
    def Insert(self, char):
        # write code here
        if char not in self.dic.keys():
            self.dic[char] = 1
            self.lis.append(char)
        elif self.dic[char]:
            self.dic[char] = 2