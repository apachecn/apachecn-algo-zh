from __future__ import print_function


class Solution:
    def InversePairs(self, data):
        # write code here
        count = 0

        for item in sorted(data):
            count += data.index(item)
            data.remove(item)
             
        return count%1000000007
    

count = 0
class Solution:
    def InversePairs(self, data):
        global count
        def MergeSort(lists):
            global count
            if len(lists) <= 1:
                return lists
            num = int( len(lists)/2 )
            left = MergeSort(lists[:num])
            right = MergeSort(lists[num:])
            r, l=0, 0
            result=[]
            while l<len(left) and r<len(right):
                if left[l] < right[r]:
                    result.append(left[l])
                    l += 1
                else:
                    result.append(right[r])
                    r += 1
                    count += len(left)-l
                    print('count: ', count)
            result += right[r:]
            result += left[l:]
 
            return result
        MergeSort(data)
        return count%1000000007
