package solution;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuffer ans = new StringBuffer();
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        while (i >= 0 || j >= 0 || add == 1) {
            int x = i >= 0 ? num1.charAt(i--) - '0' : 0;//默认以int存储减‘0’是为了与数字0对应
            int y = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int res = x + y + add;
            ans.append(res % 10);//append重载了不同类型返回StringBuffer类
            add = res / 10;
        }
        return ans.reverse().toString();
    }
}
