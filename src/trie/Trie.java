package trie;

/**
 * 208. 实现 Trie (前缀树)
 * https://leetcode.cn/problems/implement-trie-prefix-tree/
 * 中等
 * <p>
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
class Main {

    public static void main(String[] args) {
        System.out.println("xxx");

        Trie trie = new Trie();
        trie.insert("appl");
        boolean apple = trie.search("apple");
        boolean app = trie.startsWith("app");
        System.out.println(apple + "\n" + app);
    }

}

public class Trie {

    private final Trie[] children;//这里并没有对children数组的修改,只有对齐内部new出来元素的修改
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    //在整个树中插入字符串word
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;




    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}

