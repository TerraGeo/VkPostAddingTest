package utils;

import org.apache.commons.codec.binary.Base64;
import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;

/**
 * Created by Billy on 1/16/2017.
 */
@Resource.Classpath("test.properties")
public class PropertiesConfig {
    public static final PropertiesConfig INSTANCE = new PropertiesConfig();

    @Property("home.page")
    private String homePage;
    @Property("user.login")
    private String userLogIn;
    @Property("user.password")
    private  String password;

    private PropertiesConfig(){PropertyLoader.populate(this);}

    public static PropertiesConfig getInstance(){return INSTANCE;}

    public String getHomePage(){ return homePage;}

    public String getPassword() {
        return new String(Base64.decodeBase64(password));
    }

    public String getUserLogIn() {
        return userLogIn;
    }
}
