package project.Servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.Services.GitService;

public class GitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GitService gitGet = new GitService();
        String repo = req.getParameter("repo");
        String remoteRepo = "";
        try {
            remoteRepo = gitGet.gitClone(repo, new File(".").getAbsolutePath());
        } catch (IOException e) {
            System.out.println("GitServlet IO exception on git clone");
        }
        System.out.println(remoteRepo);
    }
}