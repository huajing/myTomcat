package c.c.k.tomcat;

public class MyTomcatFactory {
    public static MyTomcat getMyTomcat(int port){
        return new MyTomcatNIO(port);
    }
}
