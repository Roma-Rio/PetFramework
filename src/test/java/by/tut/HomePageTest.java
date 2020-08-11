package by.tut;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import java.util.concurrent.TimeUnit;

public class HomePageTest {
    private HomePage homePage;
    protected ReadProperties properties;
    private WebDriver driver;
    private WebDriverWait wdw;


    @BeforeTest
    public void start () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        wdw = new WebDriverWait(driver,10);
       homePage = new HomePage(driver);
        properties = new ReadProperties();
    }

     @Test
     public void toHomePage() {
        driver.get(ReadProperties.getUrlProperty("homepage"));
        wdw.until(titleIs("Белорусский портал TUT.BY. Новости Беларуси и мира"));
     }

     @AfterTest
    public void stop () {
        driver.quit();
        driver = null;
     }


}
