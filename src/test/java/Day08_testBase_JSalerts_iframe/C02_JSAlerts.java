package Day08_testBase_JSalerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeClass;

public class C02_JSAlerts extends TestBaseBeforeClass {

      /*
        Otomasyon yaparken iki tur alert ile karsilasabiliriz
        1- HTML alerts :
           HTML kodlari ile olusturulmus alert'lerdir
           HTML ile olusturuldugu icin inspect edilebilir,
           locate edilebilir ve driver ile kullanilabilir
        2- JavaScript Alerts :
           Inspect yapilamaz, locate edilemez
           Testlerimiz sirasinda JS alert ile karsilasirsak
           driver.switchTo().alert() method'larini kullanarak
           alert'e gecis yapabilir ve alert uzerinde
           OK, Cancel, Alert yazisini alma getText()
           ve alert'e yazi yollama sendKeys()
           method'larini kullanabiliriz.
     */

    /*3 test method'u olusturup asagidaki gorevi tamamlayin
        1. Test
            -  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
            - 1.alert'e tiklayin
            -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
            -  OK tusuna basip alert'i kapatin
        2.Test
            - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
            - 2.alert'e tiklayalim
            - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        3.Test
            - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
            - 3.alert'e tiklayalim
            - Cikan prompt ekranina "Abdullah" yazdiralim
            - OK tusuna basarak alert'i kapatalim
            - Cikan sonuc yazisinin Abdullah icerdigini test edelim

    */
     @Test
    public void test01(){
        /* 1. Test
                 -  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
         - 1.alert'e tiklayin
                 -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
                 -  OK tusuna basip alert'i kapatin*/

         driver.get("https://the-internet.herokuapp.com/javascript_alerts");

         driver.findElement(By.xpath("//*[text()= 'Click for JS Alert']")).click();

         // -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin

         String expectedyazi= "I am a JS Alert";
         String actualyazi= driver.switchTo().alert().getText();

         Assert.assertEquals(expectedyazi,actualyazi);

         //Ok tusuna basip kapatin

         driver.switchTo().alert().accept();



     }
     @Test
    public void test02(){

         /*2.Test
                 - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
         - 2.alert'e tiklayalim
                 - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin*/
         driver.get("https://the-internet.herokuapp.com/javascript_alerts");

         driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
         driver.switchTo().alert().dismiss();

         String expectedyazi= "You clicked: Cancel";
         String actualyazi= driver.findElement(By.xpath("//*[@id='result']")).getText();

         Assert.assertEquals(expectedyazi,actualyazi);




         }

         @Test
    public void test03(){

         /* 3.Test
                 - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
                 - 3.alert'e tiklayalim
                 - Cikan prompt ekranina "Abdullah" yazdiralim
                 - OK tusuna basarak alert'i kapatalim
                 - Cikan sonuc yazisinin Abdullah icerdigini test edelim*/

             driver.get("https://the-internet.herokuapp.com/javascript_alerts");

             driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();

             driver.switchTo().alert().sendKeys("Abdullah");

             driver.switchTo().alert().accept();

             String expectedYazi = "Abdullah";
             String actualYazi = driver.findElement(By.xpath("//*[@id='result']")).getText();

             Assert.assertTrue(actualYazi.contains(expectedYazi));


     }




}
