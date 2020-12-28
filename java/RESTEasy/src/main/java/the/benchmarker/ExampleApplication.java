package the.benchmarker;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class ExampleApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(Main.class);
        return classes;
    }

}
