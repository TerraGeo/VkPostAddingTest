package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static utils.Waiter.waitSomeTime;

/**
 * Created by Billy on 1/14/2017.
 */
public class CommunityTab {
    public CommunityTab addPosts(int postsAmount){
        ElementsCollection groups = $$(By.xpath("//i[@class='post_share_icon _icon']"));
        for (int i = 0; i < postsAmount; i++){
            groups.get(i).click();
            $(By.xpath("//button[@id='like_share_send']"))
                    .shouldBe(visible)
                    .click();
            waitSomeTime(6000);
        }
        return this;
    }
}
