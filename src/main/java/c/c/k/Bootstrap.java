package c.c.k;

import c.c.k.tomcat.MyTomcatFactory;

public class Bootstrap {
    public static void main(String[] args) {
        try {
            MyTomcatFactory.getMyTomcat(1234).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
