import org.testng.annotations.Test;

/**
 * Created by Billy on 1/14/2017.
 */
public class VKTest extends BaseTest {
    @Test
    public void firstTest() throws Exception {
        TestBase test = new TestBase();
        test.onVKStartPage()
                .logIntoAccount()
                .choseYourComunity()
                .addPosts(3);
    }
}
