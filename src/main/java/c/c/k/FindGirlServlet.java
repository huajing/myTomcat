package c.c.k;

import java.io.IOException;

public class FindGirlServlet extends MyServlet {
    @Override
    public void doGet(MyRequest request, MyResponse response) {
        try {
            response.write("doGet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) {
        try {
            response.write("doPOst");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doService(MyRequest request, MyResponse response) {
        super.doService(request, response);
    }
}
