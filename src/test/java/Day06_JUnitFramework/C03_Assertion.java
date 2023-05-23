package Day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertion {
    WebDriver driver;
    @Test
    public void googleTest() throws InterruptedException {
        System.out.println("Google test");
        // 1- google anasayfaya gidip, url'in google icerdigini test edin
        mahserin4atlisi();
        driver.get("https://www.google.com");
        String expectedIcerik= "google";
        String actaulurl= driver.getCurrentUrl();

        Assert.assertTrue(actaulurl.contains(expectedIcerik));

        Thread.sleep(3000);
        driver.close();


    }
    @Test
    public void wiseTest() throws InterruptedException {
        System.out.println("Wise test");
        //2- wisequarter anasayfaya gidip url'in wisequarter icerdigini test edin

        mahserin4atlisi();
        driver.get("https://www.wisequarter.com/");
        String expectedIcerik= "wisequarter";
        String actaulurl= driver.getCurrentUrl();

        Assert.assertTrue(actaulurl.contains(expectedIcerik));

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

        Assert.assertTrue(amazonLogoElementi.isDisplayed());


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

