package calisma;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class tekrar extends TestBase {
    @Test
    public void test01(){
//1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        //2. “Our Products” butonuna basin
        WebElement ourProductIframe= driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(ourProductIframe);
        driver.findElement(By.partialLinkText("Our Products")).click();

        //3. “Cameras product”i tiklayin
        driver.findElement(By.xpath("//p[text()='Cameras']")).click();
        bekle(2);

        //4. Popup mesajini yazdirin
        String popUpMesaji =driver.findElement(By.xpath("//h4")).getText();
        System.out.println("PopUp mesaji : "+popUpMesaji);
        bekle(2);

        //5. “close” butonuna basin
        driver.findElement(By.xpath("//button[text()='Close']")).click();

        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("WebdriverUniversity.com (IFrame)")).click();

        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin

        String expectedUrl ="http://webdriveruniversity.com/index.html";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

    }
}
