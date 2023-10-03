package calisma;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class soru1 extends TestBase {

    @Test
    public void test01(){
        // 1.   http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        // 2.   Sign in butonuna basin
WebElement isimKutusu =driver.findElement(By.xpath("signin_button"));
isimKutusu.click();
        // 3.   Login kutusuna “username” yazin
        Faker faker =new Faker();

        // 4.   Password kutusuna “password” yazin
        // 5. Sign in tusuna basin, back tusuna basarak sayfaya donun
        // 6. Online banking menusunden Pay Bills sayfasina gidin
        //7. “Purchase Foreign Currency” tusuna basin
        //8. “Currency” drop down menusunden Eurozone’u secin
        //9. “amount” kutusuna bir sayi girin
        //10. “US Dollars” in secilmedigini test edin
        //11. “Selected currency” butonunu secin
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.

    }
}
