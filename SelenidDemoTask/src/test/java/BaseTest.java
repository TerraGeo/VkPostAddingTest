import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


/**
 * Created by Billy on 1/12/2017.
 */
public class BaseTest {
    String user = "+380678707396";
    String password = "booksHas8Power";
    String VK_START_URL = "https://vk.com";
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void addPostsTest() throws Exception {
        open(VK_START_URL);
        $(By.id("index_email")).sendKeys(user);
        $(By.id("index_pass")).sendKeys(password);
        $(By.id("index_login_button")).click();
        $(By.xpath("//a[@href='/groups']")).click();
        $(By.xpath("//a[@class='group_row_title']"))
                .shouldBe(visible)
                .click();
        //Thread.sleep(1500);
        ElementsCollection groups = $$(By.xpath("//i[@class='post_share_icon _icon']"));
        for (int i = 0; i < 2; i++){
            groups.get(i).click();
            $(By.xpath("//button[@id='like_share_send']"))
                    .shouldBe(visible)
                    .click();
            Thread.sleep(5500);
        }
    }
    @Test
    public void deleteAllPostsTest() throws InterruptedException{
        open(VK_START_URL);
        $(By.id("index_email")).sendKeys(user);
        $(By.id("index_pass")).sendKeys(password);
        $(By.id("index_login_button")).click();
        $(By.id("l_pr")).click();
        int SCROLL = 250;
        int timeToScroll = 2000;
        long curTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - curTime < timeToScroll) {
            ((JavascriptExecutor) driver).executeScript(String.format("scrollBy(0, %d)", SCROLL += 250));
        }
        ElementsCollection actionMenues = $$(By
                .xpath("//div[@id='page_wall_posts']//div[starts-with(@onclick,'uiActionsMenu.keyToggle')]"));
        ElementsCollection deletePostButton = $$(By.xpath("//a[starts-with(@onclick,'wall.deletePost')]"));
        $("#stl_bg").click();
        Thread.sleep(1500);
        for (int i = 0; i < actionMenues.size(); i++) {
            actionMenues.get(i).shouldBe(visible).hover();
            deletePostButton.get(i).click();
            Thread.sleep(500);
        }
    }

    @Test
    public void deleteLastFivePostsTest() throws Exception {
        open(VK_START_URL);
        $(By.id("index_email")).sendKeys(user);
        $(By.id("index_pass")).sendKeys(password);
        $(By.id("index_login_button")).click();
        $(By.id("l_pr")).click();
        int SCROLL = 250;
        int timeToScroll = 2000;
        long curTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - curTime < timeToScroll) {
            ((JavascriptExecutor) driver).executeScript(String.format("scrollBy(0, %d)", SCROLL += 250));
        }
        ElementsCollection actionMenues = $$(By.xpath("//div[@id='page_wall_posts']//div[starts-with(@onclick,'uiActionsMenu.keyToggle')]"));
        ElementsCollection deletePostButton = $$(By.xpath("//a[starts-with(@onclick,'wall.deletePost')]"));
        $("#stl_bg").click();
        for (int i = actionMenues.size() - 5; i < actionMenues.size(); i++) {
            actionMenues.get(i).hover();
            deletePostButton.get(i).click();
            Thread.sleep(500);
        }
    }


    @AfterMethod
    public void tearDown() throws Exception {
        if (driver != null)
            driver.quit();
    }
}
