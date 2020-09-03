package project.Servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.Services.GitService;

public class GitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Servlet post that takes user provided repo link and runs git clone service
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        GitService gitGet = new GitService();
        String repo = req.getParameter("repo");
        String remoteRepo = "";
        try {
            remoteRepo = gitGet.gitClone(repo, new File(".").getAbsolutePath());
        } catch (IOException e) {
            System.out.println("GitServlet IO exception on git clone");
        }
        req.getSession().setAttribute("remoteRepo", remoteRepo);
        RequestDispatcher rd = req.getRequestDispatcher("commands.html");
        try {
            rd.include(req, resp);
        } catch (ServletException e) {
            System.out.println("GitServlet post servlet exception");
        } catch (IOException e) {
            System.out.println("GitServlet post IO exception");
        }
    }
}