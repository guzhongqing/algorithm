package string;

/**
 * 2042. 检查句子中的数字是否递增
 * https://leetcode.cn/problems/check-if-numbers-are-ascending-in-a-sentence/
 * 字符串转整数
 */
public class AreNumbersAscending {

    public static void main(String[] args) {

        boolean b = areNumbersAscending("4 5 11 26");
        boolean c = areNumbersAscending("sunset is at 07 51 pm overnight lows will be in the low 50 and 60 s");
        System.out.println(c);
    }

    //API调用
    public static boolean areNumbersAscending(String s) {
        int preNum = 0;
        for (String str : s.split(" ")) {
            try {
                int num = Integer.parseInt(str);//此API中传入的str若格式不是整数(前导0也可以被解析),则会抛出异常,自己捕获异常接着下一个str
                if (num > preNum) preNum = num;
                else return false;
            } catch (NumberFormatException ignored) {
            }
        }
        return true;
    }


    //转换成charArray,从头开始p判断

    public boolean toCharArray(String s) {
        int lastNum = 0;
        int currentNum = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                currentNum = currentNum * 10 + c - '0';
            }
            if (c == ' ' && currentNum != 0) {
                if (currentNum > lastNum) {
                    lastNum = currentNum;
                    currentNum = 0;
                } else {
                    return false;
                }
            }
        }
        if (currentNum != 0 && currentNum <= lastNum) {
            return false;
        }
        return true;
    }


}
