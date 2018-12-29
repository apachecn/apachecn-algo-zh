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

判断isWordEnd利用```if '#' in node:```即可，使用方法见[第212题思路三](https://github.com/apachecn/awesome-algorithm/blob/master/docs/Leetcode_Solutions/Python/212._Word_Search_II.md)























