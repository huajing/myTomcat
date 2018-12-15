package c.c.k;

import c.c.k.tomcat.MyTomcatBIO;

public class Bootstrap {
    public static void main(String[] args) {
        new MyTomcatBIO(1234).start();
    }
}
