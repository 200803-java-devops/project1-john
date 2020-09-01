package project.Services;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class GitService {
    
    public String gitClone(String gitRepo) throws IOException {
        ProcessBuilder pBuilder = new ProcessBuilder();
        pBuilder = pBuilder.directory(new File("."));
        pBuilder.command("cmd.exe", "/c", "git", "clone", gitRepo);
        Process process = pBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        boolean cloneSuccess = false;
        try {
            while ((line = reader.readLine()) != null) {
                if(line.substring(line.lastIndexOf(" ")+1).equals("done.")){
                    cloneSuccess = true;
                }
            }
        } catch (IOException e1) {
            System.err.println("gitservice.gitClone reader IO exception");
        }
        int exitCode = 1;
        try {
            exitCode = process.waitFor();
        } catch (InterruptedException e) {
            System.err.println("gitservice.gitClone process interrupted");
        }
        if(exitCode == 0){
            if(cloneSuccess == true){
                return gitRepo.substring(gitRepo.lastIndexOf("/")+1);
            }else{
                return "git clone did not work";
            }
        }else{
            return "failure";
        }
    }
}