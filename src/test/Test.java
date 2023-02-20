package test;


class Test {

    public static void main(String[] args) {
        char a = '中';
        System.out.println(a);
    }


}

class Vehicle {
    void run() {
        System.out.println("Vehicle");
    }
}

class Car extends Vehicle {
    public static void main(String[] args) {
        new Car().run();
    }

    final void run() {
        System.out.println("Car");
    }
}






