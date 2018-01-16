### 第一轮：
1. Talk about the work experience of you


2. 算法题：给一个number，例如21200，



Idx:      0 1 2 3 4 
Number:   2 1 2 0 0

- 0th位置有个2，并且整个number里面有2个0；
- 1th有个1，所以整个number里面有一个1；
- 2th有个2，所以整个number里面有两个2；
- 3th有个0，所以整个number里面有0个3；
- 4th有个0，所以整个number里面有0个4

满足这个property的number是self_describing的
叫你写一个函数
def self_describing(self, number), return 这个number是不是满足self_describing，True or False



3. 算法题，面试官自己工作中的，写了一串，
- 问你是```BFS```还是DFS，
- 问你是```recursive```还是iterative，recursive方法有什么limitation
- 不管结果，你给他的代码转换成```iterative``` or recursive




### 第二轮：
1. talk about the most challenging work that you have been worked on


2. HashTable 和 BST的比较，你知道什么说什么，时间复杂度，实现，插入，删除，查找

3. HashTable 和 BST 的concurrency对比



4. 算法题

首先，morse_code = {
              'a': '..',
              'b': '.-',
              'c': '...',
              ‘d’: '-'
              ,
              ,
              .........
                   }
给你一串words，
- 例如['ab','cd']，这时候因为words里面的两个word的对应的morse_code是一样的，所以我们返回他们的morse_code，即['...-']
- 再例如有很多words，有着相同morse_code的words很多，你要返回所有相同morse_code 的words所对应的那个morse_code,例如['...-', '..']




