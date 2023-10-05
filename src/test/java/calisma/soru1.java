package calisma;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class soru1 extends TestBase {

    @Test
    public void test01(){
        // 1.   http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        // 2.   Sign in butonuna basin
       WebElement isimKutusu =driver.findElement(By.xpath("//button[@id='signin_button']"));
       isimKutusu.click();
        // 3.   Login kutusuna “username” yazin
       WebElement login=driver.findElement(By.xpath("//input[@name='user_login']"));
       login.sendKeys("username");

       // 4.   Password kutusuna “password” yazin
        WebElement password =driver.findElement(By.xpath("//input[@id='user_password']"));
        password.sendKeys("password");

        // 5. Sign in tusuna basin, back tusuna basarak sayfaya donun
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.navigate().back();

        // 6. Online banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//a[@id='online-banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement dropDown =driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select=new Select(dropDown);
        select.selectByVisibleText("Eurozone (euro)");

        //9. “amount” kutusuna bir sayi girin
        WebElement amount =driver.findElement(By.xpath("//input[@id='pc_amount']"));
        amount.sendKeys("1000000");

        //10. “US Dollars” in secilmedigini test edin
        WebElement dolar=driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(dolar.isSelected());

        //11. “Selected currency” butonunu secin
        WebElement currency =driver.findElement(By.id("pc_inDollars_false"));
        currency.click();

        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        WebElement calculate =driver.findElement(By.id("purchase_cash"));
        calculate.click();

        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        String expectedYazi="Foreign currency cash was successfully purchased.";
        String actulaYazi= driver.findElement(By.xpath("//div[@id='alert_content']")).getText();
        Assert.assertEquals(expectedYazi,actulaYazi);
    }
}
