package qa_guru_workWithFile;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PdfTest {

    @Test
    void junitPdfTest() throws IOException {
        Selenide.open("https://github.com/Afonja84/qa_guru_7_work_with_File/blob/master/src/test/resources/resume.pdf");
        File pdfDownloadedFile = $("#raw-url").download();
        PDF parsedPdf = new PDF(pdfDownloadedFile);
        assertTrue(parsedPdf.text.contains("Усатенко"));
    }
}
