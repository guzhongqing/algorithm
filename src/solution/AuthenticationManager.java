package solution;


import java.util.HashMap;
import java.util.Map;

/**
 * 1797. 设计一个验证系统
 * https://leetcode.cn/problems/design-authentication-manager/
 * 中等
 * 哈希表
 */
public class AuthenticationManager {
    int timeToLive;
    Map<String, Integer> map;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.map = new HashMap<String, Integer>();
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if (map.getOrDefault(tokenId, 0) > currentTime) {
            map.put(tokenId, currentTime + timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int res = 0;
        for (int time : map.values()) {
            if (time > currentTime) {
                res++;
            }
        }
        return res;
    }
}
