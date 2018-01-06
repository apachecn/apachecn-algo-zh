能用此模板解决的题目目前有如下：
[leetcode 003](https://github.com/Lisanaaa/thinking_in_lc/blob/master/003._longest_substring_without_repeating_characters.md), 
[leetcode 030](https://github.com/Lisanaaa/thinking_in_lc/edit/master/30._Substring_with_Concatenation_of_All_Words.md), 
[leetcode 076](https://github.com/Lisanaaa/thinking_in_lc/blob/master/076._Minimum_Window_Substring.md), 
[leetcode 159](https://github.com/Lisanaaa/thinking_in_lc/blob/master/159._Longest_Substring_with_At_Most_Two_Distinct_Characters.md), 
[leetcode 438](https://github.com/Lisanaaa/thinking_in_lc/blob/master/438._Find_All_Anagrams_in_a_String.md)



带注释python版本
```python
class Solution(object):
    def slideWindowTemplateByLisanaaa(self, s, t):
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
                maps[s[end]] -= 1 # plus or minus one
                if maps[s[end]] == 0:
                    counter -= 1 # modify the counter according the requirement(different condition).
            end += 1
            
            # increase begin pointer to make it invalid/valid again
            while counter == 0: # counter condition. different question may have different condition
                if s[begin] in maps:
                    maps[s[begin]] += 1 # plus or minus one
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

无注释python版本：
```python
class Solution(object):
    def slideWindowTemplateByLisanaaa(self, s, t):
        res = []
        if len(t) > len(s):
            return res
        maps = collections.Counter(t)
        counter = len(maps.keys()) 
        begin, end = 0, 0
        length = sys.maxint 
        while end < len(s):
            if s[end] in maps:
                maps[s[end]] -= 1 
                if maps[s[end]] == 0:
                    counter -= 1 
            end += 1
            while counter == 0:
                if s[begin] in maps:
                    maps[s[begin]] += 1 
                    if maps[s[begin]] > 0:
                        counter += 1 
                begin += 1
                
                '''
                1. save / update(min/max) the result if find a target
                2. result: collections or int value
                '''  
        return res
```
带注释java版本
```java
public class Solution {
    public List<Integer> slidingWindowTemplateByHarryChaoyangHe(String s, String t) {
        //init a collection or int value to save the result according the question.
        List<Integer> result = new LinkedList<>();
        if(t.length()> s.length()) return result;
        
        //create a hashmap to save the Characters of the target substring.
        //(K, V) = (Character, Frequence of the Characters)
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //maintain a counter to check whether match the target string.
        int counter = map.size();//must be the map size, NOT the string size because the char may be duplicate.
        
        //Two Pointers: begin - left pointer of the window; end - right pointer of the window
        int begin = 0, end = 0;
        
        //the length of the substring which match the target string.
        int len = Integer.MAX_VALUE; 
        
        //loop at the begining of the source string
        while(end < s.length()){
            
            char c = s.charAt(end);//get a character
            
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);// plus or minus one
                if(map.get(c) == 0) counter--;//modify the counter according the requirement(different condition).
            }
            end++;
            
            //increase begin pointer to make it invalid/valid again
            while(counter == 0 /* counter condition. different question may have different condition */){
                
                char tempc = s.charAt(begin);//***be careful here: choose the char at begin pointer, NOT the end pointer
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);//plus or minus one
                    if(map.get(tempc) > 0) counter++;//modify the counter according the requirement(different condition).
                }
                
                /* save / update(min/max) the result if find a target*/
                // result collections or result int value
                
                begin++;
            }
        }
        return result;
    }
}
```

无注释java版本：
```java
public class Solution {
    public List<Integer> slidingWindowTemplateByHarryChaoyangHe(String s, String t) {
        List<Integer> result = new LinkedList<>();
        if(t.length()> s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        int begin = 0, end = 0;
        int len = Integer.MAX_VALUE; 
        while(end < s.length()){
            char c = s.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;
            while(counter == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0) counter++;
                }
                
                /* 
                save / update(min/max) the result if find a target
                result collections or result int value
                */
                
                begin++;
            }
        }
        return result;
    }
}
```

