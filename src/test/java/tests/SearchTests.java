package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @Test
    @DisplayName("Выбор страны поиска вакансий")
    void selectCountryJobSearchTest() {
        step("Открыть главную страницу", () ->
                mainPage.openMainPage());

        step("Перейти на страницу выбора стран и городов", () ->
                mainPage.areaButton.click()
        );
        step("Выбор страны поиска", () ->
                mainPage.areaTitle.click()
        );
        step("Проверка выбранной страны поиска", () ->
                mainPage.checkJobSearchCountry()
        );

    }

    @Test
    @DisplayName("Поиск вакансий")
    void jobSearchTest() {
        step("Открыть страницу", () ->
                mainPage.openMainPage());

        step("Ввести в поиск название вакансии", () ->
                mainPage.setJobTitle());

        step("Проверить вакансии по заданному названию", () ->
                mainPage.checkJobTitle());
    }

    @Test
    @DisplayName("Проверка списка стран и городов")
    void countriesAndCitiesShouldBeVisibleTest() {
        step("Открыть старницу", () ->
                mainPage.openMainPage());

        step("Перейти на страницу выбора стран и городов", () ->
                mainPage.areaButton.click()
        );

        step("Проверить отображение списка стран и городов", () ->
                mainPage.checkListCountiesAndCitiesVisible());
    }

}
