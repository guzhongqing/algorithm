package trie;


/**
 * 208. 实现 Trie (前缀树)
 * https://leetcode.cn/problems/implement-trie-prefix-tree/
 * 中等
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
class Main {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("appl");
        boolean apple = trie.searchWord("apple");
        boolean app = trie.searchPrefix("app");
        System.out.println(apple + "\n" + app);
    }

}

//根结点不存值，其孩子本身就是字符，又存孩子
public class Trie {

    private final Trie[] children;//这里并没有对children数组的修改,只有对其内部new出来元素的修改
    private boolean isEnd;//结束标识

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    //在整个树中插入字符串word
    public void insert(String word) {
        //指向当前节点对象,或者说指向根节点
        Trie node = this;
        //遍历字符串中每一个字符
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {//该字符没有
                node.children[index] = new Trie();//通过数组下标表示字符，若数组下标有对象代表还有该数组下标对应的字符
            }
            node = node.children[index];//指向当前节点的孩子节点
        }
        node.isEnd = true;//修改末尾的结束标识
    }

    public boolean searchPrefix(String prefix) {
        Trie node = startsWith(prefix);
        return node != null;//这个前缀的末尾节点不为null，就代表能搜索到
    }

    public boolean searchWord(String word) {
        Trie node = startsWith(word);
        return node != null && node.isEnd;//前缀存在，且前缀的最后一个节点是结束节点，代表这个前缀是一个单词
    }


    private Trie startsWith(String prefix) {
        //指向当前节点对象
        Trie node = this;
        //遍历前缀中每一个字符
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {//找不到当前字符，代表这个前缀不在前缀数中，范围null
                return null;
            }
            node = node.children[index];//指向当前节点的孩子节点
        }
        return node;//返回最后末尾节点
    }
}

