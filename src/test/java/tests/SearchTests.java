package tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchTests extends TestBase {

    @Test
    @DisplayName("Поиск работы")
    void jobSearchTest() {
        step("Open page", () ->
                open("https://ufa.hh.ru"));

        step("Set value", () ->
                $("#a11y-search-input").setValue("QA").pressEnter());

        step("Check vacancy", () ->
                $("#a11y-main-content").shouldHave(text("QA")));
    }

    @Test
    @DisplayName("Отображение сервисов для соискателей")
    void servicesShouldBeVisibleTest() {
        step("Открыть 'https://ufa.hh.ru/'", () ->
                open("https://ufa.hh.ru/"));

        step("Перейти в раздел 'Все сервисы'", () ->
                $(".supernova-overlay").$(byText("Все сервисы")).click());

        step("Проверка отображения блока 'Сервисы для соискателей'", () -> {
            $(".bloko-header-1").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Отображение дашборда")
    void dashboardShouldBeVisibleTest() {
        step("Открыть 'https://ufa.hh.ru/'", () ->
                open("https://ufa.hh.ru/"));

        step("Проверка отображения дашбоода", () -> {
            $(".dashboard-tiles-wrapper").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Проверка наличия главной страницы")
    void titleTest() {
        step("Открыть 'https://ufa.hh.ru/'", () ->
                open("https://ufa.hh.ru/"));

        step("Заголовок страницы имеет текст 'Работа в Уфе, поиск персонала и публикация вакансий - ufa.hh.ru'", () -> {
            String expectedTitle = "Работа в Уфе, поиск персонала и публикация вакансий - ufa.hh.ru";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

}
