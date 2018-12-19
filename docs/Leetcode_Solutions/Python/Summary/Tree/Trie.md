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
