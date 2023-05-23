package Day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assert {

     /*     JUnit calistirilan test method(lar)indan kac tanesinin
            passed,failed veya ignore oldugunu otomatik olarak raporlar

           - Eger JUnit'in test sonuclarini dogru olarak raporlamasini istiyorsak
            Assert class'indan hazir method'lar kullanarak test yapmaliyiz.
         */

    //Amazona gidip titlin amazon icerdigini test edin
    @Test
    public void Test01() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        String expectedtitle="AMAZON";
        String actualTitle= driver.getTitle();

        if (actualTitle.contains(expectedtitle)){
            System.out.println("Title test passed");
        }else {
            System.out.println("Title test failed" + actualTitle);
        }

        Assert.assertTrue(actualTitle.contains(expectedtitle));

        Thread.sleep(3000);
        driver.close();

    }
}
