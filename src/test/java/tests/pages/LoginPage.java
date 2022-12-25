package tests.pages;

import com.codeborne.selenide.SelenideElement;
import tests.pages.components.ProfileMenuComponent;
import tests.pages.components.ValidationMassageComponent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.DriverHelper.byTestId;
import static tests.TestData.*;

public class LoginPage {

    private final ProfileMenuComponent profileMenuComponent = new ProfileMenuComponent();
    private final ValidationMassageComponent validationMassageComponent = new ValidationMassageComponent();

    SelenideElement
            loginByPasswordButton = $(byTestId("expand-login-by-password")),
            userNameInput = $(byTestId("login-input-username")),
            passwordInput = $(byTestId("login-input-password")),
            validationMassage = $(byTestId("account-login-error")),
            applicantProfileButton = $(byTestId("mainmenu_applicantProfile"));


    public LoginPage openLoginPage() {
        open(loginUrl);

        return this;
    }

    public LoginPage selectLoginWithPassword() {
        loginByPasswordButton.click();

        return this;
    }

    public LoginPage setEmail() {
        userNameInput.setValue(email);

        return this;
    }

    public LoginPage setPassword() {
        passwordInput.setValue(password).pressEnter();

        return this;
    }

    public LoginPage setInvalidEmail() {
        userNameInput.setValue(invalidEmail);

        return this;
    }

    public LoginPage setInvalidPassword() {
        passwordInput.setValue(invalidPassword).pressEnter();

        return this;
    }

    public LoginPage setApplicantProfileButton() {
        applicantProfileButton.click();

        return this;
    }

    public LoginPage checkApplicantProfileMenuVisible() {
        profileMenuComponent.checkVisible();

        return this;
    }

    public LoginPage checkLoginValidationMassage() {
        validationMassageComponent.checkValidationMassage();

        return this;
    }

}