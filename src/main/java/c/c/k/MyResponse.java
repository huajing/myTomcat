package c.c.k;

import java.io.IOException;
import java.io.OutputStream;

public class MyResponse {
    private OutputStream outputStream;

    public MyResponse(OutputStream outputStream){
        this.outputStream = outputStream;
    }

    public void write(String content) throws IOException {
//        outputStream.write(content.getBytes());
    }
}
