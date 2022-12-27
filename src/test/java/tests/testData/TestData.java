package tests.testData;

import drivers.WebDriver;
import drivers.DriverUtils;

import static com.codeborne.selenide.Selenide.title;

public class TestData {

    public static final String
            baseUrl = "https://ufa.hh.ru",
            email = WebDriver.config.hhruEmail(),
            password = WebDriver.config.hhruPassword(),
            loginUrl = "https://ufa.hh.ru/account/login?backurl=%2F%3FcustomDomain%3D1&hhtmFrom=main",
            country = "Россия",
            vacancy = "QA",
            actualTitle = title(),
            expectedTitle = "Работа в Уфе, поиск персонала и публикация вакансий - ufa.hh.ru",
            consoleLogs = DriverUtils.getConsoleLogs(),
            errorText = "SEVERE",
            loginMassage = "Неправильные данные для входа. Пожалуйста, попробуйте снова.";

}
