package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class MainPageTests extends TestBase {
    @Test
    @DisplayName("Проверка ошибок в Console")
    void consoleShouldNotHaveErrorsTest() {
        step("Открыть страницу", () ->
                mainPage.openMainPage());

        step("Проверка логов в консоли с значением 'SEVERE'", () ->
                mainPage.checkConsoleLogs());
    }

    @Test
    @DisplayName("Проверка названия главной страницы")
    void titleTest() {
        step("Открыть страницу'", () ->
                mainPage.openMainPage());

        step("Название главной страницы 'Работа в Уфе, поиск персонала и публикация вакансий - ufa.hh.ru'", () ->
                mainPage.checkTitleHeader());
    }

}
