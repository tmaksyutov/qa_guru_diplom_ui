package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:driver.properties"})
public interface TestsConfig extends Config {

    String selenoidLogin();

    String selenoidPassword();

    @DefaultValue("CHROME")
    String browser();

    @DefaultValue("106")
    String version();

    @DefaultValue("https://ufa.hh.ru")
    String baseUrl();

    @DefaultValue("1920x1080")
    String resolution();

    @DefaultValue("false")
    boolean remote();
}
