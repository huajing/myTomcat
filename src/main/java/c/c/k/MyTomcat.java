package c.c.k;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MyTomcat {
    private int port;
    private Map<String, String> urlServletMap = new HashMap<String, String>();

    public MyTomcat(int port){
        this.port = port;
    }

    public void start(){
        this.initServletMapping();

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Mytomcat is start...");
            while (true){
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                MyRequest request = new MyRequest(inputStream);
                MyResponse response = new MyResponse(outputStream);

                this.dispatch(request, response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void initServletMapping(){
        for(ServletMapping servletMapping : ServletMappingConfig.servlectMappingList){
            urlServletMap.put(servletMapping.getUrl(), servletMapping.getClazz());
        }
    }

    public void dispatch(MyRequest request, MyResponse response){
        try {
            String clazz = urlServletMap.get(request.getUrl());
            Class<MyServlet> myServletClass =  (Class<MyServlet>) Class.forName(clazz);
            MyServlet myServlet = myServletClass.newInstance();
            myServlet.doService(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
