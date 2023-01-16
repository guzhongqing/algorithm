package doublePointer;

/**
 * 剑指 Offer 05. 替换空格
 * https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
 * 简单
 * 双指针,replace
 */
public class ReplaceSpace {

    //双指针，从后向前填充，从后向前填充元素，避免了从前向后填充元素时，每次添加元素都要将添加元素之后的所有元素向后移动的问题。
    public String replaceSpace(String s) {

        //准备需要给原字符串扩容的字符串
        StringBuilder str = new StringBuilder();

        //每一个有空格，就给扩容字符串加入两个空格
        for (char c : s.toCharArray()) {
            if (c == ' ') str.append("  ");
        }
        int left = s.length() - 1;//左指针指向原字符串最后一个位置
        s += str;//对原字符串进行扩容
        int right = s.length() - 1;//右指针指向扩容后字符串最后一个位置
        char[] ans = s.toCharArray();
        for (; left >= 0; left--, right--) {
            if (ans[left] == ' ') {
                ans[right--] = '0';
                ans[right--] = '2';
                ans[right] = '%';
            } else ans[right] = ans[left];
        }
        return new String(ans);

    }


    //字符数组
    public String chars(String s) {
        //s最多每个位置都是空格，然后每个空格变成三个字符
        char[] ans = new char[s.length() * 3];
        //定义字符数组长度指针，并初始化0
        int size = 0;

        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                ans[size++] = '%';
                ans[size++] = '2';
                ans[size++] = '0';
            } else ans[size++] = ch;
        }

        //把字符数组转化为字符串指定长度字符串
        return new String(ans, 0, size);
    }


    //StringBuilder
    public String builder(String s) {
        StringBuilder ans = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') ans.append("%20");
            else ans.append(ch);
        }
        return ans.toString();
    }

    //直接使用API
    public String API(String s) {
        return s.replace(" ", "%20");
    }


}
