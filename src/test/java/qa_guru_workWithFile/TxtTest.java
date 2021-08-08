package qa_guru_workWithFile;

import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TxtTest {

        @Test
        public void simpleTxtTest() throws IOException {

            String s;
            try (InputStream is = new FileInputStream("./src/test/resources/test.txt")) {
                s = new String(is.readAllBytes(), "UTF-8");
            }
            assertTrue(s.contains("Hello World"));
        }
    }

