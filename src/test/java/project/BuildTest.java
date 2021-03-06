package project;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import project.Services.BuildService;

public class BuildTest {

    @Test
    public void buildServiceTest() throws IOException {
        BuildService service = new BuildService();
        String output = "";
        String expected = "Build Success";
        output = service.mavenCompile(new File("testRepo/Project0-John").getAbsolutePath());
        assertTrue(expected.equals(output));
    }
}