package string;

/**
 * 2185. 统计包含给定前缀的字符串
 * https://leetcode.cn/problems/counting-words-with-a-given-prefix/
 * 简单
 * 直接调用字符串的startswith方法
 * 或者自己写一个trie树
 */


public class PrefixCount {

    public int prefixCount(String[] words, String pref) {
        int cnt = 0;
        for (String word : words) {
            if (word.startsWith(pref)) cnt++;
        }
        return cnt;
    }

    static class TrieNode {
        private final TrieNode[] children = new TrieNode[26];
        private boolean isEnd = false;


        public void insert(String word) {
            TrieNode node = this;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }


        public int searchPrefix(String prefix) {
            TrieNode node = this;

            for (char ch : prefix.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    break;
                }
                node = node.children[index];
            }
            return node.isEnd ? 1 : 0;
        }
    }

    public int prefixCountTrie(String[] words, String pref) {
        //把prefix放入字典树，判断每个word是否含有prefix
        int cnt = 0;
        TrieNode node = new TrieNode();
        node.insert(pref);

        for (String word : words) {
            cnt += node.searchPrefix(word);
        }
        return cnt;
    }


}
