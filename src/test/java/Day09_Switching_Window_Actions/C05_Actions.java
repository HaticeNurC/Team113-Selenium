package Day09_Switching_Window_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_Actions extends TestBase {

    @Test
    public void test() throws InterruptedException{

        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //   mouse’u bu menunun ustune getirin

        WebElement accountlistelementi= driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountlistelementi).perform();

        //3- “Create a list” butonuna basin
        WebElement createlistbutonu= driver.findElement(By.xpath("//*[text()='Create a List']"));
        createlistbutonu.click();

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin

        WebElement yourlistyazisi= driver.findElement(By.xpath("//div[@role='heading']"));

        String expectedyazi="Your Lists";
        String actualyazi= yourlistyazisi.getText();

        Assert.assertEquals(expectedyazi,actualyazi);
        Thread.sleep(3000);
    }
}
