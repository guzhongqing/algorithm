package TestFun;

public class Expressiontype {
    public static void main(String[] args) {

        int a = 97;
        char b = 'a';

        int c = 'a';
        char d = 97;

        char e = 97 + 'a';
        int f = 97 + 'a';

        int x = a + 'a';//表达式类型自动提升
        char y = (char) (a + 'a');//强制转换
        char c1= (char) (b+d);

        byte b1=4,b2=4;
        byte b3= (byte) (b1+b2);

        int i2=b2+b;
        char c2= (char) (b2+b);//byte,short,char类型变量在表达式中会自动提升到int类型
        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f);
    }
}
