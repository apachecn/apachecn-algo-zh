带注释版本
```python
class Solution(object):
    def slideWindowTemplate(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: 具体题目具体分析
        """
        # init a collection or int value to save the result according the question.
        res = []
        if len(t) > len(s):
            return res
        
        # create a hashmap to save the Characters of the target substring.
        # (K, V) = (Character, Frequence of the Characters)
        maps = collections.Counter(t)
        
        # maintain a counter to check whether match the target string.
        # must be the map size, NOT the string size because the char may be duplicate.
        counter = len(maps.keys()) 
        
        # Two Pointers: begin - left pointer of the window; end - right pointer of the window
        begin, end = 0, 0
        
        # the length of the substring which match the target string.
        length = sys.maxint 
        
        # loop at the begining of the source string
        while end < len(s):
            if s[end] in maps:
                maps[s[end]] += 1 # plus or minus one
                if maps[s[end]] == 0:
                    counter -= 1 # modify the counter according the requirement(different condition).
            end += 1
            
            # increase begin pointer to make it invalid/valid again
            while counter == 0:
                if s[begin] in maps:
                    maps[s[begin]] -= 1 # plus or minus one
                    if maps[s[begin]] > 0:
                        counter += 1 # modify the counter according the requirement(different condition).
                begin += 1
                
                '''
                type your code here according to the question
                1. save / update(min/max) the result if find a target
                2. result: collections or int value
                '''  
        return res
```

无注释版本：
```python
class Solution(object):
    def minWindow(self, s, t):
        res = []
        if len(t) > len(s):
            return res
        maps = collections.Counter(t)
        counter = len(maps.keys()) 
        begin, end = 0, 0
        length = sys.maxint 
        while end < len(s):
            if s[end] in maps:
                maps[s[end]] += 1 
                if maps[s[end]] == 0:
                    counter -= 1 
            end += 1
            while counter == 0:
                if s[begin] in maps:
                    maps[s[begin]] -= 1 
                    if maps[s[begin]] > 0:
                        counter += 1 
                begin += 1
                
                '''
                1. save / update(min/max) the result if find a target
                2. result: collections or int value
                '''  
        return res
```
