//package qa_guru_workWithFile;
//
//import org.apache.commons.io.IOUtils;
//import org.junit.jupiter.api.Test;
//
//import java.io.InputStream;
//import java.nio.charset.StandardCharsets;
//import java.util.zip.ZipInputStream;
//
//import static com.codeborne.pdftest.assertj.Assertions.assertThat;
//
//
//public class ArhivTest {
//
//    static final String  PASSWORD = "123";
//    static final String UNZIP_FILE_PATH = "unzip";
//    static final String UNZIPPED_FILE_PATH = "./unzip/TestTxtFile.txt";
//
//    @Test
//    public void zipResourcesTest() throws Exception {
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        InputStream stream = classLoader.getResourceAsStream("arhivetest.zip");
//        String entryAsString = null;
//        assert stream != null;
//        try (ZipInputStream zipInputStream = new ZipInputStream(stream, StandardCharsets.UTF_8)) {
//            while ((zipInputStream.getNextEntry()) != null) {
//                entryAsString = IOUtils.toString(zipInputStream, StandardCharsets.UTF_8);
//            }
//        }
//        assertThat(entryAsString).contains("Hello World");
//    }
//
//}
