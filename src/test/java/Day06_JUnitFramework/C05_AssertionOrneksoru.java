package Day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_AssertionOrneksoru {

    WebDriver driver;

    public void Mahserin4atlisi() {

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");


    }
    @Test
    public void test01(){
        //sayfa url sinin https://www.bestbuy.com/ a esit oldugunu test et

        Mahserin4atlisi();
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);
        driver.close();


    }
    @Test
    public void test02(){
        //sayfa basliginin "Rest" icermedigini test edin

        Mahserin4atlisi();

        String unexceptedIcerik = "Rest";
        String actualTitle=driver.getTitle();

        Assert.assertFalse(actualTitle.contains(unexceptedIcerik));
        driver.close();

    }
    @Test
    public void test03(){

        Mahserin4atlisi();

        WebElement logo= driver.findElement(By.xpath("(//img[@class=\"logo\"])"));

        String exceptedlogo= "BestBuy";
        String actuallogo= driver.getTitle();

        // Assert.assertTrue(actuallogo.contains(exceptedlogo));
        driver.close();
    }

}


