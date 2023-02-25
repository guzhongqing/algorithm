package test;

class Test {
    static int temp = 1;

    public static void main(String[] args) {
        System.out.println(test());
        System.out.println(temp);//3
    }

    static int test() {
        try {
            System.out.println(temp);//1
            return ++temp;//++temp会执行，此时是2，如果finally没有return语句，则返回2
        } catch (Exception e) {//这里没有异常捕获
            System.out.println(temp);
            return ++temp;
        } finally {
            ++temp;
            System.out.println(temp);//3
            return 111;
        }
    }
}