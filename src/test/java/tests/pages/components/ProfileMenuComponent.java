package tests.pages.components;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static helpers.DriverHelper.byTestId;

public class ProfileMenuComponent {
    public ProfileMenuComponent checkVisible() {
        $(byTestId("mainmenu_myResumes")).shouldBe(visible);

        return this;
    }
}
