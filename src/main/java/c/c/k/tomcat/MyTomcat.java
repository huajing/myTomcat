package c.c.k.tomcat;

import c.c.k.servlet.*;

import java.util.HashMap;
import java.util.Map;

public abstract class MyTomcat {
    protected int port;
    private Map<String, String> urlServletMap = new HashMap<String, String>();

    public void initServletMapping(){
        for(ServletMapping servletMapping : ServletMappingConfig.servlectMappingList){
            urlServletMap.put(servletMapping.getUrl(), servletMapping.getClazz());
        }
    }

    public void start() throws Exception{
        this.initServletMapping();
    }

    public void dispatch(MyRequest request, MyResponse response){
        try {
            String clazz = urlServletMap.get(request.getUrl());
            if(clazz != null){
                Class<MyServlet> myServletClass =  (Class<MyServlet>) Class.forName(clazz);
                MyServlet myServlet = myServletClass.newInstance();
                myServlet.doService(request, response);
            }else {
                System.out.println(request.getUrl() + " not find clazz");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
