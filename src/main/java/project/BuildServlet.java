package project;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuildServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        BuildService service = new BuildService();
        String output = "";  
        try {
            output = service.mavenCompile(new File("project").getAbsolutePath());
        } catch (IOException e) {
            System.err.println("BuildServlet.doGet IO exception running maven compile");
            System.err.println(e.toString());
        }
        try {
            resp.getWriter().println(output);
        } catch (IOException e) {
            System.err.println("BuildServlet.doGet IO exception on getWriter");
        }
    }

    @Override
    public void destroy() {
        System.out.println("Shutting down BuildServlet");
    }
}