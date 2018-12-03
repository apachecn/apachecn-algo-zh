class Solution:
    def Power(self, base, exponent):
        # write code here
        try:
            ret = self.power_value(base, abs(exponent))
            if exponent < 0:
                return 1.0 / ret
                            
        except ZeroDivisionError:
            print('Error: base is zero')
        else:
            return ret
            
    def power_value(self,base, exponent):
        if exponent == 0:
            return 1
        if exponent == 1:
            return base
        ret = self.power_value(base, exponent >> 1)
        ret *= ret
        if exponent & 1 == 1:
            ret *= base
        return ret