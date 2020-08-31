package project;

import java.io.File;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App {
    public static void main( String[] args ) {
        Tomcat server = new Tomcat();
        server.setBaseDir(new File("target/tomcat/").getAbsolutePath());
        server.setPort(8443);
        server.getConnector();
        server.addWebapp("/embed", new File("src/main/resources/").getAbsolutePath());
        server.addServlet("/embed", "BuildServlet", new BuildServlet()).addMapping("/build");
        server.addServlet("/embed", "TestServlet", new TestServlet()).addMapping("/test");
        server.addServlet("/embed", "PackageServlet", new PackageServlet()).addMapping("/package");
        try {
            server.start();
        } catch (LifecycleException e) {
            System.err.println("lifecycle exception on server start");
        }
    }
}
