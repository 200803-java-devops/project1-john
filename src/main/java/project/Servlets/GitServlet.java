package project.Servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.Services.GitService;

public class GitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        GitService gitGet = new GitService();
        String repo = req.getParameter("Github Repo");
        String remoteRepo = "";
        try {
            remoteRepo = gitGet.gitClone(repo);
        } catch (IOException e) {
            System.out.println("GitServlet IO exception on git clone");
        }
        System.out.println(remoteRepo);
    }
}