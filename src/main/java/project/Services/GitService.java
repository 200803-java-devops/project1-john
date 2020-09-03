package project.Services;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class GitService {
    
    /**
     * Service to run terminal command to git clone provided repo, returns repo directory name if successful
     * @param gitRepo link to repository for clone command
     * @param execDirectory directory to execute commands in
     * @return
     * @throws IOException
     */
    public String gitClone(String gitRepo, String execDirectory) throws IOException {
        ProcessBuilder pBuilder = new ProcessBuilder();
        pBuilder = pBuilder.directory(new File(execDirectory));
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        String cmd = "git clone " + gitRepo;
        if(isWindows){
            pBuilder.command("cmd.exe", "/c", cmd);
        }else{
            pBuilder.command("sh", "-c", cmd);
        }
        
        Process process = pBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
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
        System.out.println(gitRepo);
        if(exitCode == 0){
            return gitRepo.substring(gitRepo.lastIndexOf("/")+1, gitRepo.lastIndexOf("."));
        }else if(exitCode==128){
            return output.toString();
        }else{
            return output.toString();
        }
    }
}