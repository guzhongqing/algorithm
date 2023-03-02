package test;

class Test {
    public static void main(String[] args) {
        int a = A.num2;//调用静态变量JVM执行invokestatic指令
        A.num1 = 1;//静态变量赋值JVM执行putstatic指令
        A.func();//调用静态方法JVM执行invokestatic指令
    }
}

class A {
    public B b = new B();

    {
        System.out.println("A的构造代码块");
    }

    public A() {
        System.out.println("A的无参构造");
    }

    static {
        System.out.println("A的静态代码块");
    }

    public static int num1;
    public static int num2 = 2;

    public static void func() {
        System.out.println("A的静态方法");
    }
}

class B {
    public B() {
        System.out.println("B的构造方法");
    }
}