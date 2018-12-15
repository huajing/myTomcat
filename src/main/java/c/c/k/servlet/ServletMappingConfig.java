package c.c.k.servlet;

import c.c.k.servlet.FindGirlServlet;
import c.c.k.servlet.ServletMapping;

import java.util.ArrayList;
import java.util.List;

public class ServletMappingConfig {
    public static final List<ServletMapping> servlectMappingList = new ArrayList<ServletMapping>();
    static {
        servlectMappingList.add(new ServletMapping("find", "/findGirl", FindGirlServlet.class.getName()));
    }
}
