package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Billy on 1/14/2017.
 */
public class AccountPage {
    int SCROLL = 250;
    int timeToScroll = 2000;

    public AccountPage choseYourComunity(){
        $(By.xpath("//a[@href='/groups']")).click();
        $(By.xpath("//a[@class='group_row_title']"))
                .shouldBe(visible)
                .click();
        //Thread.sleep(1500);
        return this;
    }
    public AccountPage addPosts(int postsAmount) throws InterruptedException {
        ElementsCollection groups = $$(By.xpath("//i[@class='post_share_icon _icon']"));
        for (int i = 0; i < postsAmount; i++){
            groups.get(i).click();
            $(By.xpath("//button[@id='like_share_send']"))
                    .shouldBe(visible)
                    .click();
            Thread.sleep(5500);
        }
        return this;
    }
    public AccountPage clickOnProfileTab(){
        $(By.id("l_pr")).click();
        return this;
    }
    public AccountPage deleteAllPosts() throws InterruptedException {
        long curTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - curTime < timeToScroll) {
            ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                    .executeScript(String.format("scrollBy(0, %d)", SCROLL += 250));
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
        return this;
    }
    public AccountPage scrollToTheBottom(){
        long curTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - curTime < timeToScroll) {
            ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                    .executeScript(String.format("scrollBy(0, %d)", SCROLL += 250));
        }
        return this;
    }
    public AccountPage deleteLastFivePosts() throws InterruptedException {
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
        return this;
    }
}
