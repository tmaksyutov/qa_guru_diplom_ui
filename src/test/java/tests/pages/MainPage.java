package tests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static helpers.DriverHelper.byTestId;
import static org.assertj.core.api.Assertions.assertThat;
import static tests.TestData.*;

public class MainPage {

    public SelenideElement
            areaButton = $(byTestId("mainmenu_areaSwitcher")),
            areaTitle = $(byTestId("area-switcher-title")),
            searchInput = $(byTestId("search-input")),
            itemTitle = $(byTestId("serp-item__title")),
            areaList = $(byTestId("area-switcher-welcome"));


    public MainPage openMainPage() {
        open(baseUrl);

        return this;
    }

    public MainPage checkConsoleLogs() {

        assertThat(consoleLogs).doesNotContain(errorText);

        return this;
    }

    public MainPage checkTitleHeader() {
        String actualTitle = title();
        assertThat(actualTitle).isEqualTo(expectedTitle);

        return this;
    }

    public MainPage checkJobSearchCountry() {

        areaButton.shouldHave(text(country));

        return this;
    }

    public MainPage setJobTitle() {
        searchInput.setValue(vacancy).pressEnter();

        return this;
    }

    public MainPage checkJobTitle() {
        itemTitle.shouldHave(text(vacancy));

        return this;
    }

    public MainPage checkListCountiesAndCitiesVisible() {
        areaList.shouldBe(visible);

        return this;
    }
}
