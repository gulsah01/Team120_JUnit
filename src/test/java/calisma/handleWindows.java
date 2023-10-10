package calisma;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class handleWindows extends TestBase {
    @Test
    public void test01() {

        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String ilkSayfaWhd= driver.getWindowHandle();

        // 2."Login Portal" a  kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // 3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']")).click();
bekle(2);
        // 4.Diger window'a gecin
        String ikinciSayfaWhd ="";
        Set<String> whdSeti =driver.getWindowHandles();
        for (String each:whdSeti
             ) {
            if (!each.equals(ilkSayfaWhd)){
                ikinciSayfaWhd=each;
            }
        }
        driver.switchTo().window(ikinciSayfaWhd);
        bekle(2);

        // 5."username" ve  "password" kutularina deger yazdirin
        driver.findElement(By.xpath("//input[@placeholder='Username']"));
        Faker faker=new Faker();
        actions.sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .perform();
        bekle(2);
        // 6."login" butonuna basin
        driver.findElement(By.xpath("//button[@id='login-button']")).click();

        // 7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedYazi = "validation failed";
        String actualyazi =driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualyazi);
bekle(2);
        // 8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        // 9.Ilk sayfaya geri donun
        driver.switchTo().window(ilkSayfaWhd);
bekle(2);
        // 10.Ilk sayfaya donuldugunu test edin
        String expectedUrl ="http://webdriveruniversity.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);




    }
}