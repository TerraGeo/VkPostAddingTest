package pages;

import org.openqa.selenium.By;
import utils.PropertiesConfig;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by Billy on 1/14/2017.
 */
public class VKStartPage {

    public AccountPage logIntoAccount(){
        $(By.id("index_email")).sendKeys(PropertiesConfig.getInstance().getUserLogIn());
        $(By.id("index_pass")).sendKeys(PropertiesConfig.getInstance().getPassword());
        $(By.id("index_login_button")).click();
        return page(AccountPage.class);
    }
}
