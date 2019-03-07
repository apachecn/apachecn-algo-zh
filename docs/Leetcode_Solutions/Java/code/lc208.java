package code;
/*
 * 208. Implement Trie (Prefix Tree)
 * 题意：字典树
 * 难度：Medium
 * 分类：Design, Trie
 * 思路：字典树是一个数据结构，这个数据结构里包含很多TrieNode，每个TireNode都用一个长度为26的TrieNode[]数组表示该字符的下一个字符对象
 * Tips：
 */
public class lc208 {
    class TrieNode {
        public char val;
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];
        public TrieNode() {}
        TrieNode(char c){
            TrieNode node = new TrieNode();
            node.val = c;
        }
    }

    public class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
            root.val = ' ';
        }

        public void insert(String word) {
            TrieNode ws = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(ws.children[c - 'a'] == null){
                    ws.children[c - 'a'] = new TrieNode(c);
                }
                ws = ws.children[c - 'a'];
            }
            ws.isWord = true;
        }

        public boolean search(String word) {
            TrieNode ws = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(ws.children[c - 'a'] == null) return false;
                ws = ws.children[c - 'a'];
            }
            return ws.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode ws = root;
            for(int i = 0; i < prefix.length(); i++){
                char c = prefix.charAt(i);
                if(ws.children[c - 'a'] == null) return false;
                ws = ws.children[c - 'a'];
            }
            return true;
        }
    }
}
