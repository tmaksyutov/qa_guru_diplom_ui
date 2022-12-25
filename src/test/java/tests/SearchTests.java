package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static helpers.DriverHelper.byTestId;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @Test
    @DisplayName("Выбор страны поиска вакансий")
    void selectCountryJobSearchTest() {
        step("Open page", () ->
                open("https://ufa.hh.ru")
        );
        step("Перейти на страницу выбора региона", () ->
                $(byTestId("mainmenu_areaSwitcher")).click()
        );
        step("Выбор страны поиска", () ->
                $$(byTestId("area-switcher-title")).findBy(text("Россия")).click()
        );
        step("Проверка выбора региона", () ->
                $(byTestId("mainmenu_areaSwitcher")).shouldHave(text("Россия"))
        );

    }

    @Test
    @DisplayName("Поиск вакансий QA инженером")
    void jobSearchTest() {
        step("Открыть страницу", () ->
                open("https://ufa.hh.ru"));

        step("Ввести в поиск название вакансии", () ->
                $(byTestId("search-input")).setValue("QA").pressEnter());

        step("Проверить вакансии по заданному названию", () ->
                $(byTestId("serp-item__title")).shouldHave(text("QA")));
    }

    @Test
    @DisplayName("Проверка списка стран и городов")
    void countriesAndCitiesShouldBeVisibleTest() {
        step("Открыть старницу", () ->
                open("https://ufa.hh.ru")
        );

        step("Перейти на страницу выбора стран и городов", () ->
                $(byTestId("mainmenu_areaSwitcher")).click()
        );

        step("Проверить отображение списка стран и городов", () ->
                $(byTestId("area-switcher-welcome")).shouldBe(visible)
        );
    }

}
