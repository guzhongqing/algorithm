package test;

class Test {
    public static void main(String[] args) {
        long totalMemory = Runtime.getRuntime().totalMemory();//初始化堆内存
        long maxMemory = Runtime.getRuntime().maxMemory();//最大堆内存
        System.out.println(totalMemory + "B   " + totalMemory / 1024 / 1024 + "MB");
        System.out.println(maxMemory + "B   " + maxMemory / 1024 / 1024 + "MB");
        int[] ints = new int[(int) 2e9];


        //HotSpot VM 参数:
        // -Xms1024m -Xmx10240m -XX:+PrintGCDetails
    }


}


