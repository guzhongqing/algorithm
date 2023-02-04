package test;

import java.net.MalformedURLException;
import java.net.URL;

public class Test {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.baidu.comsdfsdfsd");

    }

    public static int pailouti(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n >= 3) return pailouti(n - 2) + pailouti(n - 1);
        return n;
    }


}


