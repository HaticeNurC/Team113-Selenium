package Day08_testBase_JSalerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_TestBaseIlkClass extends TestBase {


    @Test
    public void test01(){

        driver.get("https://www.amazon.com/");

        //Nutella icin arama yapalaim

        WebElement aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("Nutella"+ Keys.ENTER);

        //arama sonuclarinin Nutella icerdigini test edin

        String exceptedIcerik = "Nutella";
        String actualIcerik= driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();

        Assert.assertTrue(actualIcerik.contains(exceptedIcerik));



    }
}
