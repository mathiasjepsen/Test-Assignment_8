package assignment_8_web;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Lovro
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(assignment_8_web.PizzaResource.class);
    }
    
}