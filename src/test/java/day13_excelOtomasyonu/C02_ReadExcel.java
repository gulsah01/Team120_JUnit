package day13_excelOtomasyonu;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void test01() throws IOException {
        //ilgili ayarlari yapip workbook'u olusturun
        String dosyaYolu ="day13_excelOtomasyonu/ulkeler.xlsx";
        FileInputStream fis= new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        //2. sayfaya gidin

        // kullanilan en son satirin 24. satir oldugunu test edin

        //fiziki kullanilan satir sayiisnin 8 oldugunu test edin

        int expectedFizikiSatirSayisi =8;





    }
}
