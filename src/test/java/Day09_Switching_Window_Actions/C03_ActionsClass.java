package Day09_Switching_Window_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_ActionsClass extends TestBase {

    @Test
    public void test() throws InterruptedException {

        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapin

        WebElement cizilialanelementi= driver.findElement(By.xpath("//*[@id='hot-spot']"));

        Actions actions= new Actions(driver);

        actions.contextClick(cizilialanelementi).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.

        String expectedAlertYazisi= "You selected a context menu";
        String actualAlertYazisi= driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        //  linki tikladigimizda yeni window acildigindan
        //  tiklamadan once ilk window'un WHD almamiz gerekir

        String ilksayfaWHD= driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();

        // ikinci sayfa biz newWindow() demeden acildigindan
        // ikinciWindow'un WHD'ini Java kullanarak bulmaliyiz
        String ikicisayfaWHD= "";
        Set<String > windowdegerleritesti= driver.getWindowHandles();

        // icinde 2 tane WHD var
        // ilkWindowWHD'e esit olmayani ikinciWindowWHD olarak atayalim

        for (String eachWHD:windowdegerleritesti
             ) {
            if (!eachWHD.equals(ilksayfaWHD)){
                ikicisayfaWHD=eachWHD;
            }

        }
        driver.switchTo().window(ikicisayfaWHD);

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        String expectedYazi= "Elemental Selenium";
        WebElement yazielementi= driver.findElement(By.tagName("h1"));

        String actualyazi= yazielementi.getText();

        Assert.assertEquals(expectedYazi,actualyazi);
        Thread.sleep(5000);







    }
}
