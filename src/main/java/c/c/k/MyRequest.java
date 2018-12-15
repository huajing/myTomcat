package c.c.k;

import java.io.InputStream;

public class MyRequest {
    private String url;
    private String method;

    public MyRequest(InputStream inputStream) throws Exception{

    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }
}
