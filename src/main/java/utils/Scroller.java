package utils;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;

/**
 * Created by Billy on 1/14/2017.
 */
public class Scroller {
    public static void scrollWithValue(int pixelStep, int timeToScrollMilis){
        int scroll = 250;
        long curTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - curTime < timeToScrollMilis) {
            ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                    .executeScript(String.format("scrollBy(0, %d)", scroll += pixelStep));
        }
    }
}
