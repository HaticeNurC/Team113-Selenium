package Day09_Switching_Window_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_ActionsClass extends TestBase {

    @Test
    public void test() throws InterruptedException {

            //1- https://demoqa.com/droppable adresine gidelim
            driver.get("https://demoqa.com/droppable");
            //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

        WebElement dragmeelementi= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drophereelementi= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        Actions actions= new Actions(driver);
        actions.dragAndDrop(dragmeelementi,drophereelementi).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement droppedyazisi= driver.findElement(By.xpath("//p[text()='Dropped!']"));
        String expectedyazi = "Dropped!";
        String actualYazi = droppedyazisi.getText();
        Assert.assertEquals(expectedyazi,actualYazi);

        Thread.sleep(3000);

    }
}
