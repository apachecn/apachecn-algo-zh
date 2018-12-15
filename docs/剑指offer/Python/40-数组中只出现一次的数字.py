# -*- coding:utf-8 -*-
class Solution:
    # 返回[a,b] 其中ab是出现一次的两个数字
    def FindNumsAppearOnce(self, array):
        # write code here
        hashmap = {}
        for i in array:
            if str(i) in hashmap:
                hashmap[str(i)] += 1
            else:
                hashmap[str(i)] = 1
        result = []
        for k in hashmap.keys():
            if hashmap[k] == 1:
                result.append(int(k))
        return result
  
# -*- coding:utf-8 -*-
class Solution:
    # 返回[a,b] 其中ab是出现一次的两个数字
    def FindNumsAppearOnce(self, array):
        if array == None:
            return []
        xor = 0
        for i in array:
            xor ^= i

        idxOf1 = self.getFirstIdx(xor)
        num1 = num2 = 0
        for j in range(len(array)):
            if self.IsBit(array[j], idxOf1):
                num1 ^= array[j]
            else:
                num2 ^= array[j]
        return [num1, num2]

    def getFirstIdx(self, num):
        idx = 0
        while num & 1 == 0 and idx <= 32:
            idx += 1
            num = num >> 1
        return idx

    def IsBit(self, num, indexBit):
        num = num >> indexBit
        return num & 1