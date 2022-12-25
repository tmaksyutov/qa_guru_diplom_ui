package tests;

import drivers.WebDriver;
import drivers.DriverUtils;

import static com.codeborne.selenide.Selenide.title;


public class TestData {

    public static final String
            baseUrl = "https://ufa.hh.ru",
            email = WebDriver.config.hhruEmail(),
            password = WebDriver.config.hhruPassword(),
            invalidEmail = "timur@mail.ru",
            invalidPassword = "123456",
            loginUrl = "https://ufa.hh.ru/account/login?backurl=%2F%3FcustomDomain%3D1&hhtmFrom=main",
            country = "Россия",
            vacancy = "QA",
            actualTitle = title(),
            expectedTitle = "Вход в личный кабинет",
            consoleLogs = DriverUtils.getConsoleLogs(),
            errorText = "SEVERE",
            loginMassage = "Неправильные данные для входа. Пожалуйста, попробуйте снова.";

}
