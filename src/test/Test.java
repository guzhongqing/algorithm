package test;

import java.nio.charset.Charset;
import java.util.Arrays;

class Test {
    public static void main(String[] args) {
        //默认字符集
        System.out.println(Charset.defaultCharset().name());

        //编码
        byte[] StrToBytes = "字符串".getBytes();
        System.out.println(Arrays.toString(StrToBytes));

        //解码
        String s = new String(StrToBytes);
        System.out.println(s);
    }
}


