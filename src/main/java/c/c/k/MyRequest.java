package c.c.k;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyRequest {
    private String url;
    private String method;

    public MyRequest(InputStream inputStream) throws IOException {
        //通过输入流解析url和method
        String httpRequest = "";
        byte[] httpRequestBytes = new byte[1024];
        int length = 0;
        if((length = inputStream.read(httpRequestBytes)) > 0){
            httpRequest = new String(httpRequestBytes, 0, length);
        }

        String httpHead = httpRequest.split("\n")[0];
        url = httpHead.split("\\s")[1];
        method = httpHead.split("\\s")[0];
//        System.out.println("parse inputStream " + this + "  " + this.method + "  " + this.url);
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }
}
