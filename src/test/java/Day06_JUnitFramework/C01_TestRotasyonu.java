package Day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TestRotasyonu {

        /*
        Bu class icerisinde 3 test calistiralim
        1- google anasayfaya gidip, url'in google icerdigini test edin
        2- wisequarter anasayfaya gidip url'in wisequarter icerdigini test edin
        3- amazon anasayfaya gidip, amazon logosunun gorundugunu test edin
     */
     /*
        JUnit'in bize sagladigi ilk ve belki de en onemli ozellik
        test method'larinin bagimsiz olarak calistirilabilmesini saglayan
        @Test notasyonudur.
        Junit ile class level'dan birden fazla test method'u calistirirsak
        hangi siralama ile calistiracagini ongoremeyiz ve yonetemeyiz

        Diyelim ki bir test methodu uzerinde calisiyoruz ve o methodun toplu calistirmalarda
        kullanilmasini istemiyorsak @Ignore kullanabiliriz.
     */

    WebDriver driver;
    @Test
    public void googleTest() throws InterruptedException {
        System.out.println("Google test");
       // 1- google anasayfaya gidip, url'in google icerdigini test edin
        mahserin4atlisi();
        driver.get("https://www.google.com");
        String expectedIcerik= "Google";
        String actaulurl= driver.getCurrentUrl();
        if (actaulurl.contains(expectedIcerik)){
            System.out.println("Google icerik testi passed");
        }else {
            System.out.println("Google icerik testi failed");
        }
        Thread.sleep(3000);
        driver.close();


    }
    @Test
    public void wiseTest() throws InterruptedException {
        System.out.println("Wise test");
    //2- wisequarter anasayfaya gidip url'in wisequarter icerdigini test edin
        mahserin4atlisi();
        driver.get("https://www.wisequarter.com/");
        String expectedIcerik= "Google";
        String actaulurl= driver.getCurrentUrl();
        if (actaulurl.contains(expectedIcerik)){
            System.out.println("Wisequarter icerik testi passed");
        }else {
            System.out.println("Wisequarter icerik testi failed");
        }
        Thread.sleep(3000);
        driver.close();

    }
    @Test
    public void amazonTest() throws InterruptedException {
        System.out.println("Amazon Test");
    // 3- amazon anasayfaya gidip, amazon logosunun gorundugunu test edin
        mahserin4atlisi();
        driver.get("https://www.amazon.com/");
        WebElement amazonLogoElementi= driver.findElement(By.id("nav-logo-sprites"));

        if (amazonLogoElementi.isDisplayed()){
            System.out.println("Amazon Testi passed");
        }else {
            System.out.println("Amzon Testi failed");
        }
        Thread.sleep(3000);
        driver.close();

    }
    public void mahserin4atlisi(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

}
