package project;

import java.io.File;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App {
    public static void main( String[] args ) throws LifecycleException {
        Tomcat server = new Tomcat();
        server.setBaseDir(new File("project/target/tomcat/").getAbsolutePath());
        server.setPort(8443);
        server.getConnector();
        server.addWebapp("/embed", new File("project/src/main/resources/").getAbsolutePath());
        server.addServlet("/embed", "HelloServlet", new HelloServlet()).addMapping("/hello");
        server.start();
    }
}
