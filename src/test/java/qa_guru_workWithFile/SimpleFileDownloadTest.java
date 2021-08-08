package qa_guru_workWithFile;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleFileDownloadTest {

    //static final String PATH_TO_DWD = "downloads";

    //@AfterAll
    /*//для очистки папки downloads после теста
    static void releaseFiles() throws IOException {
        FileUtils.cleanDirectory((new File(PATH_TO_DWD)));
    } */

    @Test
    public void  simpleDownload() throws Exception {
        //если скачивать файлы в свою директорию, то потом добавить в  @AfterAll   очистку директории
        //Configuration.downloadsFolder = PATH_TO_DWD;

        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File downloadedFile = $("#raw-url").download(); //если у кнопки скачать - href

        //"прочитать" файл Java методом - представить в виде строки
        String s;
        try (InputStream is = new FileInputStream(downloadedFile)) {
            s = new String(is.readAllBytes(), "UTF-8");
        }
        // ещё или "прочитать" файл с помощью selenide
        String s1 = FileUtils.readFileToString(downloadedFile, "UTF-8");

        Assertions.assertTrue(s1.contains("This repository is the home of the next generation of JUnit"));


    }
}
