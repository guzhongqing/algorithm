package solution;

public class Add36Strings {
    public int getInt(char ch) {
        if (ch >= '0' && ch <= '9')
            return ch - '0';
        else return ch - 'a' + 10;
    }

    public char getChar(int n) {
        if (n < 9)
            return (char) (n + '0');
        else return (char) (n - 10 + 'a');

    }

    public String addStrings(String num1, String num2) {
        StringBuffer ans = new StringBuffer();
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        while (i >= 0 || j >= 0 || add == 1) {
            int x = i >= 0 ? getInt(num1.charAt(i--)) : 0;
            int y = j >= 0 ? getInt(num2.charAt(j--)) : 0;
            int res = x + y + add;
            ans.append(getChar(res % 36));//把10-36的字符转换成a-z
            add = res / 36;
        }
        return ans.reverse().toString();
    }
}
