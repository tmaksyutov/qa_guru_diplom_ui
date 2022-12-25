package tests;

import helpers.DriverUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPageTests extends TestBase {

    @Test
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://ufa.hh.ru'", () ->
                open("https://ufa.hh.ru"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @Test
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Открыть 'https://ufa.hh.ru/'", () ->
                open("https://ufa.hh.ru/"));

        step("Page title should have text 'Работа в Уфе, поиск персонала и публикация вакансий - ufa.hh.ru'", () -> {
            String expectedTitle = "Работа в Уфе, поиск персонала и публикация вакансий - ufa.hh.ru";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }
}
