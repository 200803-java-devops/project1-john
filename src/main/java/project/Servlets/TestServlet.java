package project.Servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.Services.TestService;

public class TestServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

    /**
     * Servlet that runs test service (mvn test) when receiving a get request from appropriate button
     */
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        String remoteRepo = (String) req.getSession().getAttribute("remoteRepo");
        TestService service = new TestService();
        String output = "";  
        try {
            output = service.mavenTest(new File(remoteRepo).getAbsolutePath());
        } catch (IOException e) {
            System.err.println("TestServlet.doGet IO exception running maven compile");
            System.err.println(e.toString());
        }
        try {
            resp.getWriter().println(output);
        } catch (IOException e) {
            System.err.println("TestServlet.doGet IO exception on getWriter");
        }
    }
}
    