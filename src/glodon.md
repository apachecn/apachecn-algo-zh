```python

"""第一题"""

​​​​​​​def f(n):
    res = 0
    for i in range(1, n+1, 2):
        res += i
    for i in range(2, n+1, 2):
        res -= i
    return res


"""第二题"""

​​​​​​​res = []
nums = ['9','8','7','6','5','4','3','2','1']


def convert(formula):
    if not formula or len(formula) == 0:
        return 0
    tmp = ''
    for i in range(len(formula)):
        if formula[i] == '+' formula[i] != '+' and formula[i] != '-':
            return int(tmp) + valid(formula[i+1:]) 
        elif formula[i] == '-':
            return int(tmp) - valid(formula[i+1:])
        else:
            tmp += formula[i]

def valid(formula):
    if convert(formula) == 100:
        return True
    return False
        
            
def cal(formu, idx):
    if idx == len(nums) - 1:
        formula = ''.join(formu)
        if valid(formula):
            res.append(formula)
    for i in range(idx, len(nums)-1):
        cal(formu, i+1)
        cal(formu[:i] + [formu[i]+'+'] + formu[i+1:], i+1)
        cal(formu[:i] + [formu[i]+'-'] + formu[i+1:], i+1)


cal(nums, 0)
print('Results of formulas below all equal to 100')
for i in res:
    print(i)

"""第三题"""

​​​​​​​假设我们开始排列是1,2,3,4,5
然后首先我们要让第一个位置变成2，3，4或者5才满足条件，而在其中我们又会遇到原位置没有变化的情况，则我们知道每次变换2个位置的时候总有重复，因为两边计算出的所有情况中总有一半是不满足的，并且是对于所有位置不同的情况下，那么我们不妨从第一个位置开始，则公式为   ，其中n为小朋友的个数   

开始编码：
from math import factorial
def cal(n):
    return (n-1) * factorial(n-1) // 2                                                                                                                                                                                                                                                                                                                                                                                                                                                                         




"""第四题"""

​​​​​​​import sys
def maxSum(nums, window_len):
    res = -sys.maxsize
    for i in range(len(nums)-window_len):
        res = max(res, sum(nums[i:i+k]))
    return res
        



"""第五题"""

class ListNode(object):
    def __init__(self, val, next, sib):
        self.val = val
        self.next = next
        self.sib = sib

class Clone(object)
    def cloneComplicateListNode(self, head):
        if not head:
            return head
        dummy = cur = ListNode(head.val, None, None)
        while head:
            cur.next = self.cloneComplicateListNode(head.next)
            cur.sib = self.cloneComplicateListNode(head.sib)
            head = head.next
            cur = cur.next
        return dummy
        
```
