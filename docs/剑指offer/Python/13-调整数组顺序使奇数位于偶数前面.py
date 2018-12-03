class Solution:
    def reOrderArray(self, array):
        # write code here
        return sorted(array,key=lambda c:c%2,reverse=True)