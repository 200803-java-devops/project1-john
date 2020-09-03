package project;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import project.Services.PackageService;

public class PackageTest {

    @Test
    public void packageServiceTest() throws IOException {
        PackageService service = new PackageService();
        String output = "";
        String expected = "Package Successful";
        output = service.mavenPackage(new File("testRepo/Project0-John").getAbsolutePath());
        assertTrue(expected.equals(output));
    }
    
}
