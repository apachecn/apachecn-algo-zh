## 一

```python
class TrieNode(object):

    def __init__(self):
        self.children = dict()
        self.isWordEnd = False

    def buildTrie(self, words):
        for word in words:
            curr = self
            for char in word:
                if char not in curr.children:
                    curr.children[char] = TrieNode()
                curr = curr.children[char]
            curr.isWordEnd = True

    def find(self, word):
        curr = self
        for char in word:
            if char not in curr.children:
                return False
            curr = curr.children[char]
        return curr.isWordEnd

def print_words(node, word):

    if node.isWordEnd:
        print(word, end=' ')

    for key, value in node.children.items():
        print_words(value, word + key)


def test():
    words = ['banana', 'bananas', 'bandana', 'band', 'apple', 'all', 'beast']
    root = TrieNode()
    root.buildTrie(words)
    print_words(root, '')
    assert root.find('banana')
    assert not root.find('bandanas')
    assert not root.find('apps')
    assert root.find('apple')

test()
```

## 二

还有一种更简单的模式

```python
# build trie 
trie = {}
for w in words:
    t = trie
    for c in w:
        if c not in t:
            t[c] = {}
        t = t[c]
    t['#'] = '#'
```

判断isWordEnd利用
```python
if '#' in node:
```
即可，使用方法见[第212题思路三](https://github.com/apachecn/awesome-algorithm/blob/master/docs/Leetcode_Solutions/Python/212._Word_Search_II.md)


## 三

更简便的构造方法：

```python
from functools import reduce

Trie = lambda: collections.defaultdict(Trie)
trie = Trie()

#reduce(..., S, trie) is trie[S[0]][S[1]][S[2]][...][S[S.length - 1]]        
nodes = [reduce(dict.__getitem__, word[::-1], trie)
         for word in words]

# node[i] 就是该word reduce到最后的空trie，即{}，说明该word reduce到最后是叶子节点
return sum(len(word) + 1
           for i, word in enumerate(words)
           if len(nodes[i]) == 0)

```

详细见[第820题](https://github.com/apachecn/awesome-algorithm/blob/master/docs/Leetcode_Solutions/Python/820._Short_Encoding_of_Words.md)



















