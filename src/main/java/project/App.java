package project;

import java.io.File;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import project.Servlets.BuildServlet;
import project.Servlets.GitServlet;
import project.Servlets.PackageServlet;
import project.Servlets.TestServlet;

public class App {
    public static void main( String[] args ) {
        Tomcat server = new Tomcat();
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger("Server Main");
        server.setPort(8443);
        server.getConnector();
        server.addWebapp("/jstib", new File("./").getAbsolutePath());
        server.addServlet("/jstib", "BuildServlet", new BuildServlet()).addMapping("/build");
        server.addServlet("/jstib", "TestServlet", new TestServlet()).addMapping("/test");
        server.addServlet("/jstib", "PackageServlet", new PackageServlet()).addMapping("/package");
        server.addServlet("/jstib", "GitServlet", new GitServlet()).addMapping("/git");
        try {
            logger.info("Starting Server");
            server.start();
        } catch (LifecycleException e) {
            System.err.println("lifecycle exception on server start");
        }
    }
}
