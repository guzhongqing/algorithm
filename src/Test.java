
public class Test {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("继承");
            }
        };
        thread.start();

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("实现");
            }
        });

        thread.start();

    }
}


