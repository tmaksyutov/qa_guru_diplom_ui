package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static io.qameta.allure.Allure.step;

public class LoginTests extends TestBase {

    @Test
    @DisplayName("Успешная авторизация с помощью пароля")
    void successLoginWithPasswordTest() {
        step("Открыть страницу авторизации", () ->
                loginPage.openLoginPage());

        step("Выбрать авторизацию по паролю", () ->
                loginPage.selectLoginWithPassword());

        step("Ввести логин и пароль", () ->
                loginPage.setEmail()
                        .setPassword());

        step("Нажать на кнопку'Войти'", () ->
                loginPage.setLoginButton());

        step("Проверка отображения вкладки 'Мои резюме'", () ->
                loginPage.checkMyResumesMenuVisible());

    }

    @Test
    @DisplayName("Проверка валидационного сообщения при авторизации")
    void invalidLoginDataWithPasswordTest() {
        step("Открыть страницу авторизации", () ->
                loginPage.openLoginPage());

        step("Выбрать авторизацию по паролю", () ->
                loginPage.selectLoginWithPassword());

        step("Ввести невалидный логин и пароль", () ->
                loginPage.setInvalidEmail()
                        .setInvalidPassword());

        step("Проверить валидационное сообщение", () ->
                loginPage.checkLoginValidationMassage());

    }

}
