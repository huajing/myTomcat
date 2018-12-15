package c.c.k.servlet;

public abstract class MyServlet {
        public abstract void doGet(MyRequest request, MyResponse response);
        public abstract void doPost(MyRequest request, MyResponse response);
        public void doService(MyRequest request, MyResponse response){
            if(request.getMethod().equals("POST")){
                this.doPost(request, response);
            }else if(request.getMethod().equals("GET")){
                this.doGet(request, response);
            }else{
                System.out.println("method not support");
            }
        }
}
