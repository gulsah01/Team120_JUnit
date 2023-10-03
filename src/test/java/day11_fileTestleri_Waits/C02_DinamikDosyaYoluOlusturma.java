package day11_fileTestleri_Waits;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_DinamikDosyaYoluOlusturma {
    @Test
    public void test01(){


        //masaustumuzde bulunan logo.jpg dosyasinin varligini
        // dinamik dosya yolu kullanarak test edelim

        //  /Users/gulsahsatilmis/Desktop/logo.jpg


        // "/Users/gulsahsatilmis + "/Desktop/logo.jpg
        //Ana dosya yolu              Herkeste ayni olan kisim

        String dinamikDosyaYolu = System.getProperty("user.home")+"/Desktop/logo.jpg";
        System.out.println(dinamikDosyaYolu); /// Users/gulsahsatilmis/Desktop/logo.jpg

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
        System.out.println(System.getProperty("user.dir"));
        //  /Users/gulsahsatilmis/IdeaProjects/Team120_JUnit_Fall2023

        // projemizde var olan text.txt nin varligini
        // dinamaik dosya yolu ile test edelim
        // /Users/gulsahsatilmis/IdeaProjects/Team120_JUnit_Fall2023
        //            /src/test/java/day11_fileTestleri_Waits/text.txt

        String dinamikTextDosyaYolu = System.getProperty("user.dir")+
                "/src/test/java/day11_fileTestleri_Waits/text.txt";
        Assert.assertTrue(Files.exists(Paths.get(dinamikTextDosyaYolu)));


    }
}
