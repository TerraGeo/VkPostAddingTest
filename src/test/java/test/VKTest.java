package test;

import org.testng.annotations.Test;

/**
 * Created by Billy on 1/14/2017.
 */
public class VKTest extends TestBase {
    @Test
    public void addPostsTest() throws Exception {
        onVKStartPage()
                .logIntoAccount()
                .choseYourCommunity()
                .addPosts(13);
    }
    @Test
    public void deleteFivePostsTest(){
        onVKStartPage()
                .logIntoAccount()
                .clickOnProfileTab()
                .deleteLastFivePosts();
    }

    @Test
    public void deleteAllPosts() throws Exception {
        onVKStartPage()
                .logIntoAccount()
                .clickOnProfileTab()
                .deleteAllPosts();
    }
}
