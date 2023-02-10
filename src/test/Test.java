package test;

class Test {

    int a=1;//a和1都在堆
    String S=new String("hello");//S和new String("hello")出来的对象都在堆

    public static void main(String[] args) {
        int i=1;//i和1在都栈中
        String name="gzq";//引用在栈，对象在堆中的常量区
    }
}


