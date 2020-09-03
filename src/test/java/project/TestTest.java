package project;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import project.Services.TestService;

public class TestTest {

    @Test
    public void testServiceTest() throws IOException {
        TestService service = new TestService();
        String output = "";
        String expected = "Tests Successful";
        output = service.mavenTest(new File("testRepo/Project0-John").getAbsolutePath());
        assertTrue(expected.equals(output));
    }
}
