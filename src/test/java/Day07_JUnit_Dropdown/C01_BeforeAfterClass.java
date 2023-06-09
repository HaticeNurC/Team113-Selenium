package Day07_JUnit_Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeAfterClass {
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //  ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    //  ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //  ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //  ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    static  WebDriver driver;

    @BeforeClass

    public static void setup(){
       // https://www.youtube.com adresine gidin
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.youtube.com");
    }
    @AfterClass
     public static void teardown(){
        driver.close();
    }
   // ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin

    @Test
    public void titletest(){

        String exceptedicerik= "YouTube";
        String actualTitle= driver.getTitle();

        Assert.assertEquals(exceptedicerik,actualTitle);
    }
    //  ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    @Test
    public void imagetest(){

        WebElement logoelement= driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));

        Assert.assertTrue(logoelement.isDisplayed());
    }

    //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    @Test
    public void searchboxtesti(){

        WebElement searchbox= driver.findElement(By.xpath("//input[@id='search']"));

        Assert.assertTrue(searchbox.isEnabled());
    }
    //  ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    @Test
    public void wrongTitleTest(){

        String exceptedIcerik= "youtube";
        String actualtitle= driver.getTitle();
        Assert.assertNotEquals(exceptedIcerik,actualtitle);
    }
}



