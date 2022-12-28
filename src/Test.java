public class Test {


    public static void main(String[] args) {
        test();


        StringBuffer a = new StringBuffer("A");

        StringBuffer b = new StringBuffer("B");

        operate(a, b);

        System.out.println(a + "." + b);
    }

    static void operate(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = new StringBuffer("str");
    }

    static void test() {
        //8位二进制补码的范围:-128~127,其中-128没有原码和反码，并规定-128的补码[1000 0000]
        //计算机中按照补码存储，正数的补码等于原码，负数的补码等于反码+1，反码等于原码除符号位按位取反
        //1byte 127的补码:[0111 1111] -127的补码:[1000 0001] -128的补码[1000 0000]  -1的补码[1111 1111]，二进制的加减基于补码运算
        byte b = (byte) 129;
        byte c = (byte) 128;
        System.out.println(b);
        System.out.println(c);

    }

}
