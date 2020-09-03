package project.Services;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestService {
    
    /**
     * Service that runs maven test terminal command
     * @param execDirectory directory of maven project
     * @return
     * @throws IOException
     */
    public String mavenTest(String execDirectory) throws IOException {
        ProcessBuilder pBuilder = new ProcessBuilder();
        pBuilder = pBuilder.directory(new File(execDirectory));
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        if(isWindows){
            pBuilder.command("cmd.exe", "/c", "mvn", "compile", "test", "-q");
        }else{
            pBuilder.command("sh", "-c", "mvn", "compile", "test", "-q");
        }
        Process process = pBuilder.start();
        StringBuilder output = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
        } catch (IOException e1) {
            System.err.println("TestService.mavenTest reader IO exception");
        }
        int exitCode = 1;
        try {
            exitCode = process.waitFor();
        } catch (InterruptedException e) {
            System.err.println("TestService.mavenTest process interrupted");
        }
        if(exitCode == 0){
            if(output.toString().equals("")){
                return "Tests Successful";
            }else{
                return output.toString();
            }
        }else{
            return output.toString();
        }
    }
}