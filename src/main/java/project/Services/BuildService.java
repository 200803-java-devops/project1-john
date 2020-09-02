package project.Services;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuildService {

    public String mavenCompile(String execDirectory) throws IOException {
        ProcessBuilder pBuilder = new ProcessBuilder();
        pBuilder = pBuilder.directory(new File(execDirectory));
        pBuilder.command("cmd.exe", "/c", "mvn", "clean", "compile", "-q");
        Process process = pBuilder.start();
        StringBuilder output = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
        } catch (IOException e1) {
            System.err.println("BuildService.mavenCompile reader IO exception");
        }
        int exitCode = 1;
        try {
            exitCode = process.waitFor();
        } catch (InterruptedException e) {
            System.err.println("BuildService.mavenCompile process interrupted");
        }
        if(exitCode == 0){
            if(output.toString().equals("")){
                return "Build Success";
            }else{
                return output.toString();
            }
        }else{
            return output.toString();
        }
    }
}