package trie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 720. 词典中最长的单词
 * https://leetcode.cn/problems/longest-word-in-dictionary/
 * 中等
 */


public class LongestWord {


    //trie树
    public String longestWord(String[] words) {

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        String longest = "";
        for (String word : words) {
            if (trie.searchWord(word)) {
                if (word.length() > longest.length() || (word.length() == longest.length() && word.compareTo(longest) < 0)) {
                    longest = word;
                }
            }
        }
        return longest;
    }


    public String hashSet(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return b.compareTo(a);
            }
        });
        String longest = "";
        Set<String> candidates = new HashSet<>();
        candidates.add("");
        for (String word : words) {
            if (candidates.contains(word.substring(0, word.length() - 1))) {
                candidates.add(word);
                longest = word;
            }
        }
        return longest;
    }


}

