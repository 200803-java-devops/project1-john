package project.Services;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class GitService {
    
    public String gitClone(String gitRepo, String execDirectory) throws IOException {
        ProcessBuilder pBuilder = new ProcessBuilder();
        pBuilder = pBuilder.directory(new File(execDirectory));
        pBuilder.command("cmd.exe", "/c", "git", "clone", gitRepo);
        Process process = pBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
                System.out.println(line);
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
            return gitRepo.substring(gitRepo.lastIndexOf("/")+1, gitRepo.lastIndexOf("."));
        }else{
            return Integer.toString(exitCode);
        }
    }
}