package c.c.k.tomcat;

import c.c.k.servlet.MyRequest;
import c.c.k.servlet.MyResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyTomcatBIO extends MyTomcat{
    public MyTomcatBIO(int port){
        this.port = port;
    }

    public void start()  throws Exception{
        super.start();

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

                if(!request.getUrl().equals("/favicon.ico")){
                    this.dispatch(request, response);
                }
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


}
