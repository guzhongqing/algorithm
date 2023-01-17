
public class Test {

    public Test() {
        System.out.println("构造方法");
    }

    public Test(int a) {
        System.out.println(a);

    }

    public static void main(String[] args) {
        Test test = new Test();

        String a = "abc";
        String b = new String("abc");
        String c = "abc";
        int a1 = 1;
        Integer b2 = new Integer("1");
        System.out.println(a1 == b2);


        System.out.println(a == b);
        System.out.println(a == c);


    }


}

class StaticTest {

    int a = 110;    // 实例变量

    {
        System.out.println("构造(实例)代码块");
        System.out.println("a=" + a + ",b=" + b);

    }

    StaticTest() {
        System.out.println("构造(实例)方法");
        System.out.println("a=" + a + ",b=" + b);
    }


    public static void main(String[] args) {
        staticFunction();
        StaticTest st2 = new StaticTest();


    }

    public static void staticFunction() {
        System.out.println("静态方法");
    }

    static int b = 112;     // 静态变量


    static {
        System.out.println("静态代码块");
    }


    StaticTest st1 = new StaticTest();   //实例对象


}
