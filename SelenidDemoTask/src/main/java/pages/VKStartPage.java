package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Billy on 1/14/2017.
 */
public class VKStartPage {
    private static final String user = "+380678707396";
    private static final String password = "booksHas8Power";

    public AccountPage logIntoAccount(){
        $(By.id("index_email")).sendKeys(user);
        $(By.id("index_pass")).sendKeys(password);
        $(By.id("index_login_button")).click();
        return Selenide.page(AccountPage.class);
    }
}
