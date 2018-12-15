package c.c.k;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.io.InputStream;

public class MyRequest {
    private String url;
    private String method;

    public MyRequest(InputStream inputStream) throws IOException {
        //通过输入流解析url和method
        url = "/findGirl";
        method = "GET";
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }
}
