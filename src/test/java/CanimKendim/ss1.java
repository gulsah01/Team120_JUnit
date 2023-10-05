package CanimKendim;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class ss1 extends TestBase {
@Test
    public void test01(){
    //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    //   cikarsa cookies kabul edin
        driver.get("http://demo.guru99.com/test/guru99home/");
        WebElement iframe= driver.findElement(By.id("gdpr-consent-notice"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@id='save']")).click();


    //2) sayfadaki iframe sayısını bulunuz.
   List<WebElement> iframeSayisi=driver.findElements(By.tagName("iframe"));
    System.out.println("Iframe sayisi: "+ iframeSayisi.size());

    //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    WebElement youtubeIframe= driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/RbSlW8jZFe8']"));
    driver.switchTo().frame(youtubeIframe);
    driver.findElement(By.xpath("//button[@aria-label='Play']")).click();

    //4) ilk iframe'den çıkıp ana sayfaya dönünüz
    driver.switchTo().defaultContent();

    //5) ikinci iframe'deki (Jmeter Made Easy) linke
    //   (https://www.guru99.com/live-selenium-project.html) tıklayınız

    WebElement JmeterIframe =driver.findElement(By.xpath("//iframe[@src='ads.html']"));
    driver.switchTo().frame(JmeterIframe);
    driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
}}

