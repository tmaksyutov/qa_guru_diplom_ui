package drivers;

import com.codeborne.selenide.Configuration;
import config.WebConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;


public class WebDriverProvider {
    public static WebConfig config = ConfigFactory.create(WebConfig.class);
    public static void configure() {
        Configuration.baseUrl = config.baseUrl();
        Configuration.browser = config.browser();
        Configuration.browserSize = config.browserSize();
        Configuration.browserVersion = config.browserVersion();
        System.setProperty("chromeoptions.prefs","intl.accept_languages=ru");
        String configSource = config.remote();

        if (configSource != null) {
            String selenoidLogin = config.selenoidLogin(),
                    selenoidPassword = config.selenoidPassword();

            Configuration.remote = String.format("https://%s:%s@selenoid.autotests.cloud/wd/hub",
                    selenoidLogin, selenoidPassword);

            DesiredCapabilities capabilities = new DesiredCapabilities();
            Configuration.browserCapabilities = capabilities;
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }
    }

}
