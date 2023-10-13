package calisma;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class webTable extends TestBase {
    @Test
    public void test01(){

        //1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");

        // 2.Sayfanin en altina inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
bekle(2);
        // 3.Web table tum body’sini yazdirin
        WebElement Body = driver.findElement(By.xpath("//tbody"));
        System.out.println(Body.getText());

        // 4.Web table’daki satir sayisinin 7 oldugunu test edin
       List<WebElement> satirSayisiListesi=driver.findElements(By.xpath("//tbody/tr"));
       int expectedSatirSayisi=7;
       int actualSatirSayisi=satirSayisiListesi.size();
       Assert.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        // 5.Tum satirlari yazdirin
        for (int i = 0; i <satirSayisiListesi.size() ; i++) {
            System.out.println(satirSayisiListesi.get(i).getText());
        }
        // 6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> sutunSayisiListesi=driver.findElements(By.xpath("//tr[1]/td"));
        int expectedSutunSayisi=13;
        int actulaSutunsayisi=sutunSayisiListesi.size();
        Assert.assertEquals(expectedSutunSayisi,actulaSutunsayisi);

        // 7. 5.sutunu yazdirin
        List<WebElement> besinciSutunDatalari =driver.findElements(By.xpath("//tr/td[5]"));
        for (WebElement each:besinciSutunDatalari
             ) {
            System.out.println(each.getText());
        }

        // 8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        System.out.println("=======================");
        System.out.println(hucredekiBilgi(2,1));
        System.out.println(hucredekiBilgi(5,7));

    }
    public String hucredekiBilgi(int satirNo, int sutunNo){
        String dinamikXpath ="//tr["+satirNo +"]/td["+sutunNo+"]";
        WebElement istenenDataElementi =driver.findElement(By.xpath(dinamikXpath));
        return istenenDataElementi.getText();
    }
}
