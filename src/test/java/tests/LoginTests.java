package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static io.qameta.allure.Allure.step;
import static tests.data.TestData.*;
import static tests.data.UserData.*;

public class LoginTests extends TestBase {
    @Owner("Тимур Максютов")
    @Test
    @DisplayName("Успешная авторизация с помощью пароля")
    void successLoginWithPasswordTest() {
        step("Открыть страницу авторизации", () ->
                loginPage.openLoginPage());

        step("Выбрать авторизацию по паролю", () ->
                loginPage.selectLoginWithPassword());

        step("Ввести логин и пароль", () ->
                loginPage.setEmail(email)
                        .setPassword(password));

        step("Нажать на кнопку'Войти'", () ->
                loginPage.setLoginButton());

        step("Проверка отображения вкладки 'Мои резюме'", () ->
                loginPage.checkMyResumesMenuVisible());

    }

    @Owner("Тимур Максютов")
    @Test
    @DisplayName("Проверка сообщения об ошибке при авторизации c невалидными данными")
    void invalidLoginDataWithPasswordTest() {
        step("Открыть страницу авторизации", () ->
                loginPage.openLoginPage());

        step("Выбрать авторизацию по паролю", () ->
                loginPage.selectLoginWithPassword());

        step("Ввести невалидный логин и пароль", () ->
                loginPage.setInvalidEmail(invalidEmail)
                        .setInvalidPassword(invalidPassword));

        step("Проверить валидационное сообщение", () ->
                loginPage.checkLoginValidationMassage());

    }

}
