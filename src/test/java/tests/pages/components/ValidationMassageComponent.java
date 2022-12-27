package tests.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static helpers.DriverHelper.byTestId;
import static tests.data.TestData.*;


public class ValidationMassageComponent {

    public ValidationMassageComponent checkValidationMassage() {
        $(byTestId("account-login-error")).shouldHave(text(loginMassage));

        return this;
    }
}
