package project.Servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.Services.BuildService;

public class BuildServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Servlet to run build service (mvn compile) when receiving get request from appropriate button
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(this.getClass().getName());
        String remoteRepo = (String) req.getSession().getAttribute("remoteRepo");
        BuildService service = new BuildService();
        String output = "";  
        try {
            output = service.mavenCompile(new File(remoteRepo).getAbsolutePath());
        } catch (IOException e) {
            System.err.println("BuildServlet.doGet IO exception running maven compile");
            System.err.println(e.toString());
        }
        try {
            resp.getWriter().println(output);
            logger.info(java.time.LocalTime.now() + " Build Service Called");
        } catch (IOException e) {
            System.err.println("BuildServlet.doGet IO exception on getWriter");
        }
    }

    @Override
    public void destroy() {
        System.out.println("Shutting down BuildServlet");
    }
}