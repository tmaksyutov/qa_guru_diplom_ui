package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:driver.properties"
})
public interface WebConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://ufa.hh.ru")
    String baseUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("browserVersion")
    String browserVersion();

    @Key("remote")
    @DefaultValue("false")
    String remote();

    String selenoidLogin();

    String selenoidPassword();

}


