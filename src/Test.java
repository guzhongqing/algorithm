
public abstract class Test {

    public static void main(String[] args) {
        System.out.println("Test.main");


    }

    public abstract void run();

    final void a() {

    }


}

class A extends Test {
    final int a;
    int b = 2;

    final void a(int a) {


    }

    A() {
        this.a();
        a = 0;
    }

    public static void main(String[] args) {
        new A().run();


    }

    @Override
    public void run() {

    }

    private final class inner {
        int a = 1;

        void run() {
            System.out.println(a);
            System.out.println(b);
        }
    }

}



