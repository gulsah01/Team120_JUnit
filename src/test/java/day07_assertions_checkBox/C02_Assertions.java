package day07_assertions_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_Assertions {
    //Assertions
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
        ReusableMethods.bekle(1);
        driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[16]")).click();
        ReusableMethods.bekle(1);
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
    @Test
    public void titleTest(){
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    @Test
    public void imageTest(){
        WebElement youtubeImg = driver.findElement(By.xpath("(//div[@class='style-scope ytd-topbar-logo-renderer'])[1]"));
        Assert.assertTrue(youtubeImg.isDisplayed());
    }
    @Test
    public void enabledTest(){
        WebElement searchBox = driver.findElement(By.xpath("(//div[@id='search-input'])[1]"));
        Assert.assertTrue(searchBox.isEnabled());
    }
    @Test
    public void wrongTitleTest(){
        String unexpectedTitle = "youtube";
        String actualTitle = driver.getTitle();
        Assert.assertNotEquals(unexpectedTitle,actualTitle);
    }
}
