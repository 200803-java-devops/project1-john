package project;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        try {
            resp.getWriter().println("Hello World");
        } catch (IOException e) {
            System.err.println("IO exception on printing hello world in hello servlet");
        }
    }

    @Override
    public void destroy() {
        System.out.println("Shutting down HelloServlet");
    }
}