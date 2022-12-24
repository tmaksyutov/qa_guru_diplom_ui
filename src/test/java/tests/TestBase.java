package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import config.TestsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static java.lang.String.format;

public class TestBase {

    @BeforeAll
    static void setUp() {
        TestsConfig config = ConfigFactory.create(TestsConfig.class, System.getProperties());

        String browserName = String.valueOf(config.browser());
        String browserVersion = config.version();
        String browserResolution = config.resolution();

        Configuration.browser = browserName;
        Configuration.browserVersion = browserVersion;
        Configuration.baseUrl = config.baseUrl();
        Configuration.browserSize = browserResolution;

        if (config.remote()) {
            String selenoidLogin = config.selenoidLogin(),
                    selenoidPassword = config.selenoidPassword();

            Configuration.remote = String.format("https://%s:%s@selenoid.autotests.cloud/wd/hub",
                    selenoidLogin, selenoidPassword);

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }

        Attach.attachAsText("Browser: ", browserName);
        Attach.attachAsText("Version: ", browserVersion);
        Attach.attachAsText("Remote: ", String.valueOf(config.remote()));
        Attach.attachAsText("Login: ", config.selenoidLogin());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}

