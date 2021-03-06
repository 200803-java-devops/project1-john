package project.Servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.Services.PackageService;

public class PackageServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    /**
     * Servlet that runs package service (mvn package) when receiving get request from appropriate button
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(this.getClass().getName());
        String remoteRepo = (String) req.getSession().getAttribute("remoteRepo");
        PackageService service = new PackageService();
        String output = "";  
        try {
            output = service.mavenPackage(new File(remoteRepo).getAbsolutePath());
        } catch (IOException e) {
            System.err.println("PackageServlet.doGet IO exception running maven package");
            System.err.println(e.toString());
        }
        try {
            resp.getWriter().println(output);
            logger.info(java.time.LocalTime.now() + " Package Service Called");
        } catch (IOException e) {
            System.err.println("PackageServlet.doGet IO exception on getWriter");
        }
    }

    @Override
    public void destroy() {
        System.out.println("Shutting down PacketServlet");
    }
}