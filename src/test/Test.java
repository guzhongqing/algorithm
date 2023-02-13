package test;


class Test {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.toString();

        String s = "hello";
        char[] chars = new char[10];
        s.getChars(0, s.length(), chars, 3);
        System.out.println(chars);
    }

}



