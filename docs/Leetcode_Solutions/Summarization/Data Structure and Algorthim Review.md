

### Data Structure and Algorthim Review



- [x] Binary Search Tree

      - [x] 插入

            • 如果树为空，创建一个叶子节点，令该节点的key = k;
            • 如果k小于根节点的key，将它插入到左子树中;
            • 如果k大于根节点的key，将它插入到右子树中。

      - [x] 遍历

            • 前序:  根，左，右

            • 中序：左，根，右 **有序**

            • 后序：左，右，根

      - [x] 搜索

            - look up ： 是否存在

              ​• 如果树为空，搜索失败;
              ​• 如果根节点的key等于待搜索的值，搜索成功，返回根节点作为结果;
              ​• 如果待搜索的值小于根节点的key，继续在左子树中递归搜索;
              ​• 否则，待搜索的值大于根节点的key，继续在右子树中递归搜索。	

            - 最大元素和最小元素

              ​	• 最右和最左

            - 前驱(Successor)和后继(predecessor)

              ​	给定元素x，它的后继元素y是满足y > x的最小值

              ​		• 如果x所在的节点有一个非空的右子树，则右子树中的最小值就是答案

              ​		• 否则我们需要向上回溯，找到最近的一个祖先，使得该祖先的左侧孩子，也为x的祖	先。
              ​		

      - [x] 删除

               • 如果x没有子节点，或者只有一个孩子，直接将x“切下”;

               • 否则，x有两个孩子，我们用其右子树中的最小值替换掉x，然后将右子树中的这一最小值“切掉”。	






- [x] 递归
      - [x] 入门

            - 回文
            - 阶乘 factorial， 慕指数
            - 分形
            - Tower of Hanoi

      - [x] 排列 Permutation

      - [x] 子集 Subsets

      - [ ] backtracking


- [x] dynamic programming    

      -  coin change

      -  longest common subsequence

      -  edit distance

         ​




-[ ] majority element



- [ ] 随机
      - 水塘抽样
      - 洗牌


-[ ] 荷兰旗问题


-[ ] quick select


-[ ] median of two sorted array
-[ ] regular expression

