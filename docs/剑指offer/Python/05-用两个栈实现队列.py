# -*- coding:utf-8 -*-
class Solution:
    def __init__(self):
        self.stack1 = []
        self.stack2 = []
        
    def push(self, node):
        # write code here
        self.stack1.append(node)
        
    def pop(self):
        # return xx
        if len(self.stack1) == 0 and len(self.stack2) == 0:
            return 
        elif len(self.stack2) == 0:
            while len(self.stack1) > 0:
                self.stack2.append(self.stack1.pop())
           
        return self.stack2.pop()