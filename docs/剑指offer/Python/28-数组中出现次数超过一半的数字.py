class Solution:
    def MoreThanHalfNum_Solution(self, numbers):
        # write code here
        length = len(numbers)
        if not numbers:
            return 0
        result = numbers[0]
        times = 1
        
        for i in range(1,length):
            if times == 0:
                result = numbers[i]
                times = 1
            elif numbers[i] == result:
                times += 1
            else:
                times -= 1
                
        if not self.CheckNoreThanHalf(numbers,length,result):
            return 0
        return result
            
    def CheckNoreThanHalf(self, numbers,length,number):
        times = 0
        for i in range(length):
            if numbers[i] == number:
                times += 1
                
        if times*2 <= length:
            return False
        return True