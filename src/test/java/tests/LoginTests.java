package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.DriverHelper.byTestId;
import static io.qameta.allure.Allure.step;

public class LoginTests extends TestBase {

    @Test
    @DisplayName("Успешная авторизация с помощью пароля")
    void successLoginWithPasswordTest() {
        step("Открыть 'https://ufa.hh.ru/'", () ->
                open("https://ufa.hh.ru"));

        step("На главной странице нажать на кнопку 'Войти'", () ->
                $(byTestId("login")).click());

        step("Выбрать авторизацию по паролю", () ->
                $(byTestId("expand-login-by-password")).click());

        step("Ввести логин и пароль", () -> {
            $(byTestId("login-input-username")).setValue("dadojkeee@mail.ru");
            $(byTestId("login-input-password")).setValue("QWErty!@#$%^");
        });

        step("В форме авторизации нажать на кнопку 'Войти'", () ->
                $(byTestId("account-login-submit")).click());

        step("В меню профиля проверить отображение фамилии и имени пользователя", () -> {
            $(byTestId("mainmenu_applicantProfile")).click();
            $(byTestId("supernova-dropdown-content")).shouldHave(text("Тимур Максютов"));
        });

    }

    @Test
    @DisplayName("Невалидные данные при авторизации с помощью пароля")
    void invalidLoginDataWithPasswordTest() {
        step("Открыть 'https://ufa.hh.ru/'", () ->
                open("https://ufa.hh.ru"));

        step("На главной странице нажать на кнопку 'Войти'", () ->
                $(byTestId("login")).click());

        step("Выбрать авторизацию по паролю", () ->
                $(byTestId("expand-login-by-password")).click());

        step("Ввести логин и пароль", () -> {
                $(byTestId("login-input-username")).setValue("timur@mail.ru");
                $(byTestId("login-input-password")).setValue("Qwerty");
        });

        step("В форме авторизации нажать на кнопку 'Войти'", () ->
                $(byTestId("account-login-submit")).click());

        step("Проверить валидационное сообщение", () ->
                $(byTestId("account-login-error"))
                        .shouldHave(text("Неправильные данные для входа. Пожалуйста, попробуйте снова."))
        );

    }

}
