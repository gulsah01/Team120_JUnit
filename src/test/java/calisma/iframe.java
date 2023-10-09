package calisma;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class iframe extends TestBase {
    @Test
    public void iframe(){
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
       // WebElement cookies= driver.findElement(By.xpath());
        // 2) sayfadaki iframe sayısınıbulunuz.

        // 3) ilk iframe'deki (Youtube) play butonuna tıklayınız.

        // 4) ilk iframe'den çıkıp ana sayfaya dönünüz

        // 5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız
    }

}
