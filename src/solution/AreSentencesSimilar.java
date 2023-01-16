package solution;

/**
 * 1813. 句子相似性 III
 * https://leetcode.cn/problems/sentence-similarity-iii/
 * 中等
 */
public class AreSentencesSimilar {

    public static void main(String[] args) {
        String str1 = "a b c c c";
        String str2 = "a c";

        boolean ans = areSentencesSimilar(str1, str2);
        System.out.println(ans);

    }

    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        //i是左指针从左边开始增加长度
        //j是右指针从右边开始增加长度
        int i = 0, j = 0;
        while (i < words1.length && i < words2.length && words1[i].equals(words2[i])) {
            i++;
        }
        while (j < words1.length - i && j < words2.length - i && words1[words1.length - j - 1].equals(words2[words2.length - j - 1])) {
            j++;
        }
        return i + j == Math.min(words1.length, words2.length);
    }
}
