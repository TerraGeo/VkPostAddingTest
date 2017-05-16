package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static utils.Scroller.scrollWithValue;
import static utils.Waiter.waitSomeTime;

/**
 * Created by Billy on 1/14/2017.
 */
public class ProfileTab {
    public ProfileTab deleteAllPosts() {
        scrollWithValue(250, 2000);
        ElementsCollection actionMenues = $$(By
                .xpath("//div[@id='page_wall_posts']//div[starts-with(@onclick,'uiActionsMenu.keyToggle')]"));
        ElementsCollection deletePostButton = $$(By.xpath("//a[starts-with(@onclick,'wall.deletePost')]"));
        $("#stl_bg").click();
        waitSomeTime(1500);
        for (int i = 0; i < actionMenues.size(); i++) {
            actionMenues.get(i).shouldBe(visible).hover();
            deletePostButton.get(i).click();
            waitSomeTime(500);
        }
        return this;
    }
    public ProfileTab deleteLastFivePosts()  {
        scrollWithValue(250, 2000);
        ElementsCollection actionMenues = $$(By
                .xpath("//div[@id='page_wall_posts']//div[starts-with(@onclick,'uiActionsMenu.keyToggle')]"));
        ElementsCollection deletePostButton = $$(By.xpath("//a[starts-with(@onclick,'wall.deletePost')]"));
        $("#stl_bg").click();
        waitSomeTime(1500);
        for (int i = actionMenues.size() - 5; i < actionMenues.size(); i++) {
            actionMenues.get(i).shouldBe(visible).hover();
            deletePostButton.get(i).click();
            waitSomeTime(500);
        }
        return this;
    }
}
