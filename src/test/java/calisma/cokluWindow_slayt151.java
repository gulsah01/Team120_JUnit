package calisma;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class cokluWindow_slayt151 extends TestBase {
    public void test01() {


        //1."http://webdriveruniversity.com/" adresine gidin
        // 2."Login Portal" a  kadar asagi inin
        // 3."Login Portal" a tiklayin
        // 4.Diger window'a gecin
        // 5."username" ve  "password" kutularina deger yazdirin
        // 6."login" butonuna basin
        // 7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        // 8.Ok diyerek Popup'i kapatin
        // 9.Ilk sayfaya geri donun
        // 10.Ilk sayfaya donuldugunu test edin
    }
    @Test
    public void windowHanldleTest(){
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String ilkSayfaWhd= driver.getWindowHandle();
        //2."Login Portal" a kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']")).click();
        //4.Diger window'a gecin
            //Bir linke tikladigimizda biz newWindow() kullanmadigimiz halde yeni sayfa aciliyorsa
            //driver eski sayfada kalir ve yeni sayfada islem yapabilmek icin bizim driver'i yeni
             //.ayfaya gecirmemiz gerekmektedir.
                //bunun icin ise su adimlari izlememiz gerekir:
               //1- Ilk window’un window handle degerini kaydedin.
       // For-each loop ile set’deki window handle degerlerini kontrol edin, ilk sayfanin
        //window handle degerine esit olmayani ikinci sayfanin window handle degeri olarak
        //kaydedin.
        String ikinciSayfaWhd ="";
        Set<String> whdSeti = driver.getWindowHandles();
        for (String each:whdSeti
        ) {
            if (!each.equals(ilkSayfaWhd)){
                ikinciSayfaWhd =each;
            }
        }
        driver.switchTo().window(ikinciSayfaWhd);
        //5."username" ve "password" kutularina deger yazdirin
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        Faker faker = new Faker();
        actions.sendKeys(isimKutusu)
                .sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .perform();
        //6."login" butonuna basin
        driver.findElement(By.id("login-button")).click();
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedYazi = "validation failed";
        String actualYazi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi, actualYazi);
        //8.Ok diyerek Popup'i kapatin
       // Js alerts'e inspect yapilamaz, ekstra isleme ihtiyac vardir.
        driver.switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(ilkSayfaWhd);
        //10.Ilk sayfaya donuldugunu test edin
        String expectedTitle = "WebDriverUniversity.com";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

}