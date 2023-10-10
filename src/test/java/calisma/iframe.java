package calisma;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class iframe extends TestBase {
    @Test
    public void iframe(){
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz

        driver.get("http://demo.guru99.com/test/guru99home/");
        WebElement cookies= driver.findElement(By.xpath("//iframe[@class='faktor-iframe-wrapper']"));
        driver.switchTo().frame(cookies);
        driver.findElement(By.xpath("//span[text()='Accept All']")).click();

        // 2) sayfadaki iframe sayısınıbulunuz.

        List<WebElement> iframeSayisiBul = driver.findElements(By.tagName("iframe"));
        System.out.println("Iframe sayisi : "+iframeSayisiBul.size());

        // 3) ilk iframe'deki (Youtube) play butonuna tıklayınız.

        WebElement IlkYoutube = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/RbSlW8jZFe8']"));
        driver.switchTo().frame(IlkYoutube);
        driver.findElement(By.xpath("//button[@ aria-label='Play']")).click();

        // 4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        // 5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız

        WebElement guru99 = driver.findElement(By.id("a077aa5e"));
        driver.switchTo().frame(guru99);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();


    }

}
