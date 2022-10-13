import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 *
 * @author dan
 */
public class MainTest {
    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testMain() {
        System.out.println("main testing :)");
        String[] args = null;

        // Start capturing
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));

        Main.main(args);

        // Stop capturing
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

        // Use captured content
        String content = buffer.toString();
        assertTrue(content.contains("Welcome to the lecture management..."));
        assertTrue(content.contains("Computer Science:\n\tProgramming 3"));

        buffer.reset();
        System.out.println("Testing complete");
    }

}