package qa_guru_workWithFile;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class XlsTest {

    @Test
    public void simpleXlsTest() throws IOException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("diplom.xlsx");
        assert stream != null;
        XLS xlsFile = new XLS(stream);
        // берём данные из 1 таблицы, 2 строки, 1 столбеца
        String stringCellValue = xlsFile.excel.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
        assertTrue(stringCellValue.contains("1. Почему практики тест-дизайна нельзя применять сразу после получения требований?"));
    }
}
