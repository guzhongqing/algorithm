public class Test {

    public Test() {
        System.out.println("aaaa");

    }

    public static void main(String[] args) {

        byte b = 42;
        short s = 42;
        char c = 42;
        int i = 42;
        long l = 42L;
        float f = 42F;
        double d = 42D;

        System.out.println(b == s);//true,b转型为int，s转型为int，相等
        System.out.println(c == d);//true，c转型为double，相等
        System.out.println(i == l);//true，i转型为long，相等

        b = (byte) (b + b);
        b += b;//这里将结果int自动强转为byte，相当于加了(byte)
        c = (char) (s + c);
        l += f;//这里将结果float自动强转为long，相当于加了(float)


    }


}


