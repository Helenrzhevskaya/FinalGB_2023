package examination_selenide_tests;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class Error_Block {
    private SelenideElement errorCode = $(By.xpath("//h2[text()='401']"));

    @Step("проверка ошибки авторизации")
    public void checkCorrectErrorCode(String expectedCode) {
        errorCode.shouldHave(text("401"));
        Assertions.assertAll(
                () -> errorCode.shouldHave(text(expectedCode))
        );
    }
}
