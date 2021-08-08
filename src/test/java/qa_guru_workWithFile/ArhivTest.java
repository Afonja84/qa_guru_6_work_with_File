package qa_guru_workWithFile;

import net.lingala.zip4j.ZipFile;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipInputStream;

public class ArhivTest {

    private static final String ZIP_FILE = "./src/test/resources/arhiveWithPassword.zip";
    private static final String DOC_FILE = "./src/test/resources/unzip.doc";
    private static final String PASSWORD = "123";

    @Test
    public void arhiveWithoutPasswordTest() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("arhivetest.zip");
        String entryAsString = null;
        assert stream != null;
        try (ZipInputStream zipInputStream = new ZipInputStream(stream, StandardCharsets.UTF_8)) {
            while ((zipInputStream.getNextEntry()) != null) {
                entryAsString = IOUtils.toString(zipInputStream, StandardCharsets.UTF_8);
            }
        }
        Assertions.assertTrue(entryAsString.contains("Hello World"));
    }

    @Test
    void arhiveWithPasswordTest() throws IOException {
        String zipFilePath = "./src/test/resources/arhiveWithPassword.zip";
        String unzipFolderPath = "./src/test/resources";
        String zipPassword = "123";
        String unzipTxtFilePath = "./src/test/resources/unzip_txt.txt";

        ZipFile zipFile = new ZipFile(zipFilePath);
        if (zipFile.isEncrypted()) {
            zipFile.setPassword(zipPassword.toCharArray());
        }
        zipFile.extractAll(unzipFolderPath);

        String fileContent = FileUtils.readFileToString(FileUtils
                .getFile(unzipTxtFilePath), "UTF-8");

        Assertions.assertTrue(fileContent.contains("Hello"));
    }
}



