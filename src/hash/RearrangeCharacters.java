package hash;

/**
 * 2287. 重排字符形成目标字符串
 * https://leetcode.cn/problems/rearrange-characters-to-make-target-string/
 * 简单
 * hash
 */
public class RearrangeCharacters {
    public int rearrangeCharacters(String s, String target) {

        int[] mapS = new int[26];
        int[] mapTarget = new int[26];
        //初始化两个hash表
        for (char ch : s.toCharArray()) {
            mapS[ch - 'a']++;
        }
        for (char ch : target.toCharArray()) {
            mapTarget[ch - 'a']++;
        }
        int ans = Integer.MAX_VALUE;
        //目标hash表，找需要比较的最小副本数
        for (int i = 0; i < mapTarget.length; i++) {
            if (mapTarget[i] != 0) ans = Math.min(ans, mapS[i] / mapTarget[i]);
        }
        return ans;
    }


}
