package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by Billy on 1/14/2017.
 */
public class AccountPage {

    public CommunityTab choseYourCommunity(){
        $(By.xpath("//a[@href='/groups']")).click();
        $(By.xpath("//a[@class='group_row_title']"))
                .shouldBe(visible)
                .click();
        return Selenide.page(CommunityTab.class);
    }

    public ProfileTab clickOnProfileTab(){
        $(By.id("l_pr")).click();
        return page(ProfileTab.class);
    }

}
