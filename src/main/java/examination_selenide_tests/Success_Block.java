package examination_selenide_tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class Success_Block {

    private final static String SUCCESS_XPATH_LOCATOR = "//span[text()='Home']";

    private SelenideElement successHeader = $(By.xpath(SUCCESS_XPATH_LOCATOR));

    private SelenideElement nameUser = $(By.xpath("//a[contains(text(),'Hello')]"));

    private SelenideElement nameBlock = $(By.xpath("//h1[@class='svelte-1nppcz']"));

    @Step("проверка авторизации")
    public void checkCorrectAuthorization(String expectedName) {
        successHeader.shouldBe(Condition.visible);
        nameUser.shouldHave(text(expectedName));

        Assertions.assertAll(
                () -> successHeader.shouldBe(Condition.visible),
                () -> nameUser.shouldHave(text(expectedName))
        );
    }

    @Step("проверка отображения Блога с постами")
    public void checkBlockDisplay(String expectedBlock) {
        nameBlock.shouldHave(text(expectedBlock));
        Assertions.assertAll(
                () -> nameBlock.shouldHave(text(expectedBlock))
        );

    }

    @Step("проверка отсутствия авторизации")
    public void checkCorrectMissingAuthorization() {
        successHeader.shouldNotBe(Condition.visible);

        Assertions.assertAll(
                () -> successHeader.shouldNotBe(Condition.visible)
        );
    }

}
