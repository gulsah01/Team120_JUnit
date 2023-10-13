package calisma;

import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.K;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class slayt151 extends TestBase {
    @Test
    public void test01(){
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String ilkSayfaWhd =driver.getWindowHandle();

        // 2."Login Portal" a  kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // 3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']")).click();

        // 4.Diger window'a gecin
        String ikiciSayfaWhd ="";
        Set<String> whdSeti =driver.getWindowHandles();
        for (String each:whdSeti
             ) {
            if (!each.equals(ikiciSayfaWhd)){
                ikiciSayfaWhd=each;
            }
        }
        driver.switchTo().window(ikiciSayfaWhd);

        // 5."username" ve  "password" kutularina deger yazdirin
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        Faker faker=new Faker();
        actions.sendKeys(isimKutusu)
                .sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .perform();
bekle(2);
        // 6."login" butonuna basin
        driver.findElement(By.id("login-button")).click();

        // 7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedYazi= "validation failed";
        String actualYazi =driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        // 8.Ok diyerek Popup'i kapatin
         driver.switchTo().alert().accept();

        // 9.Ilk sayfaya geri donun
        driver.switchTo().window(ilkSayfaWhd);
bekle(2);
        // 10.Ilk sayfaya donuldugunu test edin
        String expectedUrl ="http://webdriveruniversity.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

    }
}
