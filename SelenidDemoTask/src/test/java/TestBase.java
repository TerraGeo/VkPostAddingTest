import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.VKStartPage;

import static com.codeborne.selenide.Selenide.open;


/**
 * Created by Billy on 1/14/2017.
 */
public class TestBase {
    WebDriver driver;
    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
        driver.manage().window().maximize();
    }
    public VKStartPage onVKStartPage(){
        Configuration.baseUrl = "https://vk.com";
        VKStartPage vkStartPage = open("", VKStartPage.class);
        return vkStartPage  ;
    }
    @AfterMethod
    public void tearDown() throws Exception {
        if (driver != null)
            driver.quit();
    }
}
