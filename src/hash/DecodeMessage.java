package hash;

/**
 * 2325. 解密消息
 * https://leetcode.cn/problems/decode-the-message/
 * 简单
 */
public class DecodeMessage {

    public static void main(String[] args) {
        String res = decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv");
        System.out.println(res);


    }

    public static String decodeMessage(String key, String message) {
        char[] map = new char[26];
        char aToz = 'a';
        for (char ch : key.toCharArray()) {
            int index = ch - 'a';
            //char类型默认值\u0000,unicode编码，也可以是0
            if (ch != ' ' && map[index] == '\u0000') {//去除输入串的空格和判断是否为char类型的初始化类型，
                map[index] = aToz++;
            }
        }

        char[] ans = message.toCharArray();
        for (int i = 0; i < ans.length; i++) {
            int index = ans[i] - 'a';
            if (ans[i] != ' ') ans[i] = map[index];
        }
        return new String(ans);
    }
}
