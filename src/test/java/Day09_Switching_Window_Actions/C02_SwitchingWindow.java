package Day09_Switching_Window_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C02_SwitchingWindow extends TestBase {

    /*
        driver.switchTo().newWindow() kullanarak actigimiz
        window'a driver otomatik olarak gecer
        ANCAKKKKK....
        biz newWindow() method'unu kullanmadan
        bir link tikladigimizda yeni window aciliyorsa
        driver eski window'da kalir
        Yeni window'a driver'i gecirebilmek icin
        yeni window'un WindowHandleDegerine ihtiyacimiz vardir.
     */

    @Test
    public void test() throws InterruptedException {

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.

        WebElement openingWindowYaziElementi = driver.findElement(By.xpath("//*[text()='Opening a new window']"));
        String expectedYazi="Opening a new window";
        String actualYazi= openingWindowYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        String ilkSayfaWHD = driver.getWindowHandle();

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

       String expectedTitle= "The Internet";
       String actualTitle= driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        //● Click Here butonuna basın.

         driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        // 47.satir itibariyle yeni window acildi
        // artik 2 window var

        Set<String> WHDegerleri= driver.getWindowHandles();
        String ikinciWHD= "";

        for (String eachWhd: WHDegerleri
        ) {
            if (!eachWhd.equals(ilkSayfaWHD)){
                ikinciWHD = eachWhd;
            }
        }

        // Artik acilan 2.window'un windowHandleDegerine sahibiz
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        driver.switchTo().window(ikinciWHD);

        String expectedtitle2= "New Window";
        String actualTitle2= driver.getTitle();

        Assert.assertEquals(expectedtitle2,actualTitle2);

        Thread.sleep(3000);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.

        WebElement yenisayfatexti= driver.findElement(By.tagName("h3"));

        String expectedtext= "New Window";
        String actualtext= yenisayfatexti.getText();

        Assert.assertEquals(expectedtext,actualtext);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

        driver.switchTo().window(ilkSayfaWHD);

      String  expectedsayfabasligi= "The Internet";
      String actualsayfabasligi= driver.getTitle();

      Assert.assertEquals(expectedsayfabasligi,actualsayfabasligi);





    }

}
