package day11_fileTestleri_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_fileDownload extends TestBase {
    @Test
    public void indirmeTesti(){
       // /Users/gulsahsatilmis/Desktop/logo.jpg
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
       // 3. logo.jpg dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='logo.jpg']")).click();
       // 4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu ="/Users/gulsahsatilmis/Desktop/logo.jpg";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        bekle(2);
    }
}
