package calisma;

public class ozet {
   /* JUnit Ders Tekrari
    day05 Ders Tekrari
1)  WebDriverManager.chromedriver().setup(); Yeni WebDriver Yontemimizdir.
            Setproperty() ile dosya yolunu kopyalayıp uzun uzun yazmamiza gerek kalmadi.
    Maven Repository'den Selenium kütüphanemizi ekleyip, yenileyince
    artik WebDriverManager'i yukaridaki sekilde yazmamiz yeterlidir.
    Ancak, Selenium 4.8 versiyonundan itibaren kendi WebDriver'ini olusturdugu icin
    biz WebdriverManager'i yazmasak da Selenium otomatik olarak kendi WebDriver'ini
    devreye soktugunu bilmemiz gerekir. Sirketlerin kendi webdriver'larini calistirdiklari
    icin biz el aliskanligi icin yazmaya devam ediyoruz.
            2)  @Test notasyonu siradan method'lari bagimsiz olarak calistirabilmemize imkan tanir.
    Boylece main method bagimliligi ortadan kalkar ve biz istedigimiz testi tek basina
    veya class level'dan toplu olarak calistirabiliriz.
    Ayrica ileride gorecegimiz sekilde test method'larini belirli gruplara dahil edip
    toplu olarak da calistirabiliriz.
    @Test notasyonuna sahip methodlar toplu olarak calistirildiginda
    hangi sira ile calisacagina dair bir kural yoktur. JUnit bu koduda bir yontem gelistirmemistir.
    Calisma sirasi ONGORULEMEZ ve KONTROL EDILEMEZ.
    Eger bir test method'u @ignore olarak isaretlenirse Selenium o method'u ignore eder,calistirmaz.
    JUnit bize calisan testlerden kacinin PASSED, kacinin FAILED oldugunu verir.
    ANCAK JUnit testlerin gecip gecmedigini, kodlarda bir sorun yasanip yasanmamasina baglar.
    Kodlar sorunsuz calisirsa, Test PASSED,bir exception olusursa, Test FAILED olarak kaydedilir.
    day06 Ders Tekrari
1-  Framework'ler calisma ortamını düzenlemenin yaninda bizim için faydali ve kolaylik saglayici işlevler sağlarlar.
            2-  Junit ile hayatimiza giren en buyuk yenilik notasyonlardir. @ ile başlayan notasyonlar,
    framework'un işleyişine müdahale edecek kucuk bilgilere sahiptirler.
            3-  @Test: Siradan bir method cagrilmadan calismaz. @Test notasyonu eklenen method'lar ise bagimsiz olarak calistirilabilir.
    Bu da bizi main method bagimliligindan kurtarir.
4-  @Ignore : yazildigi test notasyonunun ignore edilmesini sağlar.
            5-  @Before ve @After: Her test method'undan önce calismasini istediğimiz siradan bir method varsa,
    @Before ile, her test method'undan sonra calismasini istediğimiz siradan bir method varsa da @After ile işaretleriz.
            6-  @BeforeClass ve @AfterClass : Eğer her test method'undan önce ve sonra değil de class ilk calismaya basladiginda
    ve class calismayi bitirdiğinde devreye girmesini istediğimiz siradan method'lar varsa kullanilir.
            7-  Ornegin derste de yaptigimiz calismadaki gibi class'taki test methodlarimizin hepsi icin tek bir adrese gitmek
    istiyorsak @BeforeClass'i icindeki method'a driver.get(..) ile belirtmemiz yeterli olacaktır. Boylece her @Test
    notasyonu icindeki method calismadan once @BeforeClass methodu calisacagi icin o adrese gidecektir.
8-  @BeforeClass ve @AfterClass notasyonlarının @Before ve @After notasyonlarından ayrismasinin onemli bir farki da
    STATİC olmak zorunda olmalaridir.
            9-  Assertions : JUnit test method'larinin PASSED veya FAILED olduklarina o test method’una ait kodlarin sorunsuz
    calisip calismadigina bakarak karar verir. If-Else ile yapılan testlerde testimiz failed olsa bile kod sorunsuz
    calistigi için JUnit testi PASSED olarak işaretler.
            JUnit'in bu özelliğinin saglikli calismasi için assertions kullanilmali.
    day07 Ders Tekrari
1-  4 cesit Assertions vardir:
            1) Assert.assertEquals()
            2) AssertassertNotEquals()
    3) Assert.assertTrue()
            4) Assert.assertFalse()
            * Amazon ornegindeki; Title'in "amazon" icerdigini test etmemizi isteyen soruda da soru kalıbı
            (içermesi=> olumlu olduğundan) Assert.assertTrue()'nu kullaniyoruz.
            * BestBuy orneginde ise; sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test etmemizi
    isteyen soruda da soru kalıbı (eşit mi => eşit olma sorusu olumlu olduğundan)
    Assert.assertEquals()'nu kullaniyoruz.
            * Youtube orneginde ise; sayfa basliginin “youtube” olmadigini dogrulamamizi test etmemizi
    isteyen soruda da soru kalıbı (içermemesi=> olumsuz olduğundan) Assert.assertFalse()'nu
    veya Assert.assertNotEquals()'unu kullanabiliyoruz.
            2-  Bir test methodunun icinde birden fazla Assertion varsa bu assertion'lardan bir tanesi FAILED olursa
    kodun calismasi o satirda durur. Geriye kalan assertion'lar kontrol edilmemis olur.
    Eger bir class calistiginda tum assortion'larin mutlaka gozden gecirilmesini
    istiyorsak her assortion icin ayri test method'u olusturabiliriz.
            3-  Test method'larinin ismi de yaptigi is ile uyumlu olursa konsolda neyin calisip
    neyin calismadigini kolayca görebiliriz.
            4-  Checkbox; birden fazla secim yapmamiza imkan taniyan bir seçim araci iken
    RadioButton; tek secim imkani taniyan bir secim aracidir.
5-  Checkbox ve RadioButton elementlerini locate alma islemlerimizde ve test etme methodlarimizda yine
    assertion'lar ile ayni sekilde handle ediyoruz. Burada Checkbox ve RadioButton elementleri seçim yapmamizi
    gerektiren elementler olduğu icin is.Selected()'larini kullaniyoruz.
            6-  Dropdown menulerini handle etmek icin ise 3 yontem uyguluyoruz.
            1) Dropdown webelement’i locate edin.
    2) Select class’indan bir obje olusturun ve locate edilen
    dropdown elementini parametre olarak yazin.
    3) select objesi ile Select class’inda bulunan
    method’lardan uygun olani ile istediginiz option’i secin.
            * Bu method'lardan da 3 yaygin kullanimi olanlari gormustuk. Bunlar:
            - select.selectByValue()
            - select.selectByIndex()
            - select.selectByVisibleText()
    day08 alert() & Basic Authentication
1-  Alert nedir?
    Alert kullanıcıya bir tür bilgi vermek veya belirli bir işlemi gerçekleştirme izni istemek
    için ekran bildirimi görüntüleyen küçük bir mesaj kutusudur. Uyarı amacıyla da kullanılabilir.
    a- HTML Alerts :
    Bir alert ciktiginda sag click ile inspect yapabiliyorsak html alert’dir ve extra bir isleme gerek yoktur.
            b- Js Alerts :
    Js alerts'e inspect yapilamaz, ekstra isleme ihtiyac vardir.
    Bu islemler:
            ==> driver.switchTo().alert(); ile alert'e gecis yapilir ve alert method'unun handle icin bize imkan tanidigi
    method'lardan faydalanilir. Bu method'lar sunlardir:
            - .accept( ) : Alert üzerindeki OK butonuna basmak için kullanılır.
        - .dismiss( ) : Alert üzerindeki Iptal butonuna basmak için kullanılır.
        - .getText( ) : Alert üzerindeki yaziyi döndürür.
            - .sendKeys("istenen yazi") : Alert üzerindeki text kutusuna istenen metni yazdırır.
2-  Authentication nedir?
    Kısaca, herhangi bir internet kullanıcısının, uygulamanın ya da programın, söz konusu sisteme dahil olup
    olamayacağını belirleyen formu ifade eder.
    Uygulama ana sayfalarindaki kullanici adi ve password istemek de bir authentication’dir.
    End user’lar icin tasarlanmayan uygulamalarda(Ornegin API sorgularinda) bu authentication HTML komutlari
    ile de yapilabilir.
            https://username:password@URL
    Bu authentication’i yapabilmek icin uygulamanin kullanicilara authentication’i nasil yapacagina dair
    bilgilendirme yapmis olmasi gerekir.
    Ornegin; driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth"); ile yetkilendirme
    yapilmis sekilde direk istenen sayfaya erisim saglanabilir.
    day09 Iframe Handle & Coklu Windows Handle
1-  HTML kodlarda kullanilan <iframe> tag’i bir HTML sayfasinin icerisine baska bir
    HTML sayfasi gömmek(embed) icin kullanilir.
    Iframe'ler genellikle videoları, haritaları ve diğer medyaları bir web sayfasına gömmek için kullanılır.
    Ancak sadece bunlarla sınırlı degildir, her turlu HTML sayfasi <iframe> tag'i ile kullanilabilir.
            2-  Locate dogru oldugu halde webelement'i kullanamiyorsak webelement bir iframe icinde olabilir.
    Eger iframe icinde ise;
     - once o iframe'i locate etmeli : driver.switchTo().frame(iframeWebElementLocate'i)
            - locate ettigimiz iframe'e gecis yapmali
            - sonra istenen islemi gerceklestirmeliyiz
    Iframe'e gecis yapinca driver'imiz artik o sayfaya gecmis olur.
    Anasayfadaki webelementleri goremez. Eger testimizde iframe disindan element kullanmamiz gerekirse
    once iframe'den disari cikmamiz lazim.
            driver.switchTo().defaultContent(); ==> - Direk anasayfaya gecis yapmak icin kullanilir.
            driver.switchTo().parentFrame();    ==> - Icice birden fazla iframe varsa, bir ust iframe’e cikmak icin kullanilir.
            3-  Bir HTML sayfasinda test yaparken, bazen isteyerek veya bir link tiklayarak yeni bir
    tab veya windows acilabilir.
    Test sirasinda test icin yapilan tum eylemleri webdriver objesi yaptigi icin, yeni acilan
    sayfada islem yapilabilmesi icin webdriver’in yeni sayfaya gecis yapmasi gerekir.
    Selenium4 ile yeni gelen bir ozellik olarak, test sirasinda yeni bir tab veya window
    acilabilir.
            driver.switchTo().newwindow(WindowType.WINDOW/.TAB) : Bu method kullanildiginda yeni sayfa/tab driver ile
    acildigindan driver otomatik olarak yeni sayfaya gecis yapar.
            4-  Bir linke tikladigimizda biz newWindow() kullanmadigimiz halde yeni sayfa aciliyorsa
    driver eski sayfada kalir ve yeni sayfada islem yapabilmek icin bizim driver'i yeni
    sayfaya gecirmemiz gerekmektedir.
    Bunun icin ise su adimlari izlememiz gerekir:
            1- Ilk window’un window handle degerini kaydedin.
            String ilkSayfaWhd= driver.getWindowHandle();
    2- Ikinci window acildiktan sonra, iki sayfanin window handle degerini kaydedin.
            Set<String> whdSeti = driver.getWindowHandles();
    3- For-each loop ile set’deki window handle degerlerini kontrol edin, ilk sayfanin
    window handle degerine esit olmayani ikinci sayfanin window handle degeri olarak
    kaydedin.
            String ikinciSayfaWhd="";
       for (String each: whdSeti
       ) {
        if (!each.equals(ilkSayfaWhd)){
            ikinciSayfaWhd = each;
        }
    }
    day10 Actions Class
1-  Actions class’i kullanilarak mouse ve klavye ile yapabilabilecek tum islevler gerceklestirilebilir.
    Actions Class birçok kullanışlı mouse ve klavye method’una sahiptir.
            - Çift tıklama (double click),
    - sürükleme ve bırakma (drag and drop)
    - mouse’u objeye götürme (move to element)
    gibi karmaşık mouse eylemleri veya
    Keyboard ile yapabilecegimiz pageUp, pageDown, shift, arrowDown gibi islemleri
    Actions class’indan object ureterek driver ile yapabiliriz.
            2-  Burada yapacagimiz adimlar su sekildedir:
            1.Adım: Actions class’ta bir object oluşturulur.
    Actions actions = new Actions(driver);
    2. Adım: Üzerinde çalışmak istediğiniz WebElement locate edilir.
    WebElement hedefAlanElementi = driver.findElement(By.id("idName"));
    3.Adim : Ardından bu webelement üzerinde action gerçekleştirilir.
    Örneğin Mouse’u istenen webelement’in uzerine goturmek icin
    actions.moveToElement(hedefAlanElementi).perform();
3-  Her ne kadar klavyede pek cok tus olsa da bir tus icin yapilabilebilecek 3 temel islev var.
    1- tek seferlik basmak sendkeys(Keys.ENTER)
    2- bazen belirli bir sure icin bir tusu basili tutmak isteriz keyDown()
    3- basili tuttugumuz tusu serbest birakmak isteriz keyUp()
    day11 File & Waits
1-  Selenium webDriver objesi üzerinden calisir ve local bilgisayard işlem yapamaz. Local
    bilgisayardaki dosyalara erişmek veya test etmek için JAVA kullanılabilir.
    Local bilgisayarda bir dosyaya ulaşmak ve olup olmadığını(exist) kontrol etmek için
    dosya yoluna ihtiyaç vardir.
    Her bilgisayarin ismi ve kullanici ismi farkli olacagindan, bir bilgisayarda yazilan dosya yolu
    başka bilgisayarda calismaz. Java’daki getProperty( ) method’u ile her bilgisayarda farkli olan kisim,
    testin calistigi bilgisayardan alinabilir. Bu temel path’den sonrasi tum bilgisayarlarda ayni olacagi
    için kod dinamik olur.
    getProperty( ) method’u iki farkli parametre ile calisabilir.
            1- System.getProperty ( "user.dir"); icinde bulunulan klasörün yolunu (Path) verir
    2- System.getProperty ( "user.home"); bilgisayarimizda bulunan user klasörünü verir
2-  Insan olarak dosya secimi icin chooseFile butonuna bastiktan sonra acilan windows dosya penceresinden
    istedigimiz dosyayi secip yukleriz.
    Selenium'da otomasyon ile bu islemi yapmak icin chooseFile butonu locate edilip,
    bu webelement'e sendKeys(yuklenecekDosyaninDosyaYolu); yapilir.
            3-  Synchronization(Senkronizasyon), UI (kullanıcı arayüzü) uzerinde planlanan bir testin
    sorunsuz calismasi icin mutlaka dikkate alinmasi gereken bir konudur.
    Bir sayfanın uygulama sunucusu veya web sunucusu çok yavaşsa veya internet ağı çok
    yavaşsa, web sayfasındaki öğelerin (webelement) yüklenmesi beklenenden uzun sürebilir.
    Bu durumda, komut dosyanız (test script) öğeyi bulmaya çalıştığında, öğeler yüklenmez.
    Bu yüzden test komut dosyası(test script) öğeyi bulamaz ve başarısız olur ve kod
    NoSuchElementExeption verip, calismayi durdurur.
4-  Driver ile cihaz veya internet arasinda yasanan senkronizasyon sorunlarini çözmek
    icin driver’i belirli yontemler ile bekletmek(wait) gerekir.
            1 ) Java tabanli wait :
    Thread.sleep : Javadan gelir ve kodlari yazilan sure kadar bekletir.
    Sure dolduktan sonra alt satirdan isleme devam eder.
            2 ) Selenium tabanli wait’ler :
    Implicitly Wait: Sayfadaki tüm öğeler için global bir zaman aşımıdır(timeout).
    Explicitly Wait: Çoğunlukla belirli öğeler için belirli bir koşul(expected condition) için kullanılır.
    Gorunmeyen bir elementi locate edemeyiz.
    Locate edilmeyen bir elementi bekleyemeyiz, gorunur olmasi icin de beklememiz lazim.
    Explicit Wait bekleme ve locate islemini birlikte yapabilir.
            5-  Explicit Wait ile beklemek icin
    1- beklemek icin wait objesi olusturalim
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    2- hangi web element beklenecekse locate edelim
    3- belirledigimiz webelement ne icin bekletilecek? Bunun icin ilgili method yazilir.
            WebElement itsGoneElementi =
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
    ( Burada bizden istenen hedefin locate'ini aldik ve beklenen durum elementin gorunur olana kadar beklemesini
    gerektirdigi icin bunu belirten sarti parantez icinde ilgili method'un ismini yazarak belirttik. )
    day12 Cookies & WebTables
1-  Birkaç farklılıkla, siber dünyadaki çerezlerin oturum çerezi ve kalıcı çerez olmak üzere
    iki çeşidi vardır.
    - Oturum çerezleri yalnızca bir web sitesinde gezinirken kullanılır. Bunlar rastgele erişimli
    bellekte saklanır ve hiçbir zaman sabit sürücüye yazılmaz. Oturum sona erdiğinde oturum
    çerezleri otomatik olarak silinir.
            - Kalıcı çerezler bir bilgisayarda sonsuza kadar saklı kalır ancak birçoğunun bir son kullanma tarihi
    olup bu tarihe gelindiğinde otomatik olarak kaldırılırlar.
    Selenium ile cookies otomasyonu yapabiliriz.
            Driver.manage( ). method’u ile cookie’leri;
    - listeleyebilir :
    Set<Cookie> cookieSeti =  driver.manage().getCookies(); ile forEachLoop ile tek tek yazdirabiliriz
    - Isim ile cagirabilir
    String CookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
    - Yeni cookie ekleyebilir
    Cookie yeniCookie = new Cookie("en sevdigim cookie","cikolatali");
     driver.manage().addCookie(yeniCookie);
    - Var olanlari ismi silebilir
    driver.manage().deleteCookieNamed("skin");
    - Var olan tum cookie’leri silebiliriz
    driver.manage().deleteAllCookies();
2-  - WebTables'da istenen satir ve sutun bilgilerinin web element bilgilerini locate alip
    istediğim dataya(cell) ulaşabilirim.
    Bunun için önce satir bilgisinin locate'ini alip
    sonrasinda istedigim sutunun locate'ini yanina ekleyerek istedigim dataya ulasim saglayabilirim.
            //*[@*='rowgroup'])//*[@*='gridcell'][3] ==> ornegin; 3. sutun bilgilerine bu sekilde erisebilirim
            - 3. sutun elementlerini yazdirmam gerekirse; bunu bir List e atıp oradan forEachLoop ile
    tek tek getirip yazdirabilirim.
    List<WebElement> ucuncuSutunElementleri =
            driver.findElements(By.xpath("(//*[@*='rowgroup'])//*[@*='gridcell'][3]"));
       for (WebElement each : ucuncuKolonElementleri
       ) {
        if (!each.getText().isBlank()){
            System.out.println(each.getText());
        }
    }
    day13 Read Excel & day14 Write Excel
1-  Excel’de bir hucredeki bilgiye ulasmak icin dosya/sayfa/satir/sutun sirasiyla ilerlemeliyiz.
    Excel ile ilgili otomasyonda web table’da oldugu gibi sutun yapisi yoktur, ihtiyac duyarsak kodla
    sutunu elde edebiliriz ancak bir dataya ulasmak icin sutun kullanamayiz.
    Workbook excel dosyamiz,(Apache POI, microsoft ofis dokumanlarina erişmek için kullanılan Java API'idir.)
    Sheet Her açık excel sekmesi (Sheet1, etc)
    Row(satir) Java, yalnızca içeride veri varsa satırları sayar.
    Default olarak, Java perspektifinden satır sayısı 0'dır
    Cells (hucre) Java her satıra bakar ve yalnızca hücrede veri varsa hücre sayısını sayar.
    String dosyaYolu = "src\\test\\java\\day13_excelOtomasyonu\\ulkeler.xlsx";
    FileInputStream fis = new FileInputStream(dosyaYolu);
    Workbook workbook = WorkbookFactory.create(fis);
    Olusturdugumuz workbook, online olarak excel dosyasina erismez.
    fileInputStream kullanarak excel'deki bilgileri aldik.
    fis'in aldigi bilgileri kullanarak kodlarimizin icinde fiziki excel dosyasinin bir kopyasini olusturmus olduk.
    Sheet sheet = workbook.getSheet("Sayfa1"); diyerek istediğimiz sayfaya gidebiliriz.
    Row row = sheet.getRow(3);  istenen bilgiye index ile ulaşabiliriz.
            Cell cell = row.getCell(3);
2-  Excel dosyasinda write islemleri:
    Sayfa1'de 5.hucreye yeni bir cell olusturmak icin ==> sayfa1.getRow(0).createCell(4);
    Olusturulan hucreye “Nufus” yazdirmak icin ==> sayfa1.getRow(0).getCell(4).setCellValue("Nufus Bilgileri");
    Dosyayi kaydetmek icin ==> FileOutputStream fos = new FileOutputStream(dosyaYolu);
                               workbook.write(fos);
    Dosyayi kapatmak icin ise ==> fis.close();
                                  fos.close();
                                  workbook.close();
    day14 Screenshot & JS Executor
1-  1.Adim : Bir TakeScreenhot objesi olusturup driver’imizi TakeScreenhot’a cast yapalim
    TakesScreenshot tss = (TakesScreenshot) driver;
    2.Adim : kaydettigimiz ekran goruntusunu projede istedigimiz yere kaydedebilmek icin
    path ile yeni bir File olusturalim.
    File tumSayfaScreenshot = new File("target/screenShots/tumSayfaScreenshot.png");
    3.Adim : Takescreenshot objesini kullanarak getScreenshotAs( ) methodunu calistiralim
    ve gelen resmi gecici bir file’a assign edelim.
            File geciciResim = tss.getScreenshotAs(OutputType.FILE);
    4.Adim : Kaydettigimiz goruntuyu, saklamak istedigimiz dosyaya kopyalayalim
            FileUtils.copyFile(geciciResim,tumSayfaScreenshot);
2-  Selenium ile web elementlerinin kontrollerini sağlarken selenium komutları yetersiz
    kalabilir veya sorunlarla karşılaşabiliriz.
    Bu durumlarda alternatif olarak üstesinden gelmek için JavascriptExecutor class’ini
    dahil edebiliriz.
    JavaScript HTML kodlara direk erişip yönetebilen bir script dili olduğundan bize çok
    fazla kolaylık sağlayabilir.
    1.Adim : JavascriptExecutor kullanmak icin ilk adim olarak driver’imizi JavascriptExecutor’a cast edelim
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    2.Adim : Kullanacagimiz WebElement’i locate edelim
    WebElement goToCareerElementi = driver.findElement(By.xpath("(//a[@href='https://wisequarter.com/career/'])[10]"));
    3.Adim : Js driver ile executeScript method’unu calistiralim, icine parametere olarak
    ilgili script ve webelement’i yazalim.
            jse.executeScript("arguments[0].click();", goToCareerElementi);
3-  Istenen Webelement’e kadar asagi inmek icin;
    jse.executeScript("arguments[0].scrollIntoView();",hedefWebelement);

    JS alert kullanarak uygulama’dan kullaniciya mesaj vermek icin;
    jse.executeScript("alert('yasasinnnn');");

    */
}
