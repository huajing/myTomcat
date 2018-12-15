package c.c.k;

import java.util.ArrayList;
import java.util.List;

public class ServletMappingConfig {
    public static final List<ServletMapping> servlectMappingList = new ArrayList<ServletMapping>();
    static {
        servlectMappingList.add(new ServletMapping("find", "/find", "clazz"));
        servlectMappingList.add(new ServletMapping("find", "/find", "clazz"));
    }
}
