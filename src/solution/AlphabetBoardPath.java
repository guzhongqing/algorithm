package solution;

/**
 * 1138. 字母板上的路径
 * https://leetcode.cn/problems/alphabet-board-path/
 * 中等
 * 模拟
 */
public class AlphabetBoardPath {

    public String alphabetBoardPath(String target) {
        int posx = 0, posy = 0;//当前位置
        StringBuilder ans = new StringBuilder();

        for (char ch : target.toCharArray()) {
            int desx = (ch - 'a') / 5;//当前行标，从0开始
            int desy = (ch - 'a') % 5;//当前列标，从0开始

            //当前在目标下方
            while (posx > desx) {
                ans.append("U");
                posx--;
            }
            //当前在目标右方
            while (posy > desy) {
                ans.append("L");
                posy--;
            }
            //当前在目标上方
            while (posx < desx) {
                ans.append("D");
                posx++;
            }
            //当前在目标做方
            while (posy < desy) {
                ans.append("R");
                posy++;
            }
            //此时当前到达目标
            ans.append("!");
        }
        return ans.toString();
    }

}
