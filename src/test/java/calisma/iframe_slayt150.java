package calisma;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class iframe_slayt150 extends TestBase {
    //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
    //2. “Our Products” butonuna basin
    //3. “Cameras product”i tiklayin
    //4. Popup mesajini yazdirin
    //5. “close” butonuna basin
    //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
    //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
    @Test
    public void iframeHandleTest(){
        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        //2. “Our Products” butonuna basin
        WebElement ourProductIframe = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(ourProductIframe);
        driver.findElement(By.linkText("Our Products")).click();

        //3. “Cameras product”i tiklayin
        driver.findElement(By.xpath("//p[text()='Cameras']")).click();
        bekle(2);

        //4. Popup mesajini yazdirin
        String popUpMesaji = driver.findElement(By.xpath("//h4")).getText();
        System.out.println("Popup mesaj icerigi : " + popUpMesaji);
        bekle(2);

        //5. “close” butonuna basin
        driver.findElement(By.xpath("//button[text()='Close']")).click();

        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("WebdriverUniversity.com (IFrame)")).click();

        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedTitle = "WebDriverUniversity.com";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }



}